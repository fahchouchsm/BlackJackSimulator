import cards.Shoe;
import game.Dealer;
import game.Player;

public class BlackjackGame {

    private final Shoe shoe = new Shoe(6);
    private final Player player = new Player(1000);
    private final Dealer dealer = new Dealer();

    public void playRound(double bet) {

        player.getHand().clear();
        dealer.getHand().clear();

        player.bet(bet);

        player.getHand().add(shoe.draw());
        dealer.getHand().add(shoe.draw());
        player.getHand().add(shoe.draw());
        dealer.getHand().add(shoe.draw());

        if (player.getHand().isBust()) {
            return;
        }

        dealer.play(shoe);

        int playerValue = player.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();

        if (dealer.getHand().isBust() || playerValue > dealerValue) {
            player.win(bet);
        } else if (playerValue == dealerValue) {
            player.push(bet);
        }
    }

    public double getBalance() {
        return player.getBalance();
    }
}
