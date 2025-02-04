package Classwork1;
public abstract class Card {
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    public Card (String cust, String bk, String acc, int lim, double bal) {
        customer = cust;
        bank = bk;
        account = acc;
        limit = lim;
        balance = bal;
        
    }

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

    public String getCardType() {
        if (limit != 0) {
            return "Credit Card";
        }
        return "Debit Card";
    }
}
