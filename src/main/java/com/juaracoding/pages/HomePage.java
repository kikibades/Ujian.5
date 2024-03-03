package com.juaracoding.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForHeaderSpan() {
        // Periksa apakah driver tidak null sebelum digunakan
        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            // Tunggu hingga elemen muncul
            WebElement headerSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header_container']/div[2]/span")));

            // Pastikan elemen ada sebelum melanjutkan
            if (headerSpan != null) {
                // Lanjutkan dengan langkah-langkah berikutnya...
            } else {
                // Jika elemen tidak ditemukan, Anda dapat melemparkan Exception atau menangani sesuai kebutuhan.
                // Contoh: throw new RuntimeException("Header span not found");
            }
        } else {
            // Jika driver null, Anda dapat melemparkan Exception atau menangani sesuai kebutuhan.
            // Contoh: throw new RuntimeException("WebDriver is not initialized");
        }
    }

    // ...Metode lainnya untuk interaksi dengan elemen pada halaman home
}

    // ... Metode lainnya untuk interaksi dengan elemen pada halaman home

