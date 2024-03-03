package com.juaracoding;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class allflowTest {

    private static WebDriver driver;
    public static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static CartPage cartPage = new CartPage();
    private static CheckoutPage checkoutpage = new CheckoutPage();


    public allflowTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User berada di halaman login1")
    public void user_login() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "User berada di halaman login1");

    }
    @When("User memasukan kredensial yang salah")
    public void user_memasukan_kredensial_salah(){
        loginPage.inputUsername("testsauce");
        loginPage.inputPassword("secret_sauce");
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS, "User memasukan kredensial yang salah");
    }
    @Then("User memasukan kredensial yang benar")
    public void user_memasukan_kredensial_benar(){
        loginPage.deleteUsername();
        loginPage.inputUsername("standard_user");
        loginPage.deletePassword();
        loginPage.inputPassword("secret_sauce");
        loginPage.clickBtnLogin();
        Assert.assertEquals(loginPage.getTxtDasboard(), "Products");
        extentTest.log(LogStatus.PASS, "User memasukan kredensial yang benar");
    }

    @When("User menambahkan product ke dalam cart1")
    public void User_menambah_product(){
        cartPage.clickBtnATC();
        cartPage.clickBtnATC2();
        cartPage.clickCart();
        extentTest.log(LogStatus.PASS, "User menambahkan product ke dalam cart1");
    }

    @Then("User Checkout Product1")
    public void user_ke_checkout(){
        checkoutpage.clickcheckout();
        extentTest.log(LogStatus.PASS, "User Checkout Product1");
    }

    @When("User memasukan informasi yang salah1")
    public void user_masukan_informasi_salah(){
        checkoutpage.failedcheckout("kiki", "bayu");
        checkoutpage.clickContinue();
        Assert.assertEquals(checkoutpage.getErrorMessage(), "Error: Postal Code is required");
        extentTest.log(LogStatus.PASS, "User memasukan informasi yang salah1");
    }

    @Then("User memasukkan informasi yang benar1")
    public void user_memasukan_informasi_benar(){
        checkoutpage.checkout("kiki", "bayu", "16436 Pancoran Mas");
        checkoutpage.clickContinue();
        Assert.assertEquals(checkoutpage.getProduct1value(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(checkoutpage.getProduct2value(), "Sauce Labs Fleece Jacket");
        checkoutpage.clickFinish();
        checkoutpage.clickBackHome();
        extentTest.log(LogStatus.PASS, "User memasukkan informasi yang benar1");
    }

}
