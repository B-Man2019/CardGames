package cards.enums;
public enum Suits {
    CLUBS("♣"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠");

    private String format;

    private Suits(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}


