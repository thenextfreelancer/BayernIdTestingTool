package de.hd.gmbh;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import de.hd.gmbh.gmail.GmailLogin;

public class BayernPortalMain
{
   public static WebDriver driver;
   
   public static String chromeIdentifier = "--chrome=";
   
   public static String mozIdentifier = "--firefox=";
   
   public static RegistrationSuite suite;
   
   public By errorMsgBlock = By.className("ErrorMessageBlock");
   
   @SuppressWarnings("resource")
   @BeforeClass(alwaysRun = true)
   public void setUp() throws Exception
   {
      System.out.println("Please choose browser type:");
      System.out.println("1 - Chrome");
      System.out.println("2 - Firefox");
      System.out.println("3 - Safari");
      Util.giveSpaceInLogs(2);
      System.out.print("Please input option:");
      Scanner browserTypeScan = new Scanner(System.in);
      String browserType= browserTypeScan.nextLine();
      
      switch(browserType) {
      case "1":
         System.out.println("App will run on Chrome.");
         System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
         driver = new ChromeDriver();
         break;
      case "2":
         System.out.println("App will run on Firefox.");
         System.setProperty("webdriver.gecko.driver", "lib//geckodriver.exe");
         driver = new FirefoxDriver();
         break;
      default:
         System.out.println("This option is not supported. System will exit.");
         throw new Exception("Invalid input.");
      }
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      suite = new RegistrationSuite();
      suite.init();
   }
   
//   public static void main(String args[]) {
//      System.setProperty("webdriver.chrome.driver", args[0]);
//      driver = new ChromeDriver();
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      driver.manage().window().maximize();
//      register();
//   }

   @Test(priority=1)
   public void test_familien_name()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data1"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[2]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=2)
   public void test_Vorname()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data2"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[3]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=3)
   public void test_Geburtsname()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data3"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[4]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=4)
   public void test_Geburtsdatum()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data4"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[7]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=5)
   public void test_Geburtsort()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data5"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[8]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=5)
   public void test_E_Mail_Adresse()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data6"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[9]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=7)
   public void test_E_Mail_Adresse_wiederholen()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data7"));
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         Assert.assertNotEquals(registerForm.findElement(By.xpath("form/span[10]")).getText(), "");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   @Test(priority=8)
   public void test_all_data()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data8")); // real data
   }
   
   @Test(priority=9)
   public void open_gmail()
   {
      GmailLogin gmail = new GmailLogin();
      gmail.setUp();
      gmail.login();
   }
   
   @AfterClass(alwaysRun = true)
   public void tearDown()
   {
      driver.quit();
   }

}