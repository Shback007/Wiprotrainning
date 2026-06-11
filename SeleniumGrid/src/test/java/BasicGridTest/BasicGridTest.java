package BasicGridTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BasicGridTest {

    public static void main(String[] args) throws Exception {

        // Define browser capabilities
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Optional: run without UI

        // Point to Grid hub
        WebDriver driver = new RemoteWebDriver(
            new URL("http://localhost:4444"),
            options
        );

        driver.get("https://www.accuweather.com/en/in/suri/191611/weather-forecast/191611");
        System.out.println("Title: " + driver.getTitle());

        driver.quit(); // Always free the node slot
    }
}
