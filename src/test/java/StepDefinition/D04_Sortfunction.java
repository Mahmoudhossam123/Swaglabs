package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static pages.P04_Sortfunction.*;



public class D04_Sortfunction {



    @When("the user chooses {string} sort option")
    public void user_choose_sort_option(String sortOption) {

        clickSortButton(sortOption);
    }

    @Then("the products should be sorted according to {string}")
    public void products_should_be_sorted(String sortOption) {
        verifyProductSorting(sortOption);
    }
}
