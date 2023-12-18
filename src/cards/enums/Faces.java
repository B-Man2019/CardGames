package cards.enums;

public enum Faces {
    ACE(12, "A"),
    TWO(0, "2"),
    THREE(1, "3"),
    FOUR(2, "4"),
    FIVE(3, "5"),
    SIX(4, "6"),
    SEVEN(5, "7"),
    EIGHT(6, "8"),
    NINE(7, "9"),
    TEN(8, "10"),
    JACK(9, "J"),
    QUEEN(10, "Q"),
    KING(11, "K");

    private int value;
    private String format;

    private Faces(int value, String format) {
        this.value = value;
        this.format = format;
    }

    public int getValue() {
        return value;
    }

    public String getFormat() {
        return format;
    }
}
