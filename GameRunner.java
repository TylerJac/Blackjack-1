import java.util.Scanner;

public class GameRunner {


    public static void main(String[] args) {
        // play some music
//        String filepath = "CasinoJazz.wav";
//        PlayMusic music = new PlayMusic();
//        music.playMusic(filepath);


        Scanner sc = new Scanner(System.in);
        // create a deck
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("Enter your name ");
        String user = sc.nextLine();
        Player player = new Player(user, 100);
        Player dealer = new Player("Dealer", 0);

        // Initial bet
        System.out.println("Place your bet: ");
        int bet = sc.nextInt();
        sc.nextLine();
        if (!player.hasChips(bet)) {
            System.out.println("Not enough balance to place bet.");
            return;
        }

        player.subtractChips(bet);

        // deal initial cards to players
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.dealNextCard());
            dealer.addCard(deck.dealNextCard());
        }

        // display initial cards
        System.out.println("Player's cards:");
        player.displayCards();
        System.out.println("\nDealer's cards:");
        dealer.displayCards();

        // Player's turn
        while (true) {
            System.out.println("\nPlayer's turn:");
            int choice = player.chooseAction(sc);
            if (choice == 1) { // Hit
                player.addCard(deck.dealNextCard());
                player.displayCards();
                if (player.isBusted()) {
                    System.out.println("Player busted!");
                    break;
                }
            } else { // Stand
                break;
            }
        }

        // Dealer's turn
        while (!player.isBusted() && dealer.getCardTotal() < 17) {
            dealer.addCard(deck.dealNextCard());
        }

        // Display final cards
        System.out.println("\nFinal hands:");
        System.out.println("Player's cards:");
        player.displayCards();
        System.out.println("Player's total: " + player.getCardTotal());
        System.out.println("Dealer's cards:");
        dealer.displayCards();
        System.out.println("Dealer's total: " + dealer.getCardTotal());

        // Determine winner
        if (player.isBusted()) {
            System.out.println("Dealer wins!");
        } else if (dealer.isBusted() || player.getCardTotal() > dealer.getCardTotal()) {
            System.out.println("Player wins!");
            player.addChips(bet * 2);
        } else if (player.getCardTotal() == dealer.getCardTotal()) {
            System.out.println("It's a tie!");
            player.addChips(bet); // return the bet
        } else {
            System.out.println("Dealer wins!");
        }

        // Display player's balance
        System.out.println("Player's new balance: " + player.getBalance());

        sc.close();
    }


}
