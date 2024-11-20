package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P01_login;

import static pages.P01_login.*;
import static pages.P02_Addtocart.*;
public class D02_Addtocart {
    @Given("the user is on the homepage")
    public void user_is_on_home_page() throws Exception {
     send_key_username();
      send_key_pass();
        home_page();
    }
    @When("the user add product to cart")
    public void user_select_the_products(){
       add_to_cart();
    }
    @And("the user navigates to their shopping cart")
    public void user_navigate_to_shopping_cart(){
    shopping_cart();
    }
    @Then("the selected product should be visible in the shopping cart")
    public void selected_product_is_visible() throws InterruptedException {
    check_shooping_cart();
    }
    @When ("the user removes an item")
    public void user_removes_items(){
        remove_items();
    }
    @Then ("the item should no longer appear in the shopping cart")
    public void item_should_be_removed() throws InterruptedException {
        item_removed();
    }
    @When ("the user click on checkout button")
    public void user_click_on_checkout_btn(){
        checkout_btn();
    }
    @And  ("the user enter valid credentials")
    public void user_enter_valid_credentials()throws Exception{
        enter_credentials();
    }
    @And ("the user click continue")
    public void user_click_continue(){
        click_continue();
    }
    @And ("the user click finish")
    public void user_click_finish(){
        click_finish();
    }
    @Then ("the user should see a confirmation message that the order has been successfully placed")
    public void confirmation_message_appear(){
        confirmation_message();
    }
}
