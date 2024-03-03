package com.juaracoding.pages;

import com.juaracoding.Drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement btnATC1;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    private WebElement btnATC2;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement CartIcon;

    //Validasi product sudah di cart
    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    private WebElement ProductName1;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    private WebElement ProductName2;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    private WebElement TxtHomepage;

    public void clickBtnATC(){
        btnATC1.click();
    }
    public void clickBtnATC2(){ btnATC2.click(); }
    public void clickCart(){ CartIcon.click(); }

    public String getTxtProduct1(){
        return ProductName1.getText();
    }
    public String getTxtProduct2(){ return ProductName2.getText(); }
    public String getValidasi(){ return TxtHomepage.getText(); }

}
