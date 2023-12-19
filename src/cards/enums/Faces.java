package cards.enums;

public enum Faces {
    ACE(12, 1, "Ace"),
    TWO(0, 2,"2"),
    THREE(1, 3, "3"),
    FOUR(2, 4,"4"),
    FIVE(3, 5,"5"),
    SIX(4, 6,"6"),
    SEVEN(5, 7,"7"),
    EIGHT(6, 8, "8"),
    NINE(7, 9,"9"),
    TEN(8, 10,"10"),
    JACK(9, 10,"Jack"),
    QUEEN(10, 10,"Queen"),
    KING(11, 10,"King");

    private int warVal;
    private int bjVal;
    private String format;

    Faces(int warVal, int bjVal, String format) {
        this.warVal = warVal;
        this.format = format;
        this.bjVal = bjVal;
    }


    public int getWarVal() {
        return warVal;
    }

    public int getBjVal() {
        return bjVal;
    }

    public String getFormat() {
        return format;
    }

    public static void setAceVal(int val) {
        ACE.bjVal = val;
    }
}
