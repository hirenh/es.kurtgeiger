package stefdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver_helpers.DriverHelpers;
import pageobject.HomePage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BrandsStepDef extends DriverHelpers {
    HomePage homePage=new HomePage();
    public String actual;
    @Given("^I am on the homepage$")
    public void i_am_on_the_homepage()  {
        homePage.isOnHomepage();
        assertThat(homePage.isOnHomepage(),is(true));

    }

    @When("^I select \"([^\"]*)\" category from the header$")
    public void iSelectCategoryFromTheHeader(String category)  {
      homePage.selectCategoryFromHeader(category);
    }

    @Then("^I should see the list of brands$")
    public void i_should_see_the_list_of_brands()  {
        homePage.titleOfPage(actual);
        assertThat(homePage.titleOfPage(actual),containsString("Shop By Brand"));
    }




    @And("^I select \"([^\"]*)\" brand from the list$")
    public void iSelectBrandFromTheList(String arg0) {
       // homePage.hooverToHeaderElements("Shop All Brands");
        homePage.selectBrand(arg0);
    }

    @Then("^I should see the list of products from \"([^\"]*)\"$")
    public void iShouldSeeTheListOfProductsFrom(String arg0) {
        homePage.getBrand(arg0);
    }
}
