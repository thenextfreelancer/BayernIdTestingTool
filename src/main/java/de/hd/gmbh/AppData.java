package de.hd.gmbh;

import java.util.HashMap;
import java.util.Map;

public class AppData
{

   public static Map<String, RegistrationEntity> registrationData = null;

   static
   {

      registrationData = new HashMap<String, RegistrationEntity>();
      
//      registrationData.put("data1", new RegistrationEntity("male", "", "Vorname", "Geburtsname", "10.01.2001", "Geburtsort", "test@test.com", "test@test.com"));
//      
//      registrationData.put("data2", new RegistrationEntity("male", "Familienname", "", "Geburtsname", "10.01.2001", "Geburtsort", "test@test.com", "test@test.com"));
//
//      registrationData.put("data3", new RegistrationEntity("male", "Familienname", "Vorname", "", "10.01.2001", "Geburtsort", "test@test.com", "test@test.com"));
//      
//      registrationData.put("data4", new RegistrationEntity("female", "Familienname", "Vorname", "Geburtsname", "", "Geburtsort", "test@test.com", "test@test.com"));
//      
//      registrationData.put("data5", new RegistrationEntity("female", "Familienname", "Vorname", "Geburtsname", "10.01.2001", "", "test@test.com", "test@test.com"));
//      
//      registrationData.put("data6", new RegistrationEntity("female", "Familienname", "Vorname", "Geburtsname", "10.01.2001", "Geburtsort", "", "test@test.com"));
//      
//      registrationData.put("data7", new RegistrationEntity("female", "Familienname", "Vorname", "Geburtsname", "10.01.2001", "Geburtsort", "test@test.com", ""));
//      
//      registrationData.put("data8", new RegistrationEntity("female", "Lang", "Friedrich Johann", "m", "02.02.1948", "Bayreuth", "test@test.com", "test@test.com"));
   }
   
   public static RegistrationEntity get(String key){
      
      return registrationData.get(key);
   }

}
