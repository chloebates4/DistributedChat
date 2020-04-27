// Import Statements
import java.net.*;
import java.io.*;
import java.util.*;

/**
To start the chat, Compile both DistributeChat.java & ChatNode.java then run "java Distributed Chat"
in as many terminals as wanted. A user will be prompted to enter a name each time.
**/
public class DistributedChat
{
    // Class variables
    private static final String TERMINATE = "Exit";
    static String name;
    static boolean finished = false;
    public static void main(String[] args)
    {
        try
        {
            // Create a new node with a user entered name
            InetAddress group = InetAddress.getByName("239.0.0.0");
            int port = 8080;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            MulticastSocket socket = new MulticastSocket(port);

            socket.setTimeToLive(0);

            socket.joinGroup(group);
            Thread t = new Thread(new ChatNode(socket,group,port));
            // Send message to all users in chat about a join
            String joinMessage = name + ":" + " Has joined the chat";
            byte[] joinBuffer = joinMessage.getBytes();
            DatagramPacket joinDatagram = new
            DatagramPacket(joinBuffer,joinBuffer.length,group,port);
            socket.send(joinDatagram);

            // Spawn a thread for reading messages
            t.start();

            // Sends to user who just entered
            System.out.println("You may began chatting with other people\n");
            while(true)
            {
                String message;
                message = sc.nextLine();
                // If the TERMINATE String is entered enter this if()
                if(message.equalsIgnoreCase(DistributedChat.TERMINATE))
                {
                    // Send message to the rest of the users that this user has left
                    String leaveMessage = name + ":" + " Has left the chat";
                    byte[] leaveBuffer = leaveMessage.getBytes();
                    DatagramPacket leaveDatagram = new
                    DatagramPacket(leaveBuffer,leaveBuffer.length,group,port);
                    socket.send(leaveDatagram);


                    finished = true;
                    socket.leaveGroup(group);
                    socket.close();
                    break;
                }
                // Otherwise send a normal message
                message = name + ": " + message;
                byte[] buffer = message.getBytes();
                DatagramPacket datagram = new
                DatagramPacket(buffer,buffer.length,group,port);
                socket.send(datagram);
            }
        }
        // Error catching for try
        catch(SocketException se)
        {
            System.out.println("Error creating socket");
            se.printStackTrace();
        }
        catch(IOException ie)
        {
            System.out.println("Error reading/writing from/to socket");
            ie.printStackTrace();
        }
    }
}
