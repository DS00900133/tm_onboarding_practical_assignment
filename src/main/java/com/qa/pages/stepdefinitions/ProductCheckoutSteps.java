package com.qa.pages.stepdefinitions;

import com.qa.pages.cartaddress.CartAddressPageActions;
import com.qa.pages.cartpayment.CartPaymentPageActions;
import com.qa.pages.cartpayment.CartPaymentPageQuestions;
import com.qa.pages.cartshipping.CartShippingPageActions;
import com.qa.pages.cartsummary.CartSummaryPageActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductCheckoutSteps {

  @Steps
  CartSummaryPageActions cartSummaryPageActions;

  @Steps
  CartAddressPageActions cartAddressPageActions;

  @Steps
  CartShippingPageActions cartShippingPageActions;

  @Steps
  CartPaymentPageActions cartPaymentPageActions;

  @Steps
  CartPaymentPageQuestions cartPaymentPageQuestions;

  @Given("navigated to payments page")
  public void navigated_to_payments_page() {
    cartSummaryPageActions.proceedToCheckout();
    cartAddressPageActions.proceedToCheckout();
    cartShippingPageActions.confirmTerms();
    cartShippingPageActions.proceedToCheckout();
  }

  @When("opts \"Pay by bank wire\" payment method")
  public void select_pay_by_bank_wire_payment_method() {
    cartPaymentPageActions.payByBankWire();
  }

  @When("confirms the order")
  public void confirms_the_order() {
    cartPaymentPageActions.confirmOrder();
  }

  @Then("should be taken to order confirmation page")
  public void user_should_be_taken_to_order_confirmation_page() {
    cartPaymentPageQuestions.verifyUserInOrderConfirmationPage();
  }

  @And("order should be completed successfully")
  public void orderShouldBeCompletedSuccessfully() {
    cartPaymentPageQuestions.verifyOrderConfirmationMessage();
    cartPaymentPageQuestions.confirmLastOrderingStep();
  }
}
