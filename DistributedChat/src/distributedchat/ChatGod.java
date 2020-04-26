package distributedchat;

import java.util.*;
import java.io.*; 
import java.net.*; 

/**
 *
 * @author Chloe Bates, Sam Gilb, & Colton Spector
 */
public class ChatGod {

    public static void main (String[] args) throws IOException 
    {
        // terminate if no port # for server
        if (args.length < 1)
            System.exit(-1);
        

        String host = "localhost";


        // make node and call run() 
        try 
        {
            // retrieve from command line
            int port = Integer.parseInt(args[0]);
            int ip = Integer.parseInt(args[1]); 
            String name = args[2]; 

            // create ServerSocket, bind to port
            ServerSocket serverSocket = new ServerSocket(port);

            // causes socket to forcibly bind to a port that a different socket is using
            serverSocket.setReuseAddress(true);

            // listening for connection from client
            System.out.println("Server is listening to port: " + port);

            while (true)
            {

                Socket clientSocket = serverSocket.accept();

                ChatNode clientSockThread = new ChatNode(clientSocket, ip);

                // threads each client separately
                //new Thread(clientSockThread).start();

            }
        }
        catch (IOException e) 
        {
            System.out.println(e.toString());
        }

    }
}
