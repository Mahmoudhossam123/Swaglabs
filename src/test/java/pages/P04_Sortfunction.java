package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Hooks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class P04_Sortfunction extends Hooks {

    public static void clickSortButton(String sortOption) {
        By sortDropdown = By.className("product_sort_container");
        getDriver().findElement(sortDropdown).click();

        By option = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/" + sortOption );


        getDriver().findElement(option).click();
    }

    public static void verifyProductSorting(String order) {
        boolean isSorted = checkIfProductsAreSorted(order);
        assertTrue("products sorted un successfully", isSorted);
    }

    public static boolean checkIfProductsAreSorted(String order) {
        List<WebElement> productPrices = getDriver().findElements(By.cssSelector(".inventory_item_price"));

        List<Double> prices = new ArrayList<>();
        for (WebElement price : productPrices) {
            String priceText = price.getText().replace("$", "").trim();
            prices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        if (order.equals("A to Z")) {
            Collections.sort(sortedPrices);
        } else if (order.equals("Z to A")) {
            Collections.sort(sortedPrices, Collections.reverseOrder());
        } else if (order.equals("Price (low to high)")) {
            Collections.sort(sortedPrices);
        } else if (order.equals("Price (high to low)")) {
            Collections.sort(sortedPrices, Collections.reverseOrder());
        }

        return prices.equals(sortedPrices);
    }



}
