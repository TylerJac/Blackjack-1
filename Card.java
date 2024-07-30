public class Card {
    private final Suits suit;
    private final Values rank;

    public Card(Suits suit, Values rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public Suits getSuit() {
        return suit;
    }

    public int getValue() {
        return rank.getValue();
    }

}
