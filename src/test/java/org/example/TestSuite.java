package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest{
    HomePage homePage= new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegisterResultPage registerResultPage = new RegisterResultPage();
    LoginPage loginPage = new LoginPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    EmailAFriendResultPage emailAFriendResultPage = new EmailAFriendResultPage();
    ShoppingCartPage shoppingCartPage =new ShoppingCartPage();
    ShoppingCartResultPage shoppingCartResultPage = new ShoppingCartResultPage();
    CommunityPollPage communityPollPage =new CommunityPollPage();
    CommunityPollResultPage communityPollResultPage =new CommunityPollResultPage();
    @Test
    public void VerifyUserShouldBeAbleToRegisterSuccessfully(){
        //click on register button
        homePage.clickOnRegisterButton();
        //enter register details
        registerPage.enterRegistrationDetails();
        //verify user register successfully
        registerResultPage.VerifyUserRegisterSuccessfully();
    }
    @Test
    public  void VerifyUserShouldBeAbleToReferProductToFriend(){
        //click on register button
        homePage.clickOnRegisterButton();
        //enter register details
        //registerPage.enterRegistrationDetails();
        registerPage.enterRegistrationDetails();
        //verify user register successfully
        // registerResultPage.VerifyUserRegisterSuccessfully();
        //click on login button
        loginPage.enterLoginDetails();
        //click on email friend button
        // emailToFriendPage.enterSendFriendMailDetails();
        emailAFriendPage.enterSendFriendMailDetails();
        //verify user send email a friend
        emailAFriendResultPage.VerifyUserSendEmailFriendsSuccessfully();
    }
    @Test
    public  void VerifyUserShouldBeAbleToAddProductToShoppingCart(){
        //To add product in shopping cart
        shoppingCartPage.VerifyDetailsOfAddProductInShoppingCart();
        //Verify in shopping cart added product is same product
        shoppingCartResultPage.VerifyToSeeSameProductInShoppingCart();
    }
    @Test
    public void VerifyUserShouldBeAbleToCommunityPollVoteSuccessfully(){
        //click on good button
        communityPollPage.enterCommunityPollDetails();
        //click on vote button
        communityPollResultPage.verifyUserVoteSuccessfully();
    }
}
