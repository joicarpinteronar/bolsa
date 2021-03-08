package com.acenso.test;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acenso.test.utils.Listeners.TestListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Certificados")
@Feature("Mis Certificados")

public class CertificadosTest extends BaseTest{
	public Properties fileprops = new Properties();
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        fileprops.load(new FileInputStream(new File("src/test/resources/login.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Seleccionar Certificado Retencion en la Fuente")
    @Severity(SeverityLevel.NORMAL)
    @Description("Certificado Retencion")
    @Story("Certificado Retencion")
    @TmsLink("XRPRJ-1")
    public void seleccionarCertificadoRetencion () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.iniciarSesion()
		.ingresarCredenciales(getProperties().getProperty("correo"), getProperties().getProperty("password"));
		certificado.seleccionarMisCertificados()
		.seleccionarCertificadoRetencion()
		.enviarCertificadoRetencion();
		
        
        
    }

}
