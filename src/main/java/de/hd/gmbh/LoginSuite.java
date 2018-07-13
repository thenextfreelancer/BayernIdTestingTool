package de.hd.gmbh;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

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
   
   public void processLoginWithUserNamePassword(String userName, String password) throws Exception {
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
   
   public void processLoginWithCertificate(String certPath, String pin) throws Exception {
      
      //Open Login page
      driver.findElement(By.className("LoginContent")).click();
      
      //click registration by user name/password
      driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/form/div/button[3]")).click();
      
      driver.findElement(By.name("_eventId_proceed")).click();
      
      String currentWindow = driver.getWindowHandle();
      driver.switchTo().window(currentWindow);
      
      driver.findElement(By.id("fileChoiceButton")).click();
      
      Thread.sleep(5000);
      
      StringSelection s = new StringSelection(certPath);
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
      Robot robot = new Robot();

      robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
      robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
      robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
      robot.keyPress(java.awt.event.KeyEvent.VK_V);
      robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
      Thread.sleep(3000);
      robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);

      // switch back
      driver.switchTo().activeElement();
      
      driver.findElement(By.id("enterPIN")).sendKeys(pin);
      
      driver.findElement(By.id("defaultbutton")).click();
   }

}
