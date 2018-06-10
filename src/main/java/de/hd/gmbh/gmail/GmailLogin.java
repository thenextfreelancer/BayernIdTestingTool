package de.hd.gmbh.gmail;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import de.hd.gmbh.BayernPortalMain;
import de.hd.gmbh.Util;

public class GmailLogin
{
   private WebDriver driver;

   private final String baseUrl = "https://www.gmail.com";
   
   private GmailUtil gutil = null;
   
   public static String emailSubject = "Fiverr";
   
   public void setUp()
   {
      driver = BayernPortalMain.driver;
      gutil = new GmailUtil();
   }

   public void login()
   {
      Util.giveSpaceInLogs(5);
      System.out.println("/////////////////////////////////////////////////////////");
      System.out.println("            Welcome to the Gmail Utitlity                ");
      System.out.println("/////////////////////////////////////////////////////////");
      Util.giveSpaceInLogs(2);
      start();
   }

  
   private void start() {
      
      try {
            //Step 1: Open the URL
            driver.get(baseUrl);
            
            //Step 2: Fill the data to Gmail login and proceed till OTP
            String userName = getGmailUserId();
            String password = getGmailPassword();
            emailSubject = getRegistrationSubject();
            
            gutil.fillUserNameAndNext(driver, userName);
            gutil.fillPassword(driver, password);
            
            //Step 3: Wait for a particular time for the OTP
            
            WebElement emailUI = Util.fluentWait(By.className("UI"), driver, 100, 5);
            
            List<WebElement> emailList = emailUI.findElements(By.xpath("div/div[1]/div[2]/div/table/tbody/tr"));
            
            //no email
            boolean passed = false;
            
            //Just checking recent 5 emails for the registration mail
            for(int ii=0; ii< 5; ii++) {
               WebElement el = emailList.get(ii);
               String txt = el.findElement(By.xpath("td[6]")).findElement(By.className("bog")).getText();
               if(emailSubject.contains(txt)) {
                  passed = true;
                  break;
               }
            }
            
            if(!passed) {
               Assert.assertTrue(false);
            }
         
      } catch(Exception e) {
         e.printStackTrace();
      }
      
      
   }
   
   @SuppressWarnings("resource")
   private String getGmailUserId() {
      Util.giveSpaceInLogs(5);
      System.out.println("Please input gmail user id:");
      Scanner s = new Scanner(System.in);
      return s.nextLine().trim();
   }
   
   @SuppressWarnings("resource")
   private String getGmailPassword() {
      Util.giveSpaceInLogs(5);
      System.out.println("Please input gmail password:");
      Scanner s = new Scanner(System.in);
      return s.nextLine().trim();
   }
   
   @SuppressWarnings("resource")
   private String getRegistrationSubject() {
      Util.giveSpaceInLogs(5);
      System.out.println("Please provide your registration email subject(part of subject will work as well) so that this app can search for that subject and verify the email:");
      Scanner s = new Scanner(System.in);
      return s.nextLine().trim();
   }

}
