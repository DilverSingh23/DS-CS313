public class CreditCard {
    // Instance Variables
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    // Constructors
    public CreditCard (String cust, String bk, String acc, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acc;
        limit = lim;
        balance = initialBal;
    }

    // Constructor for no initial balance, calls the prior constructor with 0.0 filled in for initialBal
    public CreditCard (String cust, String bk, String acc, int lim) {
        this(cust, bk, acc, lim, 0.0);
    }

    // Get Methods 
    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    // Methods
    public boolean charge (double price) {
        if (price + balance > limit) {
            return false;
        }
        balance += price;
        return true;
    }

    public void makePayment (double amount) {
        balance -= amount;
    }

    public static void printSummary (CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Limit = " + card.limit);
        System.out.println("Balance = " + card.balance);
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