package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;

import java.util.List;

public class SauceLoginScreen extends PageObject {

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.saucelabs.mydemoapp.android:id/productRV']/android.view.ViewGroup")
    private List<WebElement> listaProductos;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement btnmas;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnaddtocart;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement btncart;


    //prueba automation web
    public int getCountProductos(){
        return listaProductos.size();
    }

    public void clickProducto(String producto) {
        WebElement product = getDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc=\""+producto+"\"]"));
        product.click();
    }

    public void agregarUnidades(int unidades) {

        //se debe realizar un scroll porque no es visible por defecto
        getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().description(\"Increase item quantity\"))"));

        for (int i = 1; i < unidades; i++) {
            btnmas.click();
        }
    }

    public void añadirAlCarrito() {
        btnaddtocart.click();
    }


    public void clickcarrito() {
        btncart.click();
    }


    public void validocarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]")));

    }
}
