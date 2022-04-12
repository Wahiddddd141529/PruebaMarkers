package nominal.step;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import nominal.pageobject.ContactoPageObject;
import util.Utilidades;

import java.util.HashMap;

public class ContactoSteps {

    ContactoPageObject contactoPageObject;
    Utilidades util = new Utilidades();
    public static String Nombre;
    public static String Apellido;
    public static String Email;
    public static String Telefono;
    public static String Mensaje;
    String celSoporte;

    @Step
    public void lanzarNavegador(String url){
        contactoPageObject.abrirPagina(url);
    }

    @Step
    public void formularioContacto(){
        contactoPageObject.contacUs().click();
    }

    @Step
    public void diligenciarDatos() {
        try {
            HashMap<String, String> mapa = util.get_datosPersona();
            this.Nombre = mapa.get("Nombre");
            this.Apellido = mapa.get("Apellido");
            this.Email = mapa.get("Email");
            this.Telefono = mapa.get("Telefono");
            this.Mensaje = mapa.get("Mensaje");
            if(contactoPageObject.titleMsj().isDisplayed()){
                contactoPageObject.setNombre().sendKeys(Nombre);
                contactoPageObject.setApellido().sendKeys(Apellido);
                contactoPageObject.setEmail().sendKeys(Email);
                contactoPageObject.setPhone().sendKeys(Telefono);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Step
    public void mensaje() throws InterruptedException {
        celSoporte = contactoPageObject.getCel().getText();
        contactoPageObject.setMessage().sendKeys(Mensaje + " " + celSoporte);
        Thread.sleep(6000);
        contactoPageObject.sendMessage().click();
        Thread.sleep(6000);
        contactoPageObject.close();
    }
}
