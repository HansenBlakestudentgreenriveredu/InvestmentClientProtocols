import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 An investment account has a balance that can be changed by
 deposits and withdrawals.
 */
public class RobinhoodAccount {

    private double balance;
    private Lock balanceChangeLock;

    /**
     Constructs an investment account with a zero balance.
     */
    public RobinhoodAccount()
    {
        balance = 0;
        balanceChangeLock = new ReentrantLock();
    }

    /**
     Constructs an investment account with a given balance.
     @param initialBalance the initial balance
     */
    public RobinhoodAccount(double initialBalance)
    {
        balance = initialBalance;
    }

/**
 Deposits money into the investment account.
 @param amount the amount to deposit
 */
public void deposit(double amount)
{
    balanceChangeLock.lock();
    try
    {
        double newBalance = balance + amount;
        balance = newBalance;
    }
    finally
    {
        balanceChangeLock.unlock();
    }
}

    /**
     Withdraws money from the investment account.
     @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balanceChangeLock.lock();
        try
        {
            double newBalance = balance - amount;
            balance = newBalance;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }
    // multiplies amount in selected account
    public void grow(double amount)
    {
        balanceChangeLock.lock();
        try
        {
            double newBalance = balance * amount;
            balance = newBalance;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }
    // Divides amount in selected account
    public void devalue(double amount)
    {
        balanceChangeLock.lock();
        try
        {
            double newBalance = balance / amount;
            balance = newBalance;
        }
        finally
        {
            balanceChangeLock.unlock();
        }
    }

    /**
     Gets the current balance of the investment account.
     @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }

}
