package Classwork1;
public class DebitCard extends Card {
    // Constructor
    public DebitCard (String customer, String bank, String account, double balance) {
        super(customer, bank, account, 0, balance);
    }
    
    // Methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void makePurchase(double price) {
        withdraw(price);
    }

    public static void printSummary(DebitCard card) {
        System.out.println("Cardholder: " + card.getCustomer());
        System.out.println("Bank: " + card.getBank());
        System.out.println("Account: " + card.getAccount());
        System.out.println("Balance: " + card.getBalance());
    }

    // Main Program
    public static void main(String[] args) {
        DebitCard[] wallet = new DebitCard[3];
        wallet[0] = new DebitCard("John Doe", "New York Savings", "5391 0375 9387 5309", 25000);
        wallet[1] = new DebitCard("John Doe", "New York Federal", "3485 0399 3395 1954", 10000);
        wallet[2] = new DebitCard("John Doe", "New York Finances", "5391 0375 9387 5309", 5000);

        for (int i = 0; i < 20; i++) {
            wallet[0].makePurchase(100*i);
            wallet[1].makePurchase(50+i);
            wallet[2].makePurchase(10*i);
        }

        for (DebitCard card: wallet) {
            printSummary(card);
            if (card.balance < 10000) {
                card.balance += 2000;
                System.out.println("New Balance: " + card.balance);
            }
        }
    }
}
