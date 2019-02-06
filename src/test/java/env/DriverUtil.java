package env;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    
    protected static WebDriver driver;
    static String currentPath = System.getProperty("user.dir");
    static Properties prop = new Properties();
    static DesiredCapabilities capability=null;
    
    public static DesiredCapabilities getCapability(InputStream input) {
    	DesiredCapabilities capability = new DesiredCapabilities();
    	try {
    		prop.load(input);
    		if(prop.containsKey("app")) {
    			String appName = prop.getProperty("app");
    			if(!appName.contains("sauce-storage")) {
    				String appPath = currentPath+"/src/main/java/appUnderTest/"+appName;
    				prop.setProperty("app", appPath);
    			}
    		}
    		
    		// set capabilities
    		Enumeration<Object> enuKeys = prop.keys();
    		while (enuKeys.hasMoreElements()) {
    			String key = (String) enuKeys.nextElement();
    			String value = prop.getProperty(key);
    			capability.setCapability(key, value);
    		}
    		input.close();
    	}catch(Exception e) {
    		e.printStackTrace();
			System.exit(0);
    	}
    	return capability;
    }
    
   

	public static WebDriver getDefaultDriver() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    return driver;
    }

 

    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector,
                                                            int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

	public static void closeDriver() {
		if (driver != null) {
			try {
				//driver.close();
				//driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {} // in case close fails
			driver = null;
		}
	}
}
