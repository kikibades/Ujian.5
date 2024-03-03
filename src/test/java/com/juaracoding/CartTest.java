package com.juaracoding;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
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

public class CartTest {

    private static WebDriver driver;
    public static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static CartPage cartPage = new CartPage();
    private HomePage homePage;



    public CartTest(){
//        this.driver = driver;
//        this.homePage = new HomePage(driver);
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }


    @Given("User berada di home page")
    public void user_berada_di_home_page(){
//        driver.get(Constants.URL2);
//        homePage.waitForHeaderSpan();
        Assert.assertEquals(cartPage.getValidasi(), "Products");
        extentTest.log(LogStatus.PASS, "User berada di home page");
    }

    @When("User menambahkan specific product kedalam keranjang")
    public void user_nemambahkan_product_kedalam_keranjang(){
        cartPage.clickBtnATC();
        cartPage.clickBtnATC2();
        extentTest.log(LogStatus.PASS, "User menambahkan specific product kedalam keranjang");
    }

    @Then("Keranjang harus menampilkan product yang benar")
    public void user_memastikan_product_masuk_keranjang(){
        cartPage.clickCart();
        Assert.assertEquals(cartPage.getTxtProduct1(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getTxtProduct2(), "Sauce Labs Fleece Jacket");
        extentTest.log(LogStatus.PASS, "Keranjang harus menampilkan product yang benar");
        try {
            // Memberhentikan eksekusi utas selama 3 detik (3000 milidetik)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program resumed after sleep");
    }
}
