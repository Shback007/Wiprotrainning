package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {

    public static Object[][] getExcelData() {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/testdata/LoginData.xlsx");

            Workbook workbook =
                    WorkbookFactory.create(fis);

            Sheet sheet =
                    workbook.getSheet("Sheet1");

            int totalRows =
                    sheet.getLastRowNum();

            int totalCols =
                    sheet.getRow(0).getLastCellNum();

            data =
                    new Object[totalRows][totalCols];

            for(int i = 1; i <= totalRows; i++) {

                for(int j = 0; j < totalCols; j++) {

                    data[i-1][j] =
                            sheet.getRow(i)
                            .getCell(j)
                            .toString();
                }
            }

            workbook.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}