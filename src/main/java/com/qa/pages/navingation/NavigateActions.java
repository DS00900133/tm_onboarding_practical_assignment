package com.qa.pages.navingation;

import com.qa.pages.homepage.HomePage;
import com.qa.pages.homepage.HomePageQuestions;
import com.qa.pages.navigationbar.NavigationBarActions;
import com.qa.pages.signin.SignInPage;
import com.qa.pages.signin.SignInPageQuestions;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class NavigateActions extends UIInteractionSteps {


  HomePage homePage;
  SignInPage signInPage;

  @Steps
  HomePageQuestions homePageQuestions;

  @Steps
  SignInPageQuestions signInPageQuestions;

  @Steps
  NavigationBarActions navigationBarActions;

  @Step("Navigate to home page")
  public void theHomePage() {
    homePage.open();
    homePageQuestions.verifyUserInHomePage();
  }

  @Step("Navigate to Log in page")
  public void theLoginPage() {
    navigationBarActions.goToSignInPage();
    signInPageQuestions.verifyUserInSignInPage();
  }

  @Step("Navigate to sign in page")
  public void theSignInPage() {
    signInPage.open();
    signInPageQuestions.verifyUserInSignInPage();
  }
}
