package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Hooks;

import java.util.List;
import java.util.Map;

public class P03_productsprice extends Hooks {
    public static String product_name="inventory_item_name";
    public static String product_price="inventory_item_price";
    public static void verify_multiple_prices(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        List<WebElement> productNames = getDriver().findElements(By.className(product_name));
        List<WebElement> productPrices = getDriver().findElements(By.className(product_price));
        Assert.assertEquals("Number of products mismatch!", expectedData.size(), productNames.size());

        for (int i = 0; i < expectedData.size(); i++) {
            String expectedName = expectedData.get(i).get("Product Name");
            String expectedPrice = expectedData.get(i).get("Expected Price");

            String actualName = productNames.get(i).getText();
            String actualPrice = productPrices.get(i).getText();
            Assert.assertEquals("Product name mismatch at index " + i, expectedName, actualName);
            Assert.assertEquals("Price mismatch for product: " + expectedName, expectedPrice, actualPrice);
        }
    }
}

