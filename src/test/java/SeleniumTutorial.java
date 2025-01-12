import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public  class SeleniumTutorial {
    public static WebDriver driver;

    public void launchBrowserAndApplication() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(3000);

        // Entering username
        // Identify username locator with 'id'
        //WebElement username = driver.findElement(By.id("user-name"));
        //Identify username locator with 'xpath'
        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");

        // Entering password
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");


        // Clicking on login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //explicitwait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'app_logo']")));

        // driver.close();
        String expURL = "https://www.saucedemo.com/v1/inventory.html";
        String actURL = driver.getCurrentUrl();

        if (expURL.equals(actURL)) {
            System.out.println("Login is successful with valid credentials");
        } else {
            System.out.println("Login is unsuccessful with valid credentials");
            Thread.sleep(3000);
        }
    }

    public void filterPrice() throws InterruptedException {

        WebElement filterPriceDropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filterPriceDropDown.click();
        Select st = new Select(filterPriceDropDown);
        st.selectByValue("za");
        //st.selectByIndex(3);
        // st.selectByVisibleText("Name (Z to A)");
        Thread.sleep(3000);

    }


    public void loginWithRobotClass() throws InterruptedException, AWTException {

        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(4000);
        Robot robot = new Robot();
        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");
        robot.keyPress(KeyEvent.VK_TAB);
        //txtEmailAddress.sendKeys("subhendudas8014@gmail.com");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");
        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }


    public void loginWithPropertyFileData() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://www.saucedemo.com/v1/index.html");
        //implicitwait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Thread.sleep(4000);
        FileReader reader = new FileReader("./testdata/testdata.properties");
        Properties props = new Properties();
        props.load(reader);
        String uname = props.getProperty("username");
        String pwd = props.getProperty("password");
        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys(uname);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(pwd);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


    }

    public void iframeHandling() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://demo.guru99.com/test/guru99home/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'rt-logo-block']")));
        driver.switchTo().frame("a077aa5e");

        WebElement imageInFrame = driver.findElement(By.xpath("//img[@src = 'Jmeter720.png']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", imageInFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        imageInFrame.click();
        driver.switchTo().defaultContent();


    }

    public void popupHandling() {
        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        WebElement username = driver.findElement(By.xpath("//input[@name = 'cusid']"));
        username.sendKeys("53920");
        WebElement submit = driver.findElement(By.xpath("//input[@name = 'submit']"));
        submit.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        alert.accept();

        //  alert.dismiss();


    }

    public void usingActionClass() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://www.saucedemo.com/v1/index.html");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");

        // Entering password
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");


        // Clicking on login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Actions act1 = new Actions(driver);
        act1.click(loginButton).build().perform();


        WebElement filterPriceDropDown = (driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        act1.click(filterPriceDropDown).build().perform();
        Select st = new Select(filterPriceDropDown);
        //st.selectByValue("za");
        st.selectByIndex(2);
    }

    public void multipleWindowHandling() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        // It will launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It will launch application
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("windowButton")).click();
        String mainWindownHandle = driver.getWindowHandle();
        System.out.println("This is the main window information :" + mainWindownHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("This is the all window information" + allWindowHandles);
        Iterator<String> iterator = allWindowHandles.iterator();
        //  [window1, window2]
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindownHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("This is ChildWindow information: " + text.getText());
            }
        }
    }

        public void dynamicWebTableHandling () throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            // It will launch browser
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            // It will launch application
            driver.get("https://demo.guru99.com/test/web-table-element.php");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            List<WebElement> col = driver.findElements(By.xpath("//*[@id= 'leftcontainer']/table/thead/tr/th"));
            System.out.println("No of Cols are:" + col.size());
            List<WebElement> rows = driver.findElements(By.xpath("//*[@id= 'leftcontainer']/table/tbody/tr/td[1]"));
            System.out.println("No of rows are:" + rows.size());

            for (int i = 1; i <= rows.size(); i++) {
                String companyName = driver.findElement(By.xpath("//*[@id= 'leftcontainer']/table/tbody/tr[" + i + "]/td[1]")).getText();
                 //System.out.println("company name from list:" + companyName);
              //  if (companyName.equals("NIIT Technologies")) {
                    if (companyName.equals("Capital First")) {
                        String currentPrice = driver.findElement(By.xpath("//*[@id= 'leftcontainer']/table/tbody/tr[" + i + "]/td[4]")).getText();
                        System.out.println("The currentPrice of " + companyName + "is:" + currentPrice);

                    } else {
                        System.out.println("companyname is not find");
                    }

                }
            }

    }

