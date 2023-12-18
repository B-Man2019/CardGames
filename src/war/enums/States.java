package war.enums;

public enum States {
    WIN("You won!"),
    LOSE("You lost."),
    WAR("War!");

    private String format;

    private States(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
