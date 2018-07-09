package de.hd.gmbh;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BayernPortalMain
{
   public static WebDriver driver;
   
   public final String baseUrl = "https://infra-pre.buergerserviceportal.de/bayern/freistaat";
   
   public static String chromeIdentifier = "--chrome=";
   
   public static String mozIdentifier = "--firefox=";
   
   public static RegistrationSuite registrationSuite;
   
   public static LoginSuite loginSuite;
   
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
   }
   
   @Test
   public void initSuite() throws Exception {
      
      /**
       * Registration Process
       */
      
      //init
      registrationSuite = new RegistrationSuite(driver);
      
      //Open base url
      driver.get(baseUrl);
      
      //Open registration module
      Util.scrollWindow(driver);
      driver.findElement(By.xpath("//*[@id=\"UIPage\"]/div/div/div[1]/div/div/div[2]/span/div[2]/a")).click();
      
      //Open registration page
      registrationSuite.openRegisterPage();
      
      //Fill registration and submit
      String excelFileLocation = "input/input.xlsx";
      List<RegistrationEntity> registrationDataList = new ExcelReader(excelFileLocation).getRegistrationDataList();
      
      registrationSuite.fillRegisterInfoAndSubmit(registrationDataList.get(0));
      
      //verify submitted page
//      registrationSuite.verifySubmittedPage();
      
      Thread.sleep(20000);
      //Open Gmail for email verification
      registrationSuite.open_gmail();
      
      System.out.println("Press any key to start login automation:");
      @SuppressWarnings("resource")
      Scanner option = new Scanner(System.in);
      option.nextLine();
      
      /**
       * Login Process
       */
      // Open landing page
      loginSuite = new LoginSuite(driver);
      driver.get(baseUrl);
      
      //Login process
      Util.scrollWindow(driver);
      loginSuite.processLogin(registrationDataList.get(0).getBenutzername(), registrationDataList.get(0).getPasswort());
      
      Thread.sleep(20000);
   }
   
   
   @AfterClass(alwaysRun = true)
   public void tearDown()
   {
      driver.quit();
   }

}