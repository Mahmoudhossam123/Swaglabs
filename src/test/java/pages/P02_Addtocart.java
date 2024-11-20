package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utility.FlexibleJsonReader;
import utility.Hooks;
import java.util.List;
import java.util.Map;


public class P02_Addtocart extends Hooks {
    public static String add_to_cart_btn_id = "add-to-cart-sauce-labs-backpack";
    public static String add_to_cart_btn2_id = "add-to-cart-sauce-labs-bolt-t-shirt";
    public static String mini_cart_xpath_ = "//*[@id=\"shopping_cart_container\"]";
    public static String cart_list_xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]";
    public static String remove_btn_id="remove-sauce-labs-backpack";
    public static String remove_btn2_id="remove-sauce-labs-bolt-t-shirt";
    public static String checkout_btn_id="checkout";
    public static String F_name_id="first-name";
    public static String L_name_id="last-name";
    public static String zip_id="postal-code";
    public static String continue_btn_id="continue";
    public static String finish_btn_id="finish";
    public static String confirmation_msg_xpath="//*[@id=\"checkout_complete_container\"]/h2";
    public static void add_to_cart() {
        getDriver().findElement(By.id(add_to_cart_btn_id)).click();
        getDriver().findElement(By.id(add_to_cart_btn2_id)).click();
    }

    public static void shopping_cart() {
        getDriver().findElement(By.xpath(mini_cart_xpath_)).click();
    }
    public static void check_shooping_cart() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> products = getDriver().findElements(By.xpath(cart_list_xpath));
        if (products.size() > 0) {
            System.out.print("products added successfully");
        }
        else {
            System.out.print("No products added to cart");
        }
    }
    public static void remove_items(){
      getDriver().findElement(By.id(remove_btn_id)).click();
      getDriver().findElement(By.id(remove_btn2_id)).click();
    }
    public static void item_removed() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> products = getDriver().findElements(By.xpath(cart_list_xpath));
        if (products.size() <=1) {
            System.out.print("products removed successfully");
        }
        else {
            System.out.print("enable to removed");
        }
    }
      public static void checkout_btn(){
        getDriver().findElement(By.id(checkout_btn_id)).click();
  }
      public static void enter_credentials() throws Exception {
          List<Map<String, String>> allData = FlexibleJsonReader.getAllData("src/test/data.json");
          for (Map<String, String> data : allData) {
              String f_name = data.get("F_name");
              getDriver().findElement(By.id(F_name_id)).sendKeys(f_name);
          }
              List<Map<String, String>> AllData = FlexibleJsonReader.getAllData("src/test/data.json");
              for (Map<String, String> Data : AllData) {
                  String l_name=Data.get("L_name");
                  getDriver().findElement(By.id(L_name_id)).sendKeys(l_name);
              }
          List<Map<String, String>> Alldata = FlexibleJsonReader.getAllData("src/test/data.json");
          for (Map<String, String> data : Alldata) {
              String Zip=data.get("zip");
              getDriver().findElement(By.id(zip_id)).sendKeys(Zip);
      }
  }
      public static void click_continue(){
              getDriver().findElement(By.id(continue_btn_id)).click();
  }
       public static void click_finish(){
              getDriver().findElement(By.id(finish_btn_id)).click();
  }
  public static void confirmation_message(){
      SoftAssert softAssert=new SoftAssert();
      String currentmsg=getDriver().findElement(By.xpath(confirmation_msg_xpath)).getText();
      String actualmsg="Thank you for your order!";
      softAssert.assertEquals(currentmsg,actualmsg);
  }
}
