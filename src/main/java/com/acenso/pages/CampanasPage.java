package com.acenso.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.acenso.utils.Utilidades;

import io.qameta.allure.Step;

public class CampanasPage extends BasePage{
	
	By btnMisCampanas = By.xpath("//button[@id='button_redirect_dashboard']/div");
	By btnVerCampana = By.id("detail_see_4");
	By btnVerDetalle = By.xpath("//div[3]/div/div/div[2]/div[2]/div[2]/div/button/div");
	By btnSimular = By.xpath("//div[7]/button/div");
	By txtMontoInvertir = By.id("simulator-input");
	By btnDescargarDetalles = By.id("detail_campaign");
	By btnInvertir = By.xpath("//div[2]/div[2]/button/div");
	By btnCargar = By.id("go-to-recharge");
	By txtMontoCargar = By.id("amount");
	By selBanco = By.name("bank");
	By txtDocumento = By.id("documentNumber");
	By btnCargarInversion = By.id("continue-button");

	public CampanasPage(WebDriver driver) {
		super(driver);
		
	}
	
	@Step("Ver Detalles de Una Campaña")
	public CampanasPage verDetalleCampana() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnVerDetalle);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Simular Campaña")
	public CampanasPage simularCampana() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnSimular);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Ingresar Monto a Invertir")
	public CampanasPage ingresarMontoCampana(String monto) {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
		writeText(txtMontoInvertir, monto);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Simular Campaña")
	public CampanasPage descargarDetalleInversion() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        JavascriptExecutor js = (JavascriptExecutor) driver;        
        js.executeScript("document.querySelector('.sc-cdpFOc').scrollTop=2000");
        click(btnDescargarDetalles);
        Utilidades.screenshot();
        Utilidades.waitInMs(20000);
		return this;
	}
	
	@Step("Invertir en la Campaña")
	public CampanasPage invertirCampana() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnInvertir);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Cargar Inversion Campaña")
	public CampanasPage cargarInversionCampana() {
		Utilidades.waitInMs(3000);
		Utilidades.screenshot();
        click(btnCargar);
        Utilidades.screenshot();
        Utilidades.waitInMs(1000);
		return this;
	}
	
	@Step("Ingresar Monto a Cargar")
	public CampanasPage ingresarMontoCargar(String monto, String banco, String documento) {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
		writeText(txtMontoCargar, monto);
		Utilidades.waitInMs(500);
		Select unoSel = new Select(driver.findElement(selBanco));
		unoSel.selectByVisibleText(banco);
		Utilidades.waitInMs(500);
		writeText(txtDocumento, documento);
		Utilidades.waitInMs(500);
        Utilidades.screenshot();
        click(btnCargarInversion);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	

}
