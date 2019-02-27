package Geektrust.AGoldenCrown;

public class UniverseController {

    public void sendMessage(String messageContent, Kingdom fromKingdom, Kingdom toKingdom){
        Message message = new Message(messageContent, fromKingdom, toKingdom);

        if(toKingdom.acceptMessageAndConfirmAlliance(message))
            fromKingdom.setAlliance(toKingdom);
    }

    public boolean isRuler(Kingdom kingdom){
        return kingdom.getAlliances().size() >= 3;
    }

}
