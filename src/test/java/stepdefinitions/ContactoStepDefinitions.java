package stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import nominal.step.ContactoSteps;

public class ContactoStepDefinitions {

    @Steps
    ContactoSteps objContactoSteps;

    @Dada("^la siguiente url \"([^\"]*)\"$")
    public void laSiguienteUrl(String url) {
        objContactoSteps.lanzarNavegador(url);
    }


    @Cuando("^hacemos clic en el enlace de \"([^\"]*)\"$")
    public void hacemosClicEnElEnlaceDe(String arg1) {
        objContactoSteps.formularioContacto();
    }

    @Entonces("^capturar el numero de celular de servicio al cliente$")
    public void capturarElNumeroDeCelularDeServicioAlCliente() {

    }

    @Entonces("^llenar el formulario \"([^\"]*)\" y en el campo mensaje adjuntar el numero de celular capturado$")
    public void llenarElFormularioYEnElCampoMensajeAdjuntarElNumeroDeCelularCapturado(String arg1) {
        objContactoSteps.diligenciarDatos();
    }

    @Entonces("^antes de hacer clic en el boton \"([^\"]*)\" tomar un pantallazo con la informacion diligenciada$")
    public void antesDeHacerClicEnElBotonTomarUnPantallazoConLaInformacionDiligenciada(String arg1) throws InterruptedException {
        Serenity.takeScreenshot();
        objContactoSteps.mensaje();
    }
}
