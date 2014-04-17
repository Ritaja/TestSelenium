/**
 * 
 */
package testPclass;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import excelManipulations.ReaderImpl;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ritaja Sengupta
 *
 */
public class navigationAuto {

	/**
	 * @throws java.lang.Exception
	 */
	static WebDriver driver;
	public WebElement element;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String selectType;
	static String selectPhotometerType;
	static String parsename;
	
	@Rule 
	public TestName name = new TestName();
	static String selectItem;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		  System.out.println("Please enter type of photometer to select: ");
		  selectPhotometerType = br.readLine();
		  System.out.println("Please enter type (eg: nucleic acid) to select: ");
		  selectType = br.readLine();
          System.out.println("Please enter parameter to select: ");
          selectItem = br.readLine();
          parsename = "TC_"+selectPhotometerType+"_"+selectType+"_"+selectItem+"_"+"parameters";
          System.out.println("Being parsed: "+parsename);
		  System.setProperty("webdriver.chrome.driver", "Lib/chromedriver.exe");
          driver = new ChromeDriver();
          driver.get("http://profectus/NanoSenchaTouch2.1.1%20(Sprint%2030%2014-04-14)/index-debug.html?demo=On&client=Desktop");
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          selectPhotometerType = "//div[text()='" + selectPhotometerType + "']";
          WebElement element = driver.findElement(By.xpath(selectPhotometerType));
           //WebElement element = driver.findElement(By.xpath("//div[text()='P-Class']"));
          //WebElement element = driver.findElement(By.xpath("//div[contains(@id,'ext-element-40')]"));
          element.click();
	}

	/**
	 * @throws java.lang.Exception
	 */
	/*@AfterClass
	public static void tearDownAfterClass() throws Exception {
		 driver.quit();
	}*/

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Thread.sleep(1000);
        System.out.println("setup called now"+driver.getWindowHandle());
        selectType = "//div[text()='" + selectType + "']";
        System.out.println("search element: "+selectType);
        WebElement elementbef = driver.findElement(By.xpath(selectType));
        //WebElement elementbef = driver.findElement(By.xpath("//div[text()='Nucleic Acid']"));
        elementbef.click();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		 WebElement elementaft = driver.findElement(By.xpath("//span[contains(@class,'home')]"));
         elementaft.click();
         Thread.sleep(1000);
	}

	@Test
	public void test() throws InterruptedException, IOException {
		Thread.sleep(1000);
		System.out.println("in test0");
          WebElement selectorElement = driver.findElement(By.xpath("//div[contains(@id,'ext-element-455')]"));
          selectorElement.click();
          selectItem = "//span[text()='" + selectItem + "']";
          System.out.println(selectItem);
          Thread.sleep(1000);
          selectorElement  = driver.findElement(By.xpath(selectItem));
          //selectorElement  = driver.findElement(By.xpath("//span[text()='ssDNA']"));
          selectorElement.click();
        try {
        
        } catch (NoSuchElementException e) { 
            System.out.println("jammed!!");
        }
        
        
        Thread.sleep(1000);
        System.out.println(name.getMethodName());
        
        ReaderImpl ex = new ReaderImpl("Parameters.xlsx");
        //ArrayList paramList = ex.getParams(name.getMethodName());
        ArrayList paramList = ex.getParams(parsename);
        ListIterator li = paramList.listIterator();
        boolean finalassert = true;
        while(li.hasNext()){
                        String str = li.next().toString().trim();
                        
                        
                        try {
                                        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
                                        
                                         driver.findElement(By.xpath("//span[text()='"+str+"']"));
                                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                                        System.out.println(str);
                                        finalassert = finalassert && true; 
                                          } catch (NoSuchElementException ignored) {
                                                          System.out.println(str);
                                                        
                                                          finalassert = false  ; 
                                                          System.out
																.println("false: "+str);
                                                         
                                                          
                                          }
                        
                        
        }
        System.out.println(finalassert);
        assertTrue(finalassert);
	}
	


}
