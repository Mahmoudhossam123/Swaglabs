package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static pages.P03_productsprice.*;

public class D03_productsprice {

    @Then("the prices of the products should match the following:")
    public void prices_of_products(DataTable dataTable) throws InterruptedException {
        verify_multiple_prices(dataTable);
    }
}
