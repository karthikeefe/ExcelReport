package TestMaven.TestMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.RED;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Stopinher {
	
	LinkedList<Object[]> testReport;
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	CreationHelper createHelper;


	public  void addTestResult_into_excelsheet() {
		// Create a Workbook
		   workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
		
		 /* CreationHelper helps us create instances of various things like DataFormat, 
        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
		createHelper  = workbook.getCreationHelper();
		
		System.out.println(workbook.getSheetIndex("ab_cd"));
		
		// Create a Sheet
	      sheet = workbook.createSheet("Classname");
	      
	      System.out.println(workbook.getSheetIndex("Classname"));
	      
	      System.out.println(workbook.getSheetIndex("ab_cd"));

	     // Create a Font for styling header cells
	     Font headerFont = workbook.createFont();
	    // headerFont.set(true);
	     headerFont.setFontHeightInPoints((short) 14);
	     headerFont.setColor(IndexedColors.BLUE.getIndex());
	     headerFont.setBoldweight(headerFont.BOLDWEIGHT_BOLD);
	     
	    

	     // Create a CellStyle with the font
	     CellStyle headerCellStyle = workbook.createCellStyle();
	     headerCellStyle.setFont(headerFont);
	     headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
	     headerCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	     // Create a Row
	     Row headerRow = sheet.createRow(0);

	     testReport = new LinkedList<>();
	     //testresult.add(new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
	     testReport.add(new Object[] { "Test Case Name", "Test Step's", "Actual Output","Test Browser","Test Result","Exception","Screenshots" }); 
	     
	  // Create cells
	     for (int i = 0; i < testReport.get(0).length; i++) {
	         Cell cell = headerRow.createCell(i);
	         cell.setCellValue((String)testReport.get(0)[i]);
	         cell.setCellStyle(headerCellStyle);
	     }

	    		

	}
	
/*	public void finalresultseetcreation() {
		// write excel file and file name is SaveTestNGResultToExcel.xls
		
		try {
			InputStream img = new FileInputStream("./img.jpg");
			byte[] bytes = IOUtils.toByteArray(img);
			int myimg_id = workbook.addPicture(bytes, workbook.PICTURE_TYPE_JPEG);
			img.close();
			
		XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
		XSSFClientAnchor anchor = new XSSFClientAnchor();
		anchor.setCol1(5); //Column B
        anchor.setRow1(2-1); //Row 3
        anchor.setCol2(6); //Column C
        anchor.setRow2(2); //Row 4
        
        XSSFPicture myPicture = drawing.createPicture(anchor, myimg_id);
        
        sheet.autoSizeColumn(0);
        
        Set<String> keyset = testresult.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = testresult.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
			
			FileOutputStream out = new FileOutputStream(new File("./Excel.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
}*/


	public void addimage_inexcel() throws IOException {
	// String[] columns = {"Name", "Email", "Date Of Birth", "Salary", "Photo"};
	// testresult.add(new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output","Screenshots" });  
	 
	System.out.println(testReport.size());
	System.out.println(testReport.get(0).length);
	

     // Create Cell Style for formatting Date
     CellStyle dateCellStyle = workbook.createCellStyle();
     dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));			
     
     // Create Cell Style for failed test colour
     CellStyle statusfail_CellStyle = workbook.createCellStyle();
     statusfail_CellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
     statusfail_CellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);   
     statusfail_CellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	 Font failfont = workbook.createFont();
	 failfont.setFontHeightInPoints((short) 14);
     failfont.setBoldweight(failfont.BOLDWEIGHT_BOLD);
     failfont.setColor(IndexedColors.BLACK.getIndex());
     statusfail_CellStyle.setFont(failfont);
     
  // Create Cell Style for pass test colour
     CellStyle statuspass_CellStyle = workbook.createCellStyle();
    // statuspass_CellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
   //  statuspass_CellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
     statuspass_CellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	 Font passfont = workbook.createFont();
	 passfont.setFontHeightInPoints((short) 14);
     passfont.setBoldweight(passfont.BOLDWEIGHT_BOLD);
     passfont.setColor(IndexedColors.GREEN.getIndex());
     statuspass_CellStyle.setFont(passfont);
     

     // Create Other rows and cells with employees data
     int rowNum = 1;
     for(int i=1; i < testReport.size(); i++){
         Row row = sheet.createRow(i);
         row.setHeight((short) 1000);
        

         row.createCell(0).setCellValue((String)testReport.get(i)[0]);
         row.createCell(1).setCellValue((String)testReport.get(i)[1]);
         row.createCell(2).setCellValue((String)testReport.get(i)[2]);
         row.createCell(3).setCellValue((String)testReport.get(i)[3]);
         
         Cell teststatuscell = row.createCell(4);
       //  row.createCell(3).setCellValue((String)testresult.get(i)[3]);
         String status = (String)testReport.get(i)[4];
         if(status.equalsIgnoreCase("fail")) {
        	teststatuscell.setCellValue(status);
        	teststatuscell.setCellStyle(statusfail_CellStyle); 
         }
         if(status.equalsIgnoreCase("pass")) {
        	teststatuscell.setCellValue(status);
         	teststatuscell.setCellStyle(statuspass_CellStyle); 
         }
         
         row.createCell(5).setCellValue((String)testReport.get(i)[5]);

         //============= Inserting image - START
         /* Read input PNG / JPG Image into FileInputStream Object*/
         InputStream my_banner_image = new FileInputStream((String)testReport.get(i)[6]);
         /* Convert picture to be added into a byte array */
         byte[] bytes = IOUtils.toByteArray(my_banner_image);
         /* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
         int my_picture_id = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
         /* Close the InputStream. We are ready to attach the image to workbook now */
         my_banner_image.close();
         /* Create the drawing container */
         XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
         /* Create an anchor point */
         //============= Inserting image - END

         //========adding image START
         XSSFClientAnchor my_anchor = new XSSFClientAnchor();
         /* Define top left corner, and we can resize picture suitable from there */

         my_anchor.setCol1(7); //Column B
         my_anchor.setRow1(i); //Row 3
         my_anchor.setCol2(9); //Column C
         my_anchor.setRow2(i+1); //Row 4
        
         
        
         

         /* Invoke createPicture and pass the anchor point and ID */
         XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
         //========adding image END
     }

     // Resize all columns to fit the content size
     for (int i = 0; i < testReport.get(0).length; i++) {
         sheet.autoSizeColumn(i);
     }

     // Write the output to a file
     FileOutputStream fileOut = new FileOutputStream("testresult.xlsx");
     workbook.write(fileOut);
     fileOut.close();

     // Closing the workbook
   //  workbook.close();

	}
}


