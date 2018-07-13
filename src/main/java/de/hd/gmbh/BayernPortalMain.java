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
      System.out.println("Please select in below options:");
      System.out.println("Press 1 for Registration Module.");
      System.out.println("Press 2 for Login Module.");
      boolean loop1 = true;
      int moduleSwitch = 1;
      while(loop1) {
         System.out.println("Choose option and press <Enter>:");
         @SuppressWarnings("resource")
         Scanner moduleSwitchS = new Scanner(System.in);
         try {
            moduleSwitch = moduleSwitchS.nextInt();
            loop1 = false;
         } catch(Exception e){
            System.out.println("Wrong input!!");
         }
      }
      
      init(moduleSwitch);
   }
   
   public void init(int moduleSwitch) throws Exception {
      
      if(moduleSwitch == 1) {
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
         boolean status = registrationSuite.isRegisterPageHasErrors();
         if(status) {
            System.out.println("**********************");
            System.out.println("ERROR: Register page has some errors. Please correct and run the app again.");
            System.out.println("**********************");
         } else {
            Thread.sleep(5000);
            //Open Gmail for email verification
            registrationSuite.open_gmail(registrationDataList.get(0).getEmail());
         }
         
         
         
      } else if(moduleSwitch == 2){
         
         /**
          * Login Process
          * 
          * Two processes:
          * 1. Login by username/password
          * 2. Login by authentication certification
          */
         
         //Let's ask user to choose between processes
         System.out.println("Choose your login method:");
         System.out.println("1 for login with user name/ password.");
         System.out.println("2 for login with certificate.");
         int loginChoice = 0;
         boolean loop2 = true;
         while(loop2) {
            System.out.println("Choose option and press <Enter>:");
            @SuppressWarnings("resource")
            Scanner loginChoiceS = new Scanner(System.in);
            try {
               loginChoice = loginChoiceS.nextInt();
               loop2 = false;
            } catch(Exception e){
               System.out.println("Wrong input!!");
            }
         }
         
         // Open landing page
         loginSuite = new LoginSuite(driver);
         driver.get(baseUrl);
         
         //Login process
         Util.scrollWindow(driver);
         
         if(loginChoice == 1) {
            System.out.println("Enter user name:");
            @SuppressWarnings("resource")
            Scanner userNameS = new Scanner(System.in);
            String userName = userNameS.nextLine();
            
            System.out.println("Enter password:");
            @SuppressWarnings("resource")
            Scanner passS = new Scanner(System.in);
            String pass = passS.nextLine();
            
            loginSuite.processLoginWithUserNamePassword(userName, pass);
         } else {
            System.out.println("For login with certificate, please enter certificate path on your system:");
            @SuppressWarnings("resource")
            Scanner certPathS = new Scanner(System.in);
            String certPath = certPathS.nextLine();
            
            System.out.println("For login with certificate, please enter PIN for certificate:");
            @SuppressWarnings("resource")
            Scanner pinS = new Scanner(System.in);
            String pin = pinS.nextLine();
            
            loginSuite.processLoginWithCertificate(certPath, pin);
         }
      }
   }
   
   @AfterClass(alwaysRun = true)
   public void tearDown() throws InterruptedException
   {
      Thread.sleep(20000);
      driver.quit();
   }
   
}