//implementation of blackjack player
import java.util.ArrayList;
import java.util.Scanner;
public class Player {
    private final String name;
    private int balance;
    private final ArrayList<Card> cards;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void addChips(int amount) {
        balance += amount;
    }

    public boolean hasChips(int amount) {
        return balance >= amount;
    }

    public void subtractChips(int amount) {
        balance -= amount;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void displayCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public int chooseAction(Scanner sc) {
        System.out.println("Choose action: 1 for Hit, 2 for Stand");
        return sc.nextInt();
    }

    public boolean isBusted() {
        return getCardTotal() > 21;
    }

    public int getCardTotal() {
        int total = 0;
        for (Card card : cards) {
            total += card.getValue();
        }
        return total;
    }





}