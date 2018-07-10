/**
 * 
 */
package de.hd.gmbh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import de.hd.gmbh.gmail.GmailLogin;

/**
 * @author Moksh
 *
 */
public class RegistrationSuite implements Module
{

   public WebDriver driver = null;
   // "https://infra-pre.buergerserviceportal.de/bayern/freistaat/register-authega";
   
   private WebElement registerForm = null;

   public RegistrationSuite(WebDriver driver)
   {
      this.driver = driver;
   }

   public void openRegisterPage()
   {
      try
      {
         Util.scrollWindow(driver);
         WebElement registerForm = driver.findElement(By.className("RegisterPage"));
         registerForm.findElement(By.className("ToggleContainer")).findElement(By.tagName("input")).click();
         Thread.sleep(1000);

         driver.findElement(By.className("RegisterSubmit")).findElement(By.xpath("input[2]")).click();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public void fillRegisterInfoAndSubmit(RegistrationEntity data)
   {
      try
      {
         fillElement(By.xpath("form/input[2]"), data.getBenutzername());
         
         fillElement(By.xpath("form/input[3]"), data.getPasswort());
         
         fillElement(By.xpath("form/input[4]"), data.getPasswort());
         
         Util.scrollWindow(driver);
         
         Select selectBox1 = new Select(registerForm.findElement(By.xpath("form/select[1]")));

         selectBox1.selectByValue(data.getSicherheitsfrage());
         
         fillElement(By.xpath("form/input[5]"), data.getGeheimeAntwort());

         if("Frau".equalsIgnoreCase(data.getAnrede())) {
            registerForm.findElement(By.xpath("form/table/tbody/tr/td[1]/input")).click();
         } else {
            registerForm.findElement(By.xpath("form/table/tbody/tr/td[2]/input")).click();
         }

         fillElement(By.xpath("form/input[6]"), data.getFamilienname());

         fillElement(By.xpath("form/input[7]"), data.getVorname());

         fillElement(By.xpath("form/input[8]"), data.getGeburtsname());
         
         Select selectBox2 = new Select(registerForm.findElement(By.xpath("form/select[2]")));

         selectBox2.selectByValue(data.getDoktorgrad());
         
         Util.scrollWindow(driver);
         
         fillElement(By.xpath("form/input[9]"), data.getWeitereTitel());

         fillElement(By.xpath("form/input[10]"), data.getGeburtsdatum());
         
         fillElement(By.xpath("form/input[11]"), data.getGeburtsort());

         fillElement(By.xpath("form/input[12]"), data.getPostleitzahl());

         fillElement(By.xpath("form/input[13]"), data.getWohnort());

         fillElement(By.xpath("form/input[14]"), data.getHausnummer());

         fillElement(By.xpath("form/input[15]"), data.getEmail());
         
         fillElement(By.xpath("form/input[16]"), data.getEmail());

         fillElement(By.xpath("form/input[17]"), data.getTelefonnummer());
         
         fillElement(By.xpath("//*[@id=\"ZAHNLUNGSART_GROUP\"]/input[1]"), data.getIban() == null?"":data.getIban());

         fillElement(By.xpath("//*[@id=\"ZAHNLUNGSART_GROUP\"]/input[2]"), data.getBic() == null?"":data.getBic());
         
         Util.scrollWindow(driver);

         // Sleep for entering captcha
         Thread.sleep(10000);

         WebElement footer = driver.findElement(By.className("RegisterSubmit"));

         Util.scrollWindow(driver);
         footer.findElements(By.tagName("input")).get(0).click();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public boolean isRegisterPageHasErrors() {
      try {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         try {
            WebElement errorEl = registerForm.findElement(By.xpath("form/span[2]"));
            if(!"".equals(errorEl.getText()) ) {
               return true;
            }
         } catch(Exception e) {
         }
      } catch(Exception e) {
      }
      return false;
   }
   
   public void fillElement(By by, String value) {
      try
      {
         if(registerForm == null) {
               registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
         }
         WebElement e = registerForm.findElement(by);
         e.clear();
         e.sendKeys(value);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void fillRegisterInfoAndSubmitOld(RegistrationEntity data)
   {
      try
      {
         WebElement registerForm = Util.fluentWait(By.className("RegisterPage"), driver, 30, 5);
//         List<WebElement> checkboxList = registerForm.findElement(By.className("RadioInputContainer")).findElements(By.tagName("input"));
//         if ("male".equals(data.getGender()))
//            checkboxList.get(0).click();
//         else
//            checkboxList.get(1).click();

         // for Familienname
         WebElement e1 = registerForm.findElement(By.xpath("form/input[2]"));
         e1.clear();
         e1.sendKeys(data.getFamilienname());

         // for Vorname
         WebElement e2 = registerForm.findElement(By.xpath("form/input[3]"));
         e2.clear();
         e2.sendKeys(data.getVorname());

         // for Geburtsname
         WebElement e3 = registerForm.findElement(By.xpath("form/input[4]"));
         e3.clear();
         e3.sendKeys(data.getGeburtsname());

         // for Geburtsname
         WebElement e9 = registerForm.findElement(By.xpath("form/input[5]"));
         e9.clear();
         e9.sendKeys("Weitere Titel");

         // for Geburtsdatum
         WebElement e4 = registerForm.findElement(By.xpath("form/input[6]"));
         e4.clear();
         e4.sendKeys(data.getGeburtsdatum());

         // for Geburtsort
         WebElement e5 = registerForm.findElement(By.xpath("form/input[7]"));
         e5.clear();
         e5.sendKeys(data.getGeburtsort());

         // for E-Mail-Adresse
         WebElement e6 = registerForm.findElement(By.xpath("form/input[8]"));
         e6.clear();
         e6.sendKeys(data.getEmail());

//         // for E-Mail-Adresse wiederholen
//         WebElement e7 = registerForm.findElement(By.xpath("form/input[9]"));
//         e7.clear();
//         e7.sendKeys(data.getEmailCopy());

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

   public void open_gmail(String userName)
   {
      GmailLogin gmail = new GmailLogin();
      gmail.setUserName(userName);
      gmail.setUp();
      gmail.login();
   }

}
