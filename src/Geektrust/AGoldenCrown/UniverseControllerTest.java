package Geektrust.AGoldenCrown;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UniverseControllerTest {
    private Kingdom kingdomOfShan;
    private Map<String, Kingdom> kingdomList;
    private UniverseController universeController;

    @Before
    public void setUp() {
        kingdomList = new HashMap<>();
        universeController = new UniverseController();
        kingdomOfShan = new Kingdom("SPACE", "Gorilla");
        kingdomList.put("SPACE",kingdomOfShan);
        kingdomList.put("LAND",new Kingdom("LAND", "Panda"));
        kingdomList.put("WATER",new Kingdom("WATER", "Octopus"));
        kingdomList.put("AIR",new Kingdom("AIR", "Owl"));
        kingdomList.put("ICE",new Kingdom("ICE", "Mammoth"));
        kingdomList.put("FIRE",new Kingdom("FIRE", "Dragon"));
    }

    @Test
    public void shouldNotHaveAnyRuler(){
        Assert.assertFalse(universeController.isRuler(kingdomOfShan));
    }

    @Test
    public void shouldHaveShanAsRuler(){
        allowShanToSendCorrectMessagesToThreeKingdoms();
        Assert.assertTrue(universeController.isRuler(kingdomOfShan));
    }

    @Test
    public void shouldNotHaveShanAsRuler(){
        allowShanToSendTwoCorrectMessagesAndOneWrongOne();
        Assert.assertFalse(universeController.isRuler(kingdomOfShan));
    }

    @Test
    public void shouldHaveCorrectNumberOfAllies(){
        allowShanToSendCorrectMessagesToThreeKingdoms();
        Assert.assertEquals(3, kingdomOfShan.getAlliances().size());
    }

    private void allowShanToSendCorrectMessagesToThreeKingdoms(){
        universeController.sendMessage("a1d22n333a4444p", kingdomOfShan, kingdomList.get("LAND"));
        universeController.sendMessage("oaaawaala", kingdomOfShan, kingdomList.get("AIR"));
        universeController.sendMessage("zmzmzmzaztzozh",kingdomOfShan, kingdomList.get("ICE"));
    }

    private void allowShanToSendTwoCorrectMessagesAndOneWrongOne(){
        universeController.sendMessage("a1d22n333a4444p", kingdomOfShan, kingdomList.get("LAND"));
        universeController.sendMessage("oaaawaala", kingdomOfShan, kingdomList.get("AIR"));
        universeController.sendMessage("wrongmessage",kingdomOfShan, kingdomList.get("ICE"));
    }
}