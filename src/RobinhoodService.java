import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 Executes Simple Robinhood Access Protocol commands
 from a socket.
 */
public class RobinhoodService implements Runnable {
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Robinhood robinhood;

    /**
     Constructs a service object that processes commands
     from a socket for an investment account.
     @param aSocket the socket
     @param aRobinhood the robinhood
     */
    public RobinhoodService(Socket aSocket, Robinhood aRobinhood)
    {
        s = aSocket;
        robinhood = aRobinhood;
    }

    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     Executes all commands until the QUIT command or the
     end of input.
     */
    public void doService() throws IOException
    {
        while (true)
        {
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }
        }
    }

    /**
     Executes a single command.
     @param command the command to execute
     */
    public void executeCommand(String command)
    {
        // Add to account number, amount
        int account = in.nextInt();
        if (command.equals("DEPOSIT"))
        {
            double amount = in.nextDouble();
            robinhood.deposit(account, amount);
        }
        // Subtract from account number, amount
        else if (command.equals("WITHDRAW"))
        {
            double amount = in.nextDouble();
            robinhood.withdraw(account, amount);
        }
        // Multiplies amount in a specific account number
        else if (command.equals("GROW"))
        {
            double amount = in.nextDouble();
            robinhood.grow(account, amount);
        }
        // Divides amount in a specific account number
        else if (command.equals("DEVALUE"))
        {
            double amount = in.nextDouble();
            robinhood.devalue(account, amount);
        }
        // Returns balance of account or  Invalid if not valid command
        else if (!command.equals("BALANCE"))
        {
            out.println("Invalid command");
            out.flush();
            return;
        }
        out.println(account + " " + robinhood.getBalance(account));
        out.flush();
    }
}
