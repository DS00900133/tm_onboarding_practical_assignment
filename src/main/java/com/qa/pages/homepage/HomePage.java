package com.qa.pages.homepage;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebElement;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

  static final String PRODUCT = "//a[@title='{0}' and @class='product-name']";
  static final String SECTION = "//a[text()='{0}']";

  public Boolean isLogoDisplayed() {

    return null;
  }
}
