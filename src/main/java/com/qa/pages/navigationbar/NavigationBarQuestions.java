package com.qa.pages.navigationbar;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationBarQuestions extends UIInteractionSteps {

  public String getCurrentUserName() {
    return $(NavigationBarPage.ACCOUNT_USER_NAME).getText();
  }

  @Step
  public void verifyLogoutLink() {
    $(NavigationBarPage.LOGOUT_LINK).isDisplayed();
  }

  @Step
  public void verifyLoggedInUser(String userName) {
    assertThat(getCurrentUserName().toLowerCase().contains(userName.toLowerCase())).isTrue();
  }
}
