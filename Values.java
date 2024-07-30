public enum Values {
    ACE(1, 11), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

    private final int value;
    private final int alternativeValue;

    Values(int value) {
        this.value = value;
        this.alternativeValue = value;
    }

    Values(int value, int alternativeValue) {
        this.value = value;
        this.alternativeValue = alternativeValue;
    }

    public int getValue() {
        return value;
    }

    public int getAlternativeValue() {
        return alternativeValue;
    }
}
