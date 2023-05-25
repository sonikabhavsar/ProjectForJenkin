package org.example;

import org.openqa.selenium.By;

public class ShoppingCartPage extends Utils {
    private By _Electronics = By.linkText("Electronics");
    private By _Cameraphoto = By.linkText("Camera & photo");
    private By _LeicaTMirrorlessDigitalCamera = By.linkText("Leica T Mirrorless Digital Camera");
    private By _addtocartbutton16 = By.id("add-to-cart-button-16");
    private By _Shoppingcart = By.linkText("Shopping cart");

    public void VerifyDetailsOfAddProductInShoppingCart() {
        //click the electronics
        clickOnElement(_Electronics);
        // click the camera & photo
        clickOnElement(_Cameraphoto);
        //select the product and click it
        clickOnElement(_LeicaTMirrorlessDigitalCamera);
        // click on add to cart button
        clickOnElement(_addtocartbutton16);
        //click on shopping cart  green button
        clickOnElement(_Shoppingcart);
    }
}
