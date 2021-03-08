package com.acenso.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.acenso.utils.Utilidades;

import io.qameta.allure.Step;

public class CertificadosPage extends BasePage {
	
	By btnMisCertificados = By.xpath("//button[@id='button_redirect_certificates']/div");
	By lblCertificadoRetencion = By.xpath("//div[2]/div/div/h1");
	By lblReporteAnual = By.xpath("//*[@id=\"wrapper-id\"]/div[2]/div[2]/div[2]/div[1]");
	By btnEnviar = By.xpath("//a/img");

	public CertificadosPage(WebDriver driver) {
		super(driver);
		
	}
	
	@Step("Seleccionar Mis Certifcados")
	public CertificadosPage seleccionarMisCertificados() {
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
        click(btnMisCertificados);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Seleccionar Certifcado Retencion")
	public CertificadosPage seleccionarCertificadoRetencion() {
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
        click(btnMisCertificados);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Enviar Certifcado Retencion")
	public CertificadosPage enviarCertificadoRetencion() {
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
        click(btnEnviar);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	

}
