package de.hd.gmbh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSuite implements Module
{
   public WebDriver driver = null;

   public LoginSuite(WebDriver driver)
   {
      this.driver = driver;
   }
   
   public void processLogin(String userName, String password) throws Exception {
      //Open Login page
      driver.findElement(By.className("LoginContent")).click();
      
      //click registration by user name/password
      driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/form/div/button[1]")).click();
      
      //input username
      WebElement userNameEl =  Util.fluentWait(By.name("j_username"), driver, 30, 5);
      userNameEl.sendKeys(userName);
      
      driver.findElement(By.name("j_password")).sendKeys(password);
      
      //login
      driver.findElement(By.name("_eventId_proceed")).click();
      
   }

}
