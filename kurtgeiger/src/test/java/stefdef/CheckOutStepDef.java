package stefdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.CheckOutPage;
import pageobject.HomePage;
import pageobject.PdpPage;
import utils.Utils;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckOutStepDef {

    Utils utils = new Utils();
    HomePage homePage = new HomePage();
    PdpPage pdpPage = new PdpPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Given("^I select men category from the header$")
    public void i_select_men_category_from_the_header() {

    }

    @Given("^I am on PDP$")
    public void i_am_on_PDP() {

        pdpPage.iAmOnPDPpage();
        assertThat(pdpPage.iAmOnPDPpage(), is(true));
    }


    @When("^I add the product to the bag$")
    public void i_add_the_product_to_the_bag() throws InterruptedException {

        pdpPage.goToBag();
    }

    @Then("^I can see the bag with single item$")
    public void i_can_see_the_bag_with_single_item() {
        pdpPage.totalItemsInBag();
        assertThat(pdpPage.totalItemsInBag(), containsString("MY BAG (1 ITEM)"));
    }

    @And("^I click 'Proceed to Checkout'$")
    public void i_click_Proceed_to_Checkout() {
        pdpPage.clickToProceedToCheckOut();
    }

    @Then("^I should be on checkout page$")
    public void i_should_be_on_checkout_page() {
        pdpPage.confirmedCheckOutPage();
        assertThat(pdpPage.confirmedCheckOutPage(), containsString("CHECKOUT / Welcome"));

    }

    @When("^I select colour \"([^\"]*)\" and size \"([^\"]*)\" for the chosen men category$")
    public void iSelectColourAndSizeForTheChosenMenCategory(String colour, String size) {

        pdpPage.colours(colour);
        pdpPage.size(size);
        pdpPage.addProduct();

    }

    @Given("^I checkout as a guest$")
    public void iCheckoutAsAGuest() {
        checkOutPage.loginAsAGuest();
    }

    @When("^I enter all the billing and delivery details$")
    public void iEnterAllTheBillingAndDeliveryDetails() {
        checkOutPage.dropDownTitleByPassingValue();

    }

    @And("^I click 'Continue to Payment'$")
    public void iClickContinueToPayment() {
        checkOutPage.contiuneToPayment();
    }

    @Then("^I should be on the payment summary page$")
    public void iShouldBeOnThePaymentSummaryPage() {
        pdpPage.confirmedCheckOutPage();
        assertThat(pdpPage.confirmedCheckOutPage(), containsString("CHECKOUT / Delivery & Billing"));
    }

    @When("^I select to pay by card$")
    public void iSelectToPayByCard() throws Throwable {
        checkOutPage.selectPaymentMethod();
    }

    @And("^I enter credit card \"([^\"]*)\" with \"([^\"]*)\" expiry date$")
    public void iEnterCreditCardWithExpiryDate(String arg0, String arg1) throws Throwable {
        checkOutPage.enterCreditCardAndExpiryDetails(arg0, arg1);
    }

    @And("^I enter \"([^\"]*)\" CVC code$")
    public void iEnterCVCCode(String arg0) {
        checkOutPage.cvcDetails(arg0);
        checkOutPage.cardDetails();
    }


    @Then("^I should see \"Your card number has failed our validity checks and appears to be incorrect Please check and re-enter”$")
    public void iShouldSeeYourCardNumberHasFailedOurValidityChecksAndAppearsToBeIncorrectPleaseCheckAndReEnter() throws Throwable {
        checkOutPage.cardValidityChecks();
        assertThat(checkOutPage.cardValidityChecks(), containsString("The Card Range not supported by the system."));
    }


}
