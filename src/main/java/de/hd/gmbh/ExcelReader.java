package de.hd.gmbh;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author moksh
 *
 */
public class ExcelReader
{

   private String fileName = null;

   private final String XLS = "xls";

   private final String XLSX = "xlsx";

   /**
    * For Testing only
    * 
    * @param args
    */
   public static void main(String[] args)
   {
      String fileName = "input/input.xlsx";
      System.out.println(new ExcelReader(fileName).getRegistrationDataList());
   }

   public ExcelReader(String fileName)
   {
      this.fileName = fileName;
   }

   public List<RegistrationEntity> getRegistrationDataList()
   {
      Row row;
      Cell cell;
      List<RegistrationEntity> registrationDataList = new ArrayList<RegistrationEntity>();
      String[][] value = null;
      try
      {
         FileInputStream inputStream = new FileInputStream(fileName);

         Workbook workbook = getWorkBookInstance(inputStream);

         // get sheet number
         int sheetCn = workbook.getNumberOfSheets();

         for (int cn = 0; cn < sheetCn; cn++)
         {
            // get 0th sheet data
            Sheet sheet = workbook.getSheetAt(0);

            // get number of rows from sheet
            int rows = sheet.getPhysicalNumberOfRows();

            // get number of cell from row
            int cells = sheet.getRow(cn).getPhysicalNumberOfCells();

            value = new String[rows][cells];

            for (int r = 0; r < rows; r++)
            {
               if (r == 0) //header
                  continue;

               row = sheet.getRow(r); // bring row
               if (row != null)
               {
                  RegistrationEntity registrationEntity = new RegistrationEntity();
                  for (int c = 0; c < cells; c++)
                  {
                     cell = row.getCell(c);
                     if (cell != null)
                     {

                        switch (cell.getCellTypeEnum())
                        {
                        case FORMULA:
                           // do nothing
                           System.out.println("WARNING: Function Cell Found.");
                           break;

                        case NUMERIC:
                           value[r][c] = "" + cell.getNumericCellValue();
                           break;

                        case STRING:
                           value[r][c] = "" + cell.getStringCellValue();
                           break;

                        case BLANK:
                           value[r][c] = "[BLANK]";
                           System.out.println("WARNING: Blank Cell Found.");
                           break;

                        case ERROR:
                           // do nothing
                           break;
                        default:
                        }
                     }
                     
                     switch (c)
                     {
                     case 0:
                        registrationEntity.setBenutzername(value[r][c]);
                        break;
                     case 1:
                        registrationEntity.setPasswort(value[r][c]);
                        break;
                     case 2:
                        registrationEntity.setSicherheitsfrage(value[r][c]);
                        break;
                     case 3:
                        registrationEntity.setGeheimeAntwort(value[r][c]);
                        break;
                     case 4:
                        registrationEntity.setAnrede(value[r][c]);
                        break;
                     case 5:
                        registrationEntity.setFamilienname(value[r][c]);
                        break;
                     case 6:
                        registrationEntity.setVorname(value[r][c]);
                        break;
                     case 7:
                        registrationEntity.setGeburtsname(value[r][c]);
                        break;
                     case 8:
                        registrationEntity.setDoktorgrad(value[r][c]);
                        break;
                     case 9:
                        registrationEntity.setWeitereTitel(value[r][c]);
                        break;
                     case 10:
                        registrationEntity.setGeburtsdatum(value[r][c]);
                        break;
                     case 11:
                        registrationEntity.setGeburtsort(value[r][c]);
                        break;
                     case 12:
                        value[r][c] = value[r][c].replace(".0", "");
                        registrationEntity.setPostleitzahl(value[r][c]);
                        break;
                     case 13:
                        registrationEntity.setWohnort(value[r][c]);
                        break;
                     case 14:
                        value[r][c] = value[r][c].replace(".0", "");
                        registrationEntity.setHausnummer(value[r][c]);
                        break;
                     case 15:
                        registrationEntity.setEmail(value[r][c]);
                        break;
                     case 16:
                        value[r][c] = value[r][c].replace(".0", "");
                        registrationEntity.setTelefonnummer(value[r][c]);
                        break;
                     case 17:
                        registrationEntity.setIban(value[r][c]);
                        break;
                     case 18:
                        registrationEntity.setBic(value[r][c]);
                        break;
                     default:
                        break;
                     }
                  } // for(c)
                  registrationDataList.add(registrationEntity);
               }
            } // for(r)
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      return registrationDataList;
   }

   private Workbook getWorkBookInstance(FileInputStream inputStream) throws Exception
   {
      String ext = getFileExtension(fileName);
      Workbook workbook = null;
      if (XLS.equalsIgnoreCase(ext))
      {
         workbook = new HSSFWorkbook(inputStream);
      }
      else if (XLSX.equalsIgnoreCase(ext))
      {
         workbook = new XSSFWorkbook(inputStream);
      }
      return workbook;
   }

   private String getFileExtension(String fileName)
   {
      if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
         return fileName.substring(fileName.lastIndexOf(".") + 1);
      else
         return "";
   }

}
