import org.testng.Assert;
import org.testng.annotations.Test;

import static org.fetch.CommonFunctions.identifyFakeBarInGroup;
import static org.fetch.CommonFunctions.identifyFakeGroup;

public class Tests extends BaseSetup {

    @Test
    public void findFakeGoldBarTest() {
        int[] group1 = {0, 1, 2};
        int[] group2 = {3, 4, 5};
        int[] group3 = {6, 7, 8};

        pageClass.getResetButton().click();
        pageClass.typeIntoGrids(group1, group2);
        pageClass.clickWeighButton();

        // find the group that contains the fake bar
        String weighResult;
        weighResult = pageClass.getLatestWeightResult();
        int[] fakeGroup = identifyFakeGroup(weighResult, group1, group2, group3);

        // find the fake bar amongst the group returned from identifyFakeGroup()
        pageClass.getResetButton().click();
        pageClass.typeIntoGrids(new int[]{fakeGroup[0]}, new int[]{fakeGroup[1]});
        pageClass.clickWeighButton();
        weighResult = pageClass.getLatestWeightResult();
        int fakeBar = identifyFakeBarInGroup(weighResult, fakeGroup);

        // click on the fake bar returned by identifyFakeBarInGroup
        pageClass.clickOnCoin(fakeBar);
        String alertMessage = commonFunctions.captureAlertMessage();
        Assert.assertEquals(alertMessage, "Yay! You find it!");
        System.out.println("Fake Gold Bar is: " + fakeBar);
        System.out.println("Alert message: " + alertMessage);
        System.out.println("Total # of weighings: " + pageClass.getWeighResultElement().size());
        System.out.println("List of all weighings: \n" + pageClass.getMainWeighResultElement().getText());
    }
}
