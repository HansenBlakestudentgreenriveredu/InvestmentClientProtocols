import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 A server that executes the Simple Robinhood Access Protocol.
 */
public class RobinhoodServer
{
    public static void main(String[] args) throws IOException
    {
        // Max of 20 accounts
        final int ACCOUNTS_LENGTH = 20;
        Robinhood robinhood = new Robinhood(ACCOUNTS_LENGTH);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting to connect...");

        while (true)
        {
            Socket s = server.accept();
            System.out.println("Connected");
            RobinhoodService service = new RobinhoodService(s, robinhood);
            Thread t = new Thread(service);
            t.start();
        }
    }
}