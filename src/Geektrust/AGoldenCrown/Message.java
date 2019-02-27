package Geektrust.AGoldenCrown;

public class Message {
    private String content;
    private Kingdom fromKingdom;
    private Kingdom toKingdom;

    public Message(String content, Kingdom fromKingdom, Kingdom toKingdom){
        this.content = content;
        this.fromKingdom = fromKingdom;
        this.toKingdom = toKingdom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Kingdom getFromKingdom() {
        return fromKingdom;
    }

    public void setFromKingdom(Kingdom fromKingdom) {
        this.fromKingdom = fromKingdom;
    }

    public Kingdom getToKingdom() {
        return toKingdom;
    }

    public void setToKingdom(Kingdom toKingdom) {
        this.toKingdom = toKingdom;
    }

}
