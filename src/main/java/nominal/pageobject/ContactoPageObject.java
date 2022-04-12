package nominal.pageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactoPageObject extends PageObject {

    WebDriver markersDriver;

    By linkContacto = By.xpath("//a[@href='https://somosmakers.co/contacto/' and contains (text(), 'Contacto')]");
    By txtCel = By.xpath("//a[@href='tel:+57%20(315) 369 6145']");
    By txtTitleDejaMsj = By.xpath("//p[contains(text(), 'Déjanos un mensaje')]");
    By txtNombre = By.xpath("//input[@placeholder='Nombre']");
    By txtApellido = By.xpath("//input[@placeholder='Apellido']");
    By txtEmail = By.xpath("//input[@placeholder='Email']");
    By txtTelefono = By.xpath("//input[@placeholder='Teléfono']");
    By txtTMensaje = By.xpath("//textarea[@placeholder='Mensaje']");
    By btnMensaje = By.xpath("//button[contains(text(), 'Enviar Mensaje')]");


    public void abrirPagina(String url){
        url = "https://somosmakers.co/";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        markersDriver = new ChromeDriver();
        markersDriver.manage().window().maximize();
        markersDriver.get(url);
    }

    public WebElement contacUs(){
        WebElement contac = markersDriver.findElement(linkContacto);
        return contac;
    }

    public WebElement titleMsj(){
        WebElement title = markersDriver.findElement(txtTitleDejaMsj);
        return title;
    }

    public WebElement setNombre(){
        WebElement name = markersDriver.findElement(txtNombre);
        return name;
    }

    public WebElement setApellido(){
        WebElement latname = markersDriver.findElement(txtApellido);
        return latname;
    }

    public WebElement setEmail(){
        WebElement mail = markersDriver.findElement(txtEmail);
        return mail;
    }

    public WebElement setPhone(){
        WebElement numberPhone = markersDriver.findElement(txtTelefono);
        return numberPhone;
    }

    public WebElement getCel(){
        WebElement celPhone = markersDriver.findElement(txtCel);
        return celPhone;
    }

    public WebElement setMessage(){
        WebElement message = markersDriver.findElement(txtTMensaje);
        return message;
    }

    public WebElement sendMessage(){
        WebElement submitMessage = markersDriver.findElement(btnMensaje);
        return submitMessage;
    }

    public void close(){
        markersDriver.close();
    }

}
