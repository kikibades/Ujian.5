package com.juaracoding;

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

public class LoginTest {

    private static WebDriver driver;
    public static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User berada di halaman login")
    public void user_berada_di_halaman_login(){
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "User berada di halaman login");
    }

    @When("User memasukan username yang salah")
    public void user_memasukan_username_yang_salah(){
        loginPage.inputUsername("testsauce");
        extentTest.log(LogStatus.PASS, "User memasukan username yang salah");
    }

    @And("User memasukan password yang salah")
    public void user_memasukan_password_yang_salah(){
        loginPage.inputPassword("secret_sauce");
        extentTest.log(LogStatus.PASS, "User memasukan password yang salah");
    }

    @When("Sistem menampilkan pesan kesalahan Invalid credentials")
    public void sistem_menampilkan_pesan_kesalahan_invalid_credentials(){
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Epic sadface: Username and password do not match any user in this service"); // test screenshot
        extentTest.log(LogStatus.PASS, "Sistem menampilkan pesan kesalahan Invalid credentials");
    }

//    @Then("User mengakses halaman login")
//    public void user_mengakses_halaman_login(){
//
//        extentTest.log(LogStatus.PASS, "User mengakses halaman login");
//    }

    @Then("User memasukan username yang valid")
    public void user_memasukan_username_yang_valid(){
        loginPage.deleteUsername();
        loginPage.inputUsername("standard_user");
        extentTest.log(LogStatus.PASS, "User memasukan username yang valid");
    }

    @And("User memasukan password yang valid")
    public void user_memasukan_password_yang_valid(){
        loginPage.deletePassword();
        loginPage.inputPassword("secret_sauce");
        extentTest.log(LogStatus.PASS, "User memasukan password yang valid");
    }

    @And("User klik tombol login")
    public void user_klik_tombol_login(){
        loginPage.clickBtnLogin();
        extentTest.log(LogStatus.PASS, "User klik tombol login");
    }

    @And("User berhasil login dan diarahkan ke halaman utama atau dashboard")
    public void user_berhasil_login_dan_diarahkan_ke_halaman_utama_atau_dashboard(){
        Assert.assertEquals(loginPage.getTxtDasboard(), "Products");
        extentTest.log(LogStatus.PASS, "User berhasil login dan diarahkan ke halaman utama atau dashboard");
        try {
            // Memberhentikan eksekusi utas selama 3 detik (3000 milidetik)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program resumed after sleep");
    }
//
//    @Given("User masih berada di halaman login")
//    public void user_masih_di_halaman_login(){
//        Assert.assertEquals(loginPage.getTxtlogin(), "Login");
//        extentTest.log(LogStatus.PASS, "User masih berada di halaman login");
//    }
//
//    @And("User memasukan password yang salah")
//    public void user_salah_password(){
//        loginPage.inputPassword("saucedemo213");
//        extentTest.log(LogStatus.PASS, "User memasukan password yang salah");
//    }


}