package Geektrust.AGoldenCrown;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class KingdomTest {
    private Kingdom kingdomOfShan;
    private Map<String, Kingdom> kingdomList;
    private Kingdom kingdom;

    @Before
    public void setUp() {
        kingdomList = new HashMap<>();
        kingdomOfShan = new Kingdom("SPACE", "Gorilla");
        kingdomList.put("SPACE",kingdomOfShan);
        kingdomList.put("LAND",new Kingdom("LAND", "Panda"));
        kingdomList.put("WATER",new Kingdom("WATER", "Octopus"));
        kingdomList.put("AIR",new Kingdom("AIR", "Owl"));
        kingdomList.put("ICE",new Kingdom("ICE", "Mammoth"));
        kingdomList.put("FIRE",new Kingdom("FIRE", "Dragon"));
    }

    @Test
    public void shouldAcceptCorrectMessage(){
        Kingdom toKingdom = kingdomList.get("AIR");
        Assert.assertTrue(toKingdom.acceptMessageAndConfirmAlliance(new Message("oaaawaala", kingdomOfShan, toKingdom)));
    }

    @Test
    public void shouldRejectIncorrectMessage(){
        Kingdom toKingdom = kingdomList.get("ICE");
        Assert.assertFalse(toKingdom.acceptMessageAndConfirmAlliance(new Message("wrong", kingdomOfShan, toKingdom)));
    }

}