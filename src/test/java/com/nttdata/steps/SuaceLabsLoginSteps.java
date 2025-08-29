package com.nttdata.steps;

import com.nttdata.screens.SauceLoginScreen;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;

public class SuaceLabsLoginSteps {
    SauceLoginScreen login;

    //Prueba automation web
    public void validacionProductos() {
        Assert.assertEquals(4, login.getCountProductos());
    }

    public void seleccionarProducto(String producto) {
        login.clickProducto(producto);
    }

    public void agregaUnidades(int unidades) {
        login.agregarUnidades(unidades);

    }

    public void añadiralCarrito() {
        login.añadirAlCarrito();
    }


    public void clickcarrito() {
        login.clickcarrito();
    }

    public void validocarrito() {
        login.validocarrito();
    }
}
