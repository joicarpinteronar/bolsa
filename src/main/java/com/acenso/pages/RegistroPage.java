package com.acenso.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.acenso.utils.Utilidades;

import io.qameta.allure.Step;

public class RegistroPage extends BasePage{
	
	By btnCrearCuenta = By.xpath("//div[3]/button/div");
	By opcionQuieroInvertir = By.id("sign-up-card-1");
	By opcionPersonaNatural = By.id("person-type-card-natural");
	By selTipoDocumento = By.name("documentType");
	By txtNombre = By.id("name");
	By txtPrimerApellido = By.id("lastname");
	By txtSegundoApellido = By.id("second_lastname");
	By txtNumeroIdentificacion = By.id("documentNumber");
	By txtConfirmarIdentificacion = By.id("confirmDocument");
	By txtCorreo = By.id("email");
	By txtCelular = By.id("phoneNumber");
	By txtPassword = By.id("password");
	By txtConfirmarPassword = By.id("confirmPassword");
	By rbtnAceptarPoliticas = By.id("checkbox-politics");
	By scrollPoliticas = By.id("politics-modal-content");
	By btnAceptarPoliticas = By.id("continue-button");
	By rbtnAceptaTerminos = By.id("checkbox-terms");
	By scrollTerminos = By.id("terms-modal-content");
	By btnAceptarTerminos = By.id("continue-button");
	By lblPoliticas = By.xpath("//div/div/div/div/p");
	By chkCapcha = By.xpath("/html/body/div[3]/div[3]/div[1]/div/div/span/div[1]");
	By btnContinuar = By.id("send_button");
	
	

	public RegistroPage(WebDriver driver) {
		super(driver);
		
	}
	
	@Step("Crear Cuenta Portal a2censo")
	public RegistroPage crearCuenta() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnCrearCuenta);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Seleccionar la opcion Quiero Invertir")
	public RegistroPage seleccionarQuieroInvertir() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(opcionQuieroInvertir);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Seleccionar la opcion Persona Natural")
	public RegistroPage seleccionarPersonaNatural() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(opcionPersonaNatural);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Ingresar Datos Persona Natural")
	public RegistroPage ingresarDatos(String nombre, String primerApellido, String segundoApellido,
			                          String identificacion, String confirmarIdentificacion,
			                          String correo, String celular, String password, String confirmarPassword) {
		Utilidades.waitInMs(500);
        writeText(txtNombre, nombre);
        writeText(txtPrimerApellido, primerApellido);
        writeText(txtSegundoApellido, segundoApellido);
        writeText(txtNumeroIdentificacion, identificacion);
        writeText(txtConfirmarIdentificacion, confirmarIdentificacion);
        writeText(txtCorreo, correo);
        writeText(txtCelular, celular);
        writeText(txtPassword, password);
        writeText(txtConfirmarPassword, confirmarPassword);
       
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Aceptar Terminos Politicas y Condiciones")
	public RegistroPage aceptarTerminosPoliticas() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(rbtnAceptarPoliticas);
        Utilidades.waitInMs(500);
        Utilidades.screenshot();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("document.querySelector('#politics-modal-content').scrollTop=1000");
     
        Utilidades.waitInMs(1000);
       
        
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
        click(btnAceptarPoliticas);
        
        Utilidades.waitInMs(1000);
        js.executeScript("window.scrollBy(0,3000)");
        Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(rbtnAceptaTerminos);
        Utilidades.waitInMs(500);
        Utilidades.screenshot();
        
        js.executeScript("document.querySelector('#terms-modal-content').scrollTop=5000");
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
        click(btnAceptarTerminos);
        
		return this;
	}
	
	@Step("Seleccionar Captcha")
	public RegistroPage seleccionarCaptcha() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
		//driver.switchTo().defaultContent();
		
		driver.switchTo().frame(3);
        click(chkCapcha);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Seleccionar Continuar Registro")
	public RegistroPage seleccionarContinuar() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnContinuar);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	
	
}
