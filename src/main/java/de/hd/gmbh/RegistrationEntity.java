package de.hd.gmbh;

public class RegistrationEntity
{

   private String gender = null;
   
   private String familienname = null;
   
   private String vorname = null;
   
   private String geburtsname = null;
   
   private String geburtsdatum = null;
   
   private String geburtsort = null;
   
   private String email = null;
   
   private String emailCopy = null;

   public RegistrationEntity(
      String gender,
      String familienname,
      String vorname,
      String geburtsname,
      String geburtsdatum,
      String geburtsort,
      String email,
      String emailCopy)
   {
      super();
      this.gender = gender;
      this.familienname = familienname;
      this.vorname = vorname;
      this.geburtsname = geburtsname;
      this.geburtsdatum = geburtsdatum;
      this.geburtsort = geburtsort;
      this.email = email;
      this.emailCopy = emailCopy;
   }

   public String getGender()
   {
      return gender;
   }

   public void setGender(String gender)
   {
      this.gender = gender;
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

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getEmailCopy()
   {
      return emailCopy;
   }

   public void setEmailCopy(String emailCopy)
   {
      this.emailCopy = emailCopy;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null)?0:email.hashCode());
      result = prime * result + ((emailCopy == null)?0:emailCopy.hashCode());
      result = prime * result + ((familienname == null)?0:familienname.hashCode());
      result = prime * result + ((geburtsdatum == null)?0:geburtsdatum.hashCode());
      result = prime * result + ((geburtsname == null)?0:geburtsname.hashCode());
      result = prime * result + ((geburtsort == null)?0:geburtsort.hashCode());
      result = prime * result + ((vorname == null)?0:vorname.hashCode());
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
      if (email == null)
      {
         if (other.email != null)
            return false;
      }
      else if (!email.equals(other.email))
         return false;
      if (emailCopy == null)
      {
         if (other.emailCopy != null)
            return false;
      }
      else if (!emailCopy.equals(other.emailCopy))
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
      if (vorname == null)
      {
         if (other.vorname != null)
            return false;
      }
      else if (!vorname.equals(other.vorname))
         return false;
      return true;
   }
   
}
