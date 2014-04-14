/**
 * 
 */
package testPclass;



import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select; 

import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

import excelManipulations.ReaderImpl;

/**
 * @author Shruthi Padma
 *
 */
public class TC_pClass_NV_NA_ParameterTab {

	 static WebDriver driver;
	 WebElement element1;
	/**
	 * @throws java.lang.Exception
	 * Initialisation of the chrome web driver
	 */
	 @Rule 
	 public TestName name = new TestName();
	@BeforeClass
	public static void setUpBeforeClass() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Lib/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://profectus/NanoSenchaTouch2.1.1%20(Sprint%2030%2012-04-14)/index-debug.html?demo=On&client=Desktop");
		 driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		 
		 
		 WebElement element = driver.findElement(By.xpath("//div[text()='P-Class']"));
		element.click();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws InterruptedException {
		driver.quit();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		Thread.sleep(1000);
		element1 = driver.findElement(By.xpath("//div[text()='Nucleic Acid']"));
		element1.click();
		Thread.sleep(1000);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		element1 = driver.findElement(By.xpath("//span[contains(@class,'home')]"));
        element1.click();
        Thread.sleep(1000);
	}

	@Test
	public void TC_pClass_NV_NA_dsDNA_parameters() throws InterruptedException, IOException {
		Thread.sleep(1000);
		try {
            //trying to get the "select option"
            //WebElement elementOfInterest = driver.findElement(By.xpath("//div[contains(@id,'ext-thumb-3')]"));
			WebElement elementOfInterest = driver.findElement(By.xpath("//div[contains(@id,'ext-input-12')]"));
            //this would select the option
//			JavascriptLibrary javascript = new JavascriptLibrary();
//            javascript.callEmbeddedSelenium(driver, "triggerMouseEventAt", elementOfInterest, "click", "0,0");
			elementOfInterest.click();
                        //driver.findElement(By.id("ext-element-629")).click();
                        //System.out.println("Done!");
             //Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@id,'ext-input-12')]"))); 
			 
            WebElement elementOfInterest1 = driver.findElement(By.xpath("//div[contains(@id,'ext-listitem-17')]"));
            //actions sequence
            Actions clickable = new Actions(driver);
            clickable.click(elementOfInterest1).perform();;
//            JavascriptLibrary javascript = new JavascriptLibrary();
//            javascript.callEmbeddedSelenium(driver, "triggerMouseEventAt", elementOfInterest1, "click", elementOfInterest.getLocation().toString());
            System.out.println("element: "+elementOfInterest1.isSelected());
            Thread.sleep(1000);
            //elementOfInterest1.click();
            //Select dropdown = new Select(driver.findElement(By.xpath("//div[contains(@id,'ext-element-619')]")));
            //dropdown.deselectAll();
            
            
            
        } catch (NoSuchElementException e) { 
            System.out.println("jammed!!");
        }
		Thread.sleep(1000);
		System.out.println(name.getMethodName());
		
		ReaderImpl ex = new ReaderImpl("Parameters.xlsx");
		ArrayList paramList = ex.getParams(name.getMethodName());
		ListIterator li = paramList.listIterator();
		boolean finalassert = true;
		while(li.hasNext()){
			String str = li.next().toString().trim();
			
			
			 try {
				 driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				 System.out.println(str);
				 driver.findElement(By.xpath("//span[text()='"+str+"']"));
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
				 finalassert = finalassert & true; 
				  } catch (NoSuchElementException ignored) {
					  System.out.println(str);
					  finalassert = finalassert & false; 
				  }
			
			
		}
		assert(finalassert);
	}
}
