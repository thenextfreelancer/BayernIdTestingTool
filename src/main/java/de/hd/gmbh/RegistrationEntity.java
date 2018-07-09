package de.hd.gmbh;

public class RegistrationEntity
{

   //user name
   private String benutzername = null;
   
   //password
   private String passwort = null;
   
   //secret question
   private String sicherheitsfrage = null;
   
   //secret answer
   private String geheimeAntwort = null;
   
   //Salutation - gender
   private String anrede = null;
   
   private String familienname = null;
   
   private String vorname = null;
   
   private String geburtsname = null;
   
   private String doktorgrad = null;
   
   private String weitereTitel = null;
   
   private String geburtsdatum = null;
   
   private String geburtsort = null;
   
   //postal code
   private String postleitzahl = null;
   
   //place of residence
   private String wohnort = null;
   
   //house number
   private String hausnummer = null;
   
   private String email = null;
   
   //telephone number
   private String telefonnummer = null;
   
   private String iban = null;
   
   private String bic = null;
   
   public RegistrationEntity(
      String benutzername,
      String passwort,
      String sicherheitsfrage,
      String geheimeAntwort,
      String anrede,
      String familienname,
      String vorname,
      String geburtsname,
      String doktorgrad,
      String weitereTitel,
      String geburtsdatum,
      String geburtsort,
      String postleitzahl,
      String wohnort,
      String hausnummer,
      String email,
      String telefonnummer,
      String iban,
      String bic)
   {
      this.benutzername = benutzername;
      this.passwort = passwort;
      this.sicherheitsfrage = sicherheitsfrage;
      this.geheimeAntwort = geheimeAntwort;
      this.anrede = anrede;
      this.familienname = familienname;
      this.vorname = vorname;
      this.geburtsname = geburtsname;
      this.doktorgrad = doktorgrad;
      this.weitereTitel = weitereTitel;
      this.geburtsdatum = geburtsdatum;
      this.geburtsort = geburtsort;
      this.postleitzahl = postleitzahl;
      this.wohnort = wohnort;
      this.hausnummer = hausnummer;
      this.email = email;
      this.telefonnummer = telefonnummer;
      this.iban = iban;
      this.bic = bic;
   }

   public RegistrationEntity()
   {
      // TODO Auto-generated constructor stub
   }

   public String getBenutzername()
   {
      return benutzername;
   }

   public void setBenutzername(String benutzername)
   {
      this.benutzername = benutzername;
   }

   public String getPasswort()
   {
      return passwort;
   }

   public void setPasswort(String passwort)
   {
      this.passwort = passwort;
   }

   public String getSicherheitsfrage()
   {
      return sicherheitsfrage;
   }

   public void setSicherheitsfrage(String sicherheitsfrage)
   {
      this.sicherheitsfrage = sicherheitsfrage;
   }

   public String getGeheimeAntwort()
   {
      return geheimeAntwort;
   }

   public void setGeheimeAntwort(String geheimeAntwort)
   {
      this.geheimeAntwort = geheimeAntwort;
   }

   public String getAnrede()
   {
      return anrede;
   }

   public void setAnrede(String anrede)
   {
      this.anrede = anrede;
   }

   public String getFamilienname()
   {
      return familienname;
   }

   public void setFamilienname(String familienname)
   {
      this.familienname = familienname;
   }

   public String getVorname()
   {
      return vorname;
   }

   public void setVorname(String vorname)
   {
      this.vorname = vorname;
   }

   public String getGeburtsname()
   {
      return geburtsname;
   }

   public void setGeburtsname(String geburtsname)
   {
      this.geburtsname = geburtsname;
   }

   public String getDoktorgrad()
   {
      return doktorgrad;
   }

   public void setDoktorgrad(String doktorgrad)
   {
      this.doktorgrad = doktorgrad;
   }

   public String getWeitereTitel()
   {
      return weitereTitel;
   }

   public void setWeitereTitel(String weitereTitel)
   {
      this.weitereTitel = weitereTitel;
   }

   public String getGeburtsdatum()
   {
      return geburtsdatum;
   }

   public void setGeburtsdatum(String geburtsdatum)
   {
      this.geburtsdatum = geburtsdatum;
   }

   public String getGeburtsort()
   {
      return geburtsort;
   }

   public void setGeburtsort(String geburtsort)
   {
      this.geburtsort = geburtsort;
   }

   public String getPostleitzahl()
   {
      return postleitzahl;
   }

   public void setPostleitzahl(String postleitzahl)
   {
      this.postleitzahl = postleitzahl;
   }

   public String getWohnort()
   {
      return wohnort;
   }

   public void setWohnort(String wohnort)
   {
      this.wohnort = wohnort;
   }

   public String getHausnummer()
   {
      return hausnummer;
   }

   public void setHausnummer(String hausnummer)
   {
      this.hausnummer = hausnummer;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getTelefonnummer()
   {
      return telefonnummer;
   }

   public void setTelefonnummer(String telefonnummer)
   {
      this.telefonnummer = telefonnummer;
   }

   public String getIban()
   {
      return iban;
   }

   public void setIban(String iban)
   {
      this.iban = iban;
   }

   public String getBic()
   {
      return bic;
   }

   public void setBic(String bic)
   {
      this.bic = bic;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((anrede == null)?0:anrede.hashCode());
      result = prime * result + ((benutzername == null)?0:benutzername.hashCode());
      result = prime * result + ((bic == null)?0:bic.hashCode());
      result = prime * result + ((doktorgrad == null)?0:doktorgrad.hashCode());
      result = prime * result + ((email == null)?0:email.hashCode());
      result = prime * result + ((familienname == null)?0:familienname.hashCode());
      result = prime * result + ((geburtsdatum == null)?0:geburtsdatum.hashCode());
      result = prime * result + ((geburtsname == null)?0:geburtsname.hashCode());
      result = prime * result + ((geburtsort == null)?0:geburtsort.hashCode());
      result = prime * result + ((geheimeAntwort == null)?0:geheimeAntwort.hashCode());
      result = prime * result + ((hausnummer == null)?0:hausnummer.hashCode());
      result = prime * result + ((iban == null)?0:iban.hashCode());
      result = prime * result + ((passwort == null)?0:passwort.hashCode());
      result = prime * result + ((postleitzahl == null)?0:postleitzahl.hashCode());
      result = prime * result + ((sicherheitsfrage == null)?0:sicherheitsfrage.hashCode());
      result = prime * result + ((telefonnummer == null)?0:telefonnummer.hashCode());
      result = prime * result + ((vorname == null)?0:vorname.hashCode());
      result = prime * result + ((weitereTitel == null)?0:weitereTitel.hashCode());
      result = prime * result + ((wohnort == null)?0:wohnort.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      RegistrationEntity other = (RegistrationEntity) obj;
      if (anrede == null)
      {
         if (other.anrede != null)
            return false;
      }
      else if (!anrede.equals(other.anrede))
         return false;
      if (benutzername == null)
      {
         if (other.benutzername != null)
            return false;
      }
      else if (!benutzername.equals(other.benutzername))
         return false;
      if (bic == null)
      {
         if (other.bic != null)
            return false;
      }
      else if (!bic.equals(other.bic))
         return false;
      if (doktorgrad == null)
      {
         if (other.doktorgrad != null)
            return false;
      }
      else if (!doktorgrad.equals(other.doktorgrad))
         return false;
      if (email == null)
      {
         if (other.email != null)
            return false;
      }
      else if (!email.equals(other.email))
         return false;
      if (familienname == null)
      {
         if (other.familienname != null)
            return false;
      }
      else if (!familienname.equals(other.familienname))
         return false;
      if (geburtsdatum == null)
      {
         if (other.geburtsdatum != null)
            return false;
      }
      else if (!geburtsdatum.equals(other.geburtsdatum))
         return false;
      if (geburtsname == null)
      {
         if (other.geburtsname != null)
            return false;
      }
      else if (!geburtsname.equals(other.geburtsname))
         return false;
      if (geburtsort == null)
      {
         if (other.geburtsort != null)
            return false;
      }
      else if (!geburtsort.equals(other.geburtsort))
         return false;
      if (geheimeAntwort == null)
      {
         if (other.geheimeAntwort != null)
            return false;
      }
      else if (!geheimeAntwort.equals(other.geheimeAntwort))
         return false;
      if (hausnummer == null)
      {
         if (other.hausnummer != null)
            return false;
      }
      else if (!hausnummer.equals(other.hausnummer))
         return false;
      if (iban == null)
      {
         if (other.iban != null)
            return false;
      }
      else if (!iban.equals(other.iban))
         return false;
      if (passwort == null)
      {
         if (other.passwort != null)
            return false;
      }
      else if (!passwort.equals(other.passwort))
         return false;
      if (postleitzahl == null)
      {
         if (other.postleitzahl != null)
            return false;
      }
      else if (!postleitzahl.equals(other.postleitzahl))
         return false;
      if (sicherheitsfrage == null)
      {
         if (other.sicherheitsfrage != null)
            return false;
      }
      else if (!sicherheitsfrage.equals(other.sicherheitsfrage))
         return false;
      if (telefonnummer == null)
      {
         if (other.telefonnummer != null)
            return false;
      }
      else if (!telefonnummer.equals(other.telefonnummer))
         return false;
      if (vorname == null)
      {
         if (other.vorname != null)
            return false;
      }
      else if (!vorname.equals(other.vorname))
         return false;
      if (weitereTitel == null)
      {
         if (other.weitereTitel != null)
            return false;
      }
      else if (!weitereTitel.equals(other.weitereTitel))
         return false;
      if (wohnort == null)
      {
         if (other.wohnort != null)
            return false;
      }
      else if (!wohnort.equals(other.wohnort))
         return false;
      return true;
   }
   
}
