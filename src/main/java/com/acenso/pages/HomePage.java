package com.acenso.pages;

import org.openqa.selenium.WebDriver;

import com.acenso.pages.HomePage;
import com.acenso.utils.Utilidades;

import io.qameta.allure.Step;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@Step("Abrir Portal a2censo. Url {0}")
    public HomePage irPortal(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new HomePage(driver);
    }

}
