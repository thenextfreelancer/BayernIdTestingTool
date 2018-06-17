/**
 * 
 */
package de.hd.gmbh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Moksh
 *
 */
public class RegistrationSuite implements Module
{
   
   public WebDriver driver = null;
   
   public final String registerLink = "https://infra-pre.buergerserviceportal.de/bayern/freistaat/register-authega";
   
   public void init()
   {
      driver = BayernPortalMain.driver;
      driver.get(registerLink);
//      openRegisterPage(driver);
   }
   
   public void openRegisterPage(WebDriver driver) {
      try
      {
         Util.scrollWindow(driver);
         WebElement registerForm = driver.findElement(By.className("RegisterPage"));
         registerForm.findElement(By.xpath("form/input[2]")).click();
         Thread.sleep(1000);
         
         
         driver.findElement(By.id("registersubmitID")).click();
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void fillRegisterInfoAndSubmit(RegistrationEntity data) {
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         List<WebElement> checkboxList = registerForm.findElement(By.className("RadioInputContainer")).findElements(By.tagName("input"));
         if("male".equals(data.getGender()))
            checkboxList.get(0).click();
         else 
            checkboxList.get(1).click();
         
         //for Familienname
         WebElement e1 = registerForm.findElement(By.xpath("form/input[2]"));
         e1.clear();
         e1.sendKeys(data.getFamilienname());
         
         //for Vorname
         WebElement e2 = registerForm.findElement(By.xpath("form/input[3]"));
         e2.clear();
         e2.sendKeys(data.getVorname());
         
         //for Geburtsname
         WebElement e3 = registerForm.findElement(By.xpath("form/input[4]"));
         e3.clear();
         e3.sendKeys(data.getGeburtsname());
         
         //for Geburtsname
         WebElement e9 = registerForm.findElement(By.xpath("form/input[5]"));
         e9.clear();
         e9.sendKeys("Weitere Titel");
         
         //for Geburtsdatum
         WebElement e4 = registerForm.findElement(By.xpath("form/input[6]"));
         e4.clear();
         e4.sendKeys(data.getGeburtsdatum());
         
         //for Geburtsort
         WebElement e5 = registerForm.findElement(By.xpath("form/input[7]"));
         e5.clear();
         e5.sendKeys(data.getGeburtsort());
         
         //for E-Mail-Adresse
         WebElement e6 = registerForm.findElement(By.xpath("form/input[8]"));
         e6.clear();
         e6.sendKeys(data.getEmail());
         
         //for E-Mail-Adresse wiederholen
         WebElement e7 = registerForm.findElement(By.xpath("form/input[9]"));
         e7.clear();
         e7.sendKeys(data.getEmailCopy());
         
         // Sleep for entering captcha
         Thread.sleep(10000);
         
         WebElement footer = driver.findElement(By.className("PortletFooter"));
         
         Util.scrollWindow(driver);
         footer.findElements(By.tagName("input")).get(0).click();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

}
