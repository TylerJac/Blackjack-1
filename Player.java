import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String name;
    private int balance;
    private final ArrayList<Card> hand;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void addCard(Card card) {
        hand.add(card);
    }

    public void displayCards() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

        public int getCardTotal() {
        int total = 0;
        int numAces = 0;
    
            for (Card card : hand) {
        if (card.getValue() == Values.ACE.ordinal()) {
            numAces++;
        }
        total += card.getValue();
    }
    
    while (total > 21 && numAces > 0) {
        total -= 10; // Switching an Ace from 11 to 1
        numAces--;
    }
        return total;
    }

    public boolean isBusted() {
        return getCardTotal() > 21;
    }

    public void addChips(int amount) {
        balance += amount;
    }

    public void subtractChips(int amount) {
        balance -= amount;
    }

    public boolean hasChips(int amount) {
        return balance < amount;
    }

    public int getBalance() {
        return balance;
    }

    public int chooseAction(Scanner sc) {
        System.out.println("Choose action: 1 (Hit), 2 (Stand)");
        return sc.nextInt();
    }

    public void clearHand() {
        hand.clear();
    }
}
