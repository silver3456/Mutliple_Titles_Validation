package core.Multiple_Titles_Validation;

//BEGIN
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No arguments!");
			System.exit(1);
		}

		WebDriver driver = new FirefoxDriver(); // Version 1.1 :: Firefox
		// Test Case ID
		for (int i = 0; i < args.length; i++) {
			String text_case_id = "TC-001.01" + (i + 1);
			// UserAgent RegEx
			// /(?:Mozilla/5.0)\s(?:.*\))\s(?:Gecko/\d{8})\s(\w+)/(\d+.\d+)/
			// String useragentregex =
			// "(?:Mozilla/5.0)\\s(?:\\(.*\\))\\s(?:Gecko/\\d{8})\\s(\\w+)/(\\d+.\\d+)";
			// String useragent = (String) ((JavascriptExecutor)
			// driver).executeScript("return navigator.userAgent;");
			// Matcher m_browser =
			// Pattern.compile(useragentregex).matcher(useragent);
			// m_browser.find();

			String param[] = args[i].split("\\|");
			String url = param[0];
			String title_expected = param[1];

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();

			if (title_expected.equals(title_actual)) {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				// System.out.println("Browser: \t\t" + m_browser.group(1) + " "
				// + m_browser.group(2));
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");

			} else {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				// System.out.println("Browser: \t\t" + m_browser.group(1) + " "
				// + m_browser.group(2));
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
			}

			// System.out.println("\nUserAgent: \t\t"
			// + (String) ((JavascriptExecutor) driver).executeScript("return
			// navigator.userAgent;"));
		}
		driver.quit();
	}
}

// END