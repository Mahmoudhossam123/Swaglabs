package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.Hooks;
import utility.FlexibleJsonReader;
import java.time.Duration;
import java.util.List;
import java.util.Map;



public class P01_login extends Hooks {
    public static String user_name_id = "user-name";
    public static String password_id = "password";
    public static String login_btn_id = "login-button";
    public static String error_msg_xpath ="//*[@id=\"login_button_container\"]/div/form/div[3]/h3";


    public static void send_key_username() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String user = data.get("username");
            getDriver().findElement(By.id(user_name_id)).sendKeys(user);
        }
    }

    public static void send_key_pass() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String pass = data.get("password");
            getDriver().findElement(By.id(password_id)).sendKeys(pass);
            getDriver().findElement(By.id(login_btn_id)).click();
        }
    }

    public static void home_page()  {
        SoftAssert softAssert = new SoftAssert();
        String currenturl = getDriver().getCurrentUrl();
        String actualurl = "https://www.saucedemo.com/inventory.html";
        softAssert.assertEquals(currenturl, actualurl);
    }

    public static void invalid_user() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String invalid_user = data.get("invalid user");
            getDriver().findElement(By.id(user_name_id)).sendKeys(invalid_user);
        }
    }
    public static void invalid_pass() throws Exception {
        List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
        for (Map<String, String> data : allData) {
            String invalid_pass = data.get("invalid pass");
            getDriver().findElement(By.id(password_id)).sendKeys(invalid_pass);
            getDriver().findElement(By.id(login_btn_id)).click();
        }
    }
    public static void invalid_login_msg()  {
        WebDriverWait Wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement currentmsg = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(error_msg_xpath)));
        SoftAssert softAssert=new SoftAssert();
        String current_msg= currentmsg.getText();
        String actual_msg="Epic sadface: Username and password do not match any user in this service";
        softAssert.assertEquals(current_msg,actual_msg);
    }
}
