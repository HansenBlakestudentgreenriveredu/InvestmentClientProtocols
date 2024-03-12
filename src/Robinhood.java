/**
 Robinhood consisting of multiple investment accounts.
 BankAccount = RobinhoodAccount
 */
public class Robinhood {
    private RobinhoodAccount[] accounts;

    /**
     Constructs an investment account with a given number of accounts.
     @param size the number of accounts
     */
    public Robinhood(int size) {
        accounts = new RobinhoodAccount[size];
        for (int i = 0; i < accounts.length; i++)
        {
            accounts[i] = new RobinhoodAccount();
        }
    }

    /**
     Deposits money into a Robinhood account.
     @param accountNumber the account number
     @param amount the amount to deposit
     */
    public void deposit(int accountNumber, double amount)
    {
        RobinhoodAccount account = accounts[accountNumber];
        account.deposit(amount);
    }

    /**
     Withdraws money from an investment account.
     @param accountNumber the account number
     @param amount the amount to withdraw
     */
    public void withdraw(int accountNumber, double amount)
    {
        RobinhoodAccount account = accounts[accountNumber];
        account.withdraw(amount);
    }

    /**
     Gets the balance of an investment account.
     @param accountNumber the account number
     @return the account balance
     */
    public double getBalance(int accountNumber)
    {
        RobinhoodAccount account = accounts[accountNumber];
        return account.getBalance();
    }
    /**
     Grows money in investment account.
     @param accountNumber the account number
     @param amount the amount to withdraw
     */
    public void grow(int accountNumber, double amount)
    {
        RobinhoodAccount account = accounts[accountNumber];
        account.grow(amount);
    }
    /**
     devalues money in investment account.
     @param accountNumber the account number
     @param amount the amount to withdraw
     */
    public void devalue(int accountNumber, double amount)
    {
        RobinhoodAccount account = accounts[accountNumber];
        account.devalue(amount);
    }

}
