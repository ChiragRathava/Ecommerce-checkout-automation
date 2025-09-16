package com.chiragrathava.utilsTest;



import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {
    // Apache POI
    // Read the file - TestData.xlsx
    // Workbook Create
    // Sheet
    // Row and Cell
    // 2D Object - getData()

    // File -> Workbook -> Sheet -> Row -> Cell -> [][]

    static Workbook book;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir")+ "/src/test/resources/TestData/MOCK_DATA.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName) {

        FileInputStream file = null;
        try {
            file = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);

        } catch (IOException e) {
            System.out.println("Either File Not Found! or workbook not created!");;
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        Object[][] data = new Object[5][2];

        for (int i = 0; i < sheet.getLastRowNum(); i++){
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++){

                // First row email, password -> column name - skip - header
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

            }
        }
        return data;
    }
}

