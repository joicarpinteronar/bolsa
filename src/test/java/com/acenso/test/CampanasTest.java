package com.acenso.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acenso.test.utils.Listeners.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Listeners({ TestListener.class })
@Epic("Campañas")
@Feature("Simular Inversiones")

public class CampanasTest extends BaseTest {
	public Properties fileprops = new Properties();
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        fileprops.load(new FileInputStream(new File("src/test/resources/login.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Simular Campañas e Invertir")
    @Severity(SeverityLevel.NORMAL)
    @Description("Simular Campañas")
    @Story("Simular Inversion")
    @TmsLink("XRPRJ-1")
    public void simularInversion () throws Exception {
		home.irPortal(getProperties().getProperty("url"));		
		campanas.verDetalleCampana()
		.simularCampana()
		.ingresarMontoCampana("1000000")
		.descargarDetalleInversion();
      }
	
	@Test(priority=1, description="Aplicar Inversion")
    @Severity(SeverityLevel.NORMAL)
    @Description("Realizar Inversion Campañas")
    @Story("Aplicar Inversion")
    @TmsLink("XRPRJ-1")
    public void realizarInversion () throws Exception {
		home.irPortal(getProperties().getProperty("url"));		
		campanas.invertirCampana();
		login.ingresarCredenciales(getProperties().getProperty("correo"), getProperties().getProperty("password"));
		campanas.cargarInversionCampana()
		.ingresarMontoCargar("200000","BAN.CO","1096523418");
		
      }

}
