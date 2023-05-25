package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartResultPage extends Utils{
    static String expectedShoppingCartMessage = "Leica T Mirrorless Digital Camera";
    public void VerifyToSeeSameProductInShoppingCart(){
        //check the selected same product have in shopping cart
        String actualMessage = driver.findElement(By.className("product-name")).getText();
       // System.out.println("My Message:" + actualMessage);
        Assert.assertEquals(actualMessage, expectedShoppingCartMessage, "Product is not adding in shopping cart");
    }
}
