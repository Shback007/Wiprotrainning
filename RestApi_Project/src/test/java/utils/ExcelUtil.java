package utils;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

    public static String[] getLoginData() {

        String[] data = new String[3];

        try {

            InputStream fis =ExcelUtil.class.getClassLoader().getResourceAsStream("usernames.xlsx");

            Workbook wb = WorkbookFactory.create(fis);

            Sheet sh = wb.getSheet("Sheet1");

            Row row = sh.getRow(1);

            DataFormatter formatter =new DataFormatter();

            data[0] =formatter.formatCellValue(row.getCell(0));

            data[1] =formatter.formatCellValue(row.getCell(1));

            data[2] =formatter.formatCellValue(row.getCell(2));

            wb.close();
            fis.close();
        }

        catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}