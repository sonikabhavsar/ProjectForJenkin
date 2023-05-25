package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CommunityPollResultPage extends Utils{
    static String expectedCommunityPollVoteMessage = "Only registered users can vote.";

    public void verifyUserVoteSuccessfully(){

        String actualMessage = getTextFromElement(By.xpath("//div[@class=\"poll-vote-error\"]"));
        //  System.out.println("My message:" + actualMessage);
        //text message  is disappearing
        Assert.assertEquals(actualMessage, expectedCommunityPollVoteMessage, "Error message is disappearing.");
    }
}
