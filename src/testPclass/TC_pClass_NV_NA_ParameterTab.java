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
import org.openqa.selenium.support.ui.Select;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
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
                                driver.get("http://profectus/NanoSenchaTouch2.1.1%20(Sprint%2030%2014-04-14)/index-debug.html?demo=On&client=Desktop");
                                driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
                                
                                 
                                 //WebElement element = driver.findElement(By.xpath("//div[text()='P-Class']"));
                                WebElement element = driver.findElement(By.xpath("//div[contains(@id,'ext-element-40')]"));
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
                
                @Before
                public  void setUp() throws Exception {
                                Thread.sleep(1000);
                                
                                System.out.println("Inside Before");
                                
                                Thread.sleep(1000);
                }
    */
                
                /**
                * @throws java.lang.Exception
                
                @After
                public   void tearDown() throws Exception {
                                
                                
                                WebElement elementaft = driver.findElement(By.xpath("//span[contains(@class,'home')]"));
                                elementaft.click();
        Thread.sleep(1000);
                } */

                @Test
                public void TC_pClass_NV_NA_dsDNA_parameters() throws InterruptedException, IOException {
                                Thread.sleep(1000);
                                
                                WebElement elementbef = driver.findElement(By.xpath("//div[text()='Nucleic Acid']"));
                                elementbef.click();
                                
                                Thread.sleep(1000);
                                
                                WebElement selectorElement = driver.findElement(By.xpath("//div[contains(@id,'ext-element-455')]"));
                                selectorElement.click();
                                  selectorElement  = driver.findElement(By.xpath("//span[text()='dsDNA']"));
                                selectorElement.click();
                                try {
                                
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
                                                                
                                                                 driver.findElement(By.xpath("//span[text()='"+str+"']"));
                                                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                                                                System.out.println(str);
                                                                finalassert = finalassert && true; 
                                                                  } catch (NoSuchElementException ignored) {
                                                                                  System.out.println(str);
                                                                                
                                                                                  finalassert = false  ; 
                                                                                 
                                                                                  
                                                                  }
                                                
                                                
                                }
                                System.out.println(finalassert);
                                assertTrue(finalassert);
                }
                
                @Test
                public void TC_pClass_NV_NA_ssDNA_parameters() throws InterruptedException, IOException {
                /*           Thread.sleep(10000);
                                System.out.println("1");
                                WebElement elementbef = driver.findElement(By.xpath("//div[text()='Nucleic Acid']"));
                                System.out.println("2");
                                Thread.sleep(10000);
                                elementbef.click();
                                System.out.println("3");
                                Thread.sleep(1000);
                                System.out.println("4");
                                */
                                WebElement selectorElement = driver.findElement(By.xpath("//div[contains(@id,'ext-element-455')]"));
                                selectorElement.click();
                                
                                selectorElement  = driver.findElement(By.xpath("//span[text()='ssDNA']"));
                                selectorElement.click();
                                try {
                                
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
                                                                
                                                                 driver.findElement(By.xpath("//span[text()='"+str+"']"));
                                                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                                                                System.out.println(str);
                                                                finalassert = finalassert && true; 
                                                                  } catch (NoSuchElementException ignored) {
                                                                                  System.out.println(str);
                                                                                
                                                                                  finalassert = false  ; 
                                                                                 
                                                                                  
                                                                  }
                                                
                                                
                                }
                                System.out.println(finalassert);
                                assertTrue(finalassert);
                }
                @Test
                public void TC_pClass_NV_NA_RNA_parameters() throws InterruptedException, IOException {

                                WebElement selectorElement = driver.findElement(By.xpath("//div[contains(@id,'ext-element-455')]"));
                                selectorElement.click();
                                
                                selectorElement  = driver.findElement(By.xpath("//span[text()='RNA']"));
                                selectorElement.click();
                                try {
                                
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
                                                                
                                                                 driver.findElement(By.xpath("//span[text()='"+str+"']"));
                                                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                                                                System.out.println(str);
                                                                finalassert = finalassert && true; 
                                                                  } catch (NoSuchElementException ignored) {
                                                                                  System.out.println(str);
                                                                                
                                                                                  finalassert = false  ; 
                                                                                 
                                                                                  
                                                                  }
                                                
                                                
                                }
                                System.out.println(finalassert);
                                assertTrue(finalassert);
                }
                
                //@Test
                /*public void TC_pClass_NV_NA_OligoSequence_parameters() throws InterruptedException, IOException {

                                WebElement selectorElement = driver.findElement(By.xpath("//div[contains(@id,'ext-element-455')]"));
                                selectorElement.click();
                                
                                selectorElement  = driver.findElement(By.xpath("//span[text()='Oligosequence']"));
                                selectorElement.click();
                                try {
                                
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
                                                                
                                                                 driver.findElement(By.xpath("//span[text()='"+str+"']"));
                                                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                                                                System.out.println(str);
                                                                finalassert = finalassert && true; 
                                                                  } catch (NoSuchElementException ignored) {
                                                                                  System.out.println(str);
                                                                                
                                                                                  finalassert = false  ; 
                                                                                 
                                                                                  
                                                                  }
                                                
                                                
                                }
                                System.out.println(finalassert);
                                assertTrue(finalassert);
                } */
}
