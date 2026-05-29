package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;

public class ScreenshotUtility {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        String path =
                "screenshots/" +
                testName +
                ".png";

        File dest =
                new File(path);

        try {

            FileUtils.copyFile(src, dest);

        } catch(IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}