package Geektrust.AGoldenCrown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kingdom {
    private String name;
    private String emblem;
    private Map<Character, Integer> emblemCharactersCountMap;
    private List<Kingdom> allies;

    public Kingdom(String name, String emblem){
        this.name = name;
        this.emblem = emblem;
        allies = new ArrayList<>();
    }

    public List<Kingdom> getAlliances(){
        return allies;
    }

    public void setAlliance(Kingdom kingdom){
        allies.add(kingdom);
    }

    public boolean acceptMessageAndConfirmAlliance(Message message){
        if(message == null || message.getContent() == null)
            return false;

        Map<Character, Integer> emblemCharactersCountMap = loadEmblemCharactersCountMap();

        return isMessageMatchingWithEmblem(message, emblemCharactersCountMap);
    }

    private Map<Character, Integer> loadEmblemCharactersCountMap(){
        Map<Character, Integer> charactersMap = new HashMap<>();
        for (int i = 0; i < emblem.length(); i++) {
            Character ch = Character.toLowerCase(emblem.charAt(i));
            if (charactersMap.containsKey(ch))
                charactersMap.put(ch, charactersMap.get(ch) + 1);
            else
                charactersMap.put(ch, 1);
        }
        return charactersMap;
    }

    private boolean isMessageMatchingWithEmblem(Message message,Map<Character, Integer> charactersMap){
        String messageContent = message.getContent();
        for (int i = 0; i < messageContent.length(); i++) {
            Character ch = Character.toLowerCase(messageContent.charAt(i));

            if(charactersMap.containsKey(ch))
                charactersMap.put(ch, charactersMap.get(ch) -1);
        }

        boolean isCorrectMessageRecieved = true;
        for(Integer keyValue: charactersMap.values() ){
            if(keyValue > 0)
                isCorrectMessageRecieved = false;
        }

        return isCorrectMessageRecieved;

    }

}
