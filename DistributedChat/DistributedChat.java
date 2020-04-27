
import java.net.*;
import java.io.*;
import java.util.*;

/**
To start the chat, Compile both DistributeChat.java & ChatNode.java then run "java Distributed Chat"
in as many terminals as wanted.
**/
public class DistributedChat
{
    private static final String TERMINATE = "Exit";
    static String name;
    static boolean finished = false;
    public static void main(String[] args)
    {
        try
        {
            InetAddress group = InetAddress.getByName("239.0.0.0");
            int port = 8080;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            MulticastSocket socket = new MulticastSocket(port);

            socket.setTimeToLive(0);

            socket.joinGroup(group);
            Thread t = new Thread(new ChatNode(socket,group,port));
            String joinMessage = name + ":" + " Has joined the chat";
            byte[] joinBuffer = joinMessage.getBytes();
            DatagramPacket joinDatagram = new
            DatagramPacket(joinBuffer,joinBuffer.length,group,port);
            socket.send(joinDatagram);

            // Spawn a thread for reading messages
            t.start();

            // Send to current chat
            System.out.println("You may began chatting with other people\n");
            while(true)
            {
                String message;
                message = sc.nextLine();
                if(message.equalsIgnoreCase(DistributedChat.TERMINATE))
                {
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
                message = name + ": " + message;
                byte[] buffer = message.getBytes();
                DatagramPacket datagram = new
                DatagramPacket(buffer,buffer.length,group,port);
                socket.send(datagram);
            }
        }
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
