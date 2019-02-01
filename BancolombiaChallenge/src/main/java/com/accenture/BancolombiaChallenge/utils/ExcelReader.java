package com.accenture.BancolombiaChallenge.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String getSaving() {
        int[] coordinates = ExcelReader.randomNumber();
        
        // Archivo de excel con los datos
        File fileName= new File("C:\\Users\\carlos.guerrero\\Desktop\\Datos.xlsx");
        List<List<XSSFCell>> cellData= new ArrayList<List<XSSFCell>>();
        String data = null;
        
        if(fileName.exists()) {
            try {
                FileInputStream fileInputStream= new FileInputStream(fileName);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
               
                XSSFSheet hssfSheet = workbook.getSheetAt(0);             // get the sheet 0
                Iterator<?> rowIterator = hssfSheet.rowIterator();        // you get the rows that the sheet has
               
                // move through the rows of the file
                while(rowIterator.hasNext()) {
                    XSSFRow hssfRow = (XSSFRow) rowIterator.next();       // every time the cycle is executed,
                    Iterator<?> iterator = hssfRow.cellIterator();        // the data of each row is obtained
                    List<XSSFCell> cellTemp = new ArrayList<XSSFCell>();
                    
                    // We obtain the data stored in each cell
                    while(iterator.hasNext()) {
                        XSSFCell hssfCell= (XSSFCell) iterator.next();    // we store in hssfCell the data of each cell
                        cellTemp.add(hssfCell);                           // hssfCell-> cellTemp
                    }
                    cellData.add(cellTemp);                               // cellTemp->cellData
                }
               
            }catch (Exception exp) {
                exp.printStackTrace();
            }
        
            data = obtain(cellData, coordinates[0], coordinates[1]);
        }
        
        return data;
  }
  
  
  private static String obtain(List<List<XSSFCell>> cellDataList, int positionRow, int positionColumns) {
        String dat = null;
        
        //cycle that runs the rows from zero to the size of the object
        for(int i = 0; i < cellDataList.size(); i++) {
            List<?> cellTempList= (List<?>) cellDataList.get(i);                  // we obtain the data stored in cellDataList in each position
               
            // cycle that runs the columns from zero to the size of the object
            for(int j = 0; j < cellTempList.size(); j++) {
                XSSFCell hssfCell= (XSSFCell) cellTempList.get(j);
                String cellValue = hssfCell.toString();                           // I convert the data to String type

                // I get the requested value in dat
                if(i == positionRow && j == positionColumns ) {
                	dat = cellValue;
                }
                      
            }
        }
        
        return dat;
  }
  
  private static int[] randomNumber() {
	  int row = (int) (Math.random() * 6);
	  int col = (int) (Math.random() * 3);
	  int[] coordinates = new int[2];
	  coordinates[0] = row;
	  coordinates[1] = col;
	  return coordinates;
  }
 
}

