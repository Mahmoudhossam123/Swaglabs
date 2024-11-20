package StepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.P01_login.*;

public class D01_login {
    @Given("user navigate to \"login\" page")
    public void user_navigate_to_login_page() {

    }
    @When("the user enter a valid username")
    public void user_enter_valid_user() throws Exception {
            send_key_username();
    }
   @And("the user enter a valid password")
        public void user_enter_valid_pass() throws Exception {
            send_key_pass();
       }
    @Then("the user can navigate to the home page")
    public void user_navigate_to_home_page(){
            home_page();

    }
    @When("the user enter a invalid username")
    public void user_enter_invalid_user() throws Exception {
        invalid_user();
    }
    @And("the user enter a invalid password")
    public void user_enter_invalid_pass() throws Exception {
       invalid_pass();
    }
    @Then("the user can not navigate to the home page")
    public void user_cant_navigate_to_home_page(){
        invalid_login_msg();

    }
}
