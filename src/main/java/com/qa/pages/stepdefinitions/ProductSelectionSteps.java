package com.qa.pages.stepdefinitions;

import com.qa.pages.account.AccountPageQuestions;
import com.qa.pages.cart.CartPopUpActions;
import com.qa.pages.homepage.HomePageActions;
import com.qa.pages.navingation.NavigateActions;
import com.qa.pages.productpage.ProductPageActions;
import com.qa.pages.signin.SignInPageActions;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class ProductSelectionSteps {

  @Steps
  NavigateActions navigateTo;

  @Steps
  HomePageActions homePageActions;

  @Steps
  CartPopUpActions cartPopUpActions;

  @Steps
  ProductPageActions productPageActions;

  @Steps
  SignInPageActions signInPageActions;

  @Steps
  AccountPageQuestions accountPageQuestions;

  @Given("Joe, an existing customer ordered:")
  public void existing_customer_ordered(List<Map<String, String>> products) {
    navigateTo.theSignInPage();
    signInPageActions.loginAsExistingUser();
    accountPageQuestions.verifyUserInAccountPage();

    //Add each product item to cart and proceed to checkout
    int itemCount = products.size();
    for (Map<String, String> product : products) {
      homePageActions.selectCategory(product.get("Section"));
      homePageActions.selectItem(product.get("Product"));
      productPageActions.addItemToCart();
      if (itemCount != 1) {
        cartPopUpActions.continueShopping();
        itemCount = itemCount-1;
      } else {
        cartPopUpActions.proceedToCheckout();
      }
    }
  }
}
