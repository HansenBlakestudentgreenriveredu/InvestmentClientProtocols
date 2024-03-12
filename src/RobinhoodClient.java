import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 This program tests the Robinhood server.
 This program DEPOSIT, WITHDRAW, GROW, and DEVALUES different account numbers
 */
public class RobinhoodClient
{
    public static void main(String[] args) throws IOException
    {
        final int SBAP_PORT = 8888;
        try (Socket s = new Socket("localhost", SBAP_PORT))
        {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);

            // Deposit into account 3
            String command = "DEPOSIT 3 500";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            String response = in.nextLine();
            System.out.println("Receiving: " + response);

            // Withdraw from acoount 3
            command = "WITHDRAW 3 400";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            // Multiplies account 2 value by 7
            command = "GROW 2 7";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            // Divides account 2 by 5
            command = "DEVALUE 2 5";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            // Quit ends program
            command = "QUIT";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
        }
    }
}