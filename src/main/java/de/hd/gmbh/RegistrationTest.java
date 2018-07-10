package de.hd.gmbh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest
{
   RegistrationSuite suite = null;
   
   WebDriver driver = null;
   
//   @BeforeClass(alwaysRun = true)
   public void setUp() throws Exception
   {
      driver = new ChromeDriver();
      suite = new RegistrationSuite(driver);
   }

//   @Test(priority=1)
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
   
//   @Test(priority=2)
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
   
//   @Test(priority=3)
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
   
//   @Test(priority=4)
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
   
//   @Test(priority=5)
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
   
//   @Test(priority=5)
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
   
//   @Test(priority=7)
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
   
//   @Test(priority=8)
   public void test_all_data()
   {
      suite.fillRegisterInfoAndSubmit(AppData.get("data8")); // real data
   }
}
