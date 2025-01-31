public class CreditCard extends Card {
    // Constructors
    public CreditCard (String customer, String bank, String account, int limit, double balance) {
        super(customer, bank, account, limit, balance);
    }

    // Constructor for no initial balance, calls the prior constructor with 0.0 filled in for initialBal
    public CreditCard (String cust, String bk, String acc, int lim) {
        this(cust, bk, acc, lim, 0.0);
    }

    // Methods
    public boolean charge (double price) {
        if (price + balance > getLimit()) {
            return false;
        }
        balance += price;
        return true;
    }

    public void makePayment (double amount) {
        balance -= amount;
    }

    public static void printSummary (CreditCard card) {
        System.out.println("Customer = " + card.getCustomer());
        System.out.println("Bank = " + card.getBank());
        System.out.println("Account = " + card.getAccount());
        System.out.println("Limit = " + card.getLimit());
        System.out.println("Balance = " + card.getBalance());
    }
    public static void main (String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet [0] = new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
        wallet [1] = new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3000);
        wallet [2] = new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);

        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3*val);
            wallet[1].charge(2*val);
            wallet[2].charge(val);
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card);
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New Balance = " + card.getBalance());
            }
        }
    }
}