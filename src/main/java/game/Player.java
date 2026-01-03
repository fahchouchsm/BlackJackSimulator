package game;

public class Player {

    private double balance;
    private final Hand hand = new Hand();

    public Player(double balance) {
        this.balance = balance;
    }

    public void bet(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid bet. Stop gambling like an idiot.");
        }
        balance -= amount;
    }

    public void win(double amount) {
        balance += amount * 2;
    }

    public void push(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public Hand getHand() {
        return hand;
    }
}
