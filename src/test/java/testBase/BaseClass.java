package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtils;

public class BaseClass {

	public static WebDriver driver;
	public Logger log;
	public Properties prop;
	public ExcelUtils excelutils;

	@BeforeMethod(groups = { "master", "sanity", "regression" })
	@Parameters({ "browsername", "os" })
	public void setUp(String browser, String OS) throws IOException {

		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		excelutils = new ExcelUtils(".//testData//LetsShop_LoginTestData.xlsx");
		log = LogManager.getLogger(this.getClass());

		if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities cap = new DesiredCapabilities();
			// OS we are selecting
			if (OS.equalsIgnoreCase("WINDOWS")) {
				cap.setPlatform(Platform.WIN11);
			} else if (OS.equalsIgnoreCase("MAC")) {
				cap.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching OS found");
				return;
			}

			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				break;
			default:
				System.out.println("No matching browser available");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));

		} else if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("No matching browser");
				return;
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));

		}
	}

	@AfterMethod(groups = { "master", "sanity", "regression" })
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String name) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HH-mm").format(new Date());

		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File source = takesscreenshot.getScreenshotAs(OutputType.FILE);

		String targetfilepath = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timestamp + ".png";
		File target = new File(targetfilepath);

		source.renameTo(target);

		return targetfilepath;

	}

}
