package com.acenso.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.acenso.utils.Utilidades;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	By btnIniciarSesion = By.xpath("//*[@id=\"header-sticky-pose\"]/header/div/nav/div[2]/button");
	By txtCorreo = By.id("email");
	By txtPassword = By.id("password");
	By btnLogin = By.xpath("//form/div[2]/button");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@Step("Iniciar Sesion")
	public LoginPage iniciarSesion() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnIniciarSesion);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Ingresar Credenciales de Acceso")
	public LoginPage ingresarCredenciales(String correo, String password) {
		Utilidades.waitInMs(500);
		
		writeText(txtCorreo, correo);
		writeText(txtPassword, password);
		Utilidades.screenshot();
		click(btnLogin);
        Utilidades.screenshot();
        Utilidades.waitInMs(1000);
		return this;
	}
 

}
