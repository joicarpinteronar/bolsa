package com.acenso.test;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acenso.test.utils.Listeners.TestListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Registro Nuevo Usuario Portal a2censo")
@Feature("Crear Cuenta Portal a2censo")

public class RegistroTest extends BaseTest {
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Crear Nueva Cuenta Portal a2censo", threadPoolSize = 3, invocationCount = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Crear Nueva Cuenta")
    @Story("Crear Cuenta")
    @TmsLink("XRPRJ-1")
    public void crearNuevaCuenta () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		registro.crearCuenta()
		.seleccionarQuieroInvertir()
		.seleccionarPersonaNatural()
		.ingresarDatos(getProperties().getProperty("nombre"),
				       getProperties().getProperty("primerApellido"),
				       getProperties().getProperty("segundoApellido"),
				       getProperties().getProperty("identificacion"),
				       getProperties().getProperty("confirmarIdentificacion"),
				       getProperties().getProperty("correo"),
				       getProperties().getProperty("celular"),
				       getProperties().getProperty("password"),
				       getProperties().getProperty("confirmarPassword"))
		.aceptarTerminosPoliticas()
		//.seleccionarCaptcha()
		.seleccionarContinuar()
		;
		
        
        
    }

}
