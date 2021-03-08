package com.acenso.test;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acenso.test.utils.Listeners.TestListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Iniciar Sesion")
@Feature("Iniciar Sesion Portal a2censo")

public class LoginTest extends BaseTest{
	public Properties fileprops = new Properties();
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        fileprops.load(new FileInputStream(new File("src/test/resources/login.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Iniciar Sesion Portal")
    @Severity(SeverityLevel.NORMAL)
    @Description("Iniciar Sesion")
    @Story("Iniciar Sesion")
    @TmsLink("XRPRJ-1")
    public void iniciarSesion () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.iniciarSesion()
		.ingresarCredenciales(getProperties().getProperty("correo"), getProperties().getProperty("password"));
		
		
        
        
    }

}
