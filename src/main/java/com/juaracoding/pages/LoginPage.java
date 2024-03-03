package com.juaracoding.pages;

import com.juaracoding.Drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement txtapplLogo;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement btnMenu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement btnLogout;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement txtInvalidCredentials;

    @FindBy(xpath = "User masih berada di halaman login")
    private WebElement txtappLogoLogin;

    // bisa digunakan precondition
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void inputUsername(String Username){
        this.username.sendKeys(Username);
    }
    public void deleteUsername(){
        username.clear();
    }

    public void inputPassword(String Password){ this.password.sendKeys(Password); }
    public void deletePassword(){
        password.clear();
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    // return getText
    public String getTxtDasboard(){
        return txtapplLogo.getText();
    }
    public String getTxtlogin(){
        return txtappLogoLogin.getText();
    }

    public void logout(){
        btnMenu.click();
        btnLogout.click();
    }

    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }




}
