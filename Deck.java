import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Deck implements DeckActions{

    private final ArrayList<Card> myCards;

    public Deck() {
        myCards = new ArrayList<>();
        for (Suits suit : Suits.values()) {
            for (Values value : Values.values()) {
                myCards.add(new Card(suit, value));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(myCards, new Random());
    }

    @Override
    public Card dealNextCard() {
        if (!myCards.isEmpty()) {
            return myCards.remove(myCards.size() - 1);
        }
        return null; // Deck is empty, return null.
    }

    @Override
    public void printDeck(int numToPrint) {
        int numCardsToPrint = Math.min(myCards.size(), numToPrint);
        for (int i = 0; i < numCardsToPrint; i++) {
            System.out.println(myCards.get(i));
        }
    }

}
