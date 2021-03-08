package com.acenso.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.acenso.pages.CampanasPage;
import com.acenso.pages.CertificadosPage;
import com.acenso.pages.HomePage;
import com.acenso.pages.LoginPage;
import com.acenso.pages.RegistroPage;

public class BaseTest {

    public WebDriver driver;
    
    public HomePage home;
    public RegistroPage registro;
    public LoginPage login;
    public CertificadosPage certificado;
    public CampanasPage campanas;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void inicializar() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1000,1000");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        home = new HomePage(driver);
        registro = new RegistroPage(driver);
        login = new LoginPage(driver);
        certificado = new CertificadosPage(driver);
        campanas = new CampanasPage(driver);
    }

    @AfterMethod
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
