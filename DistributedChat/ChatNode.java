// Import Statements
import java.net.*;
import java.io.*;
import java.util.*;


class ChatNode implements Runnable
{
    // Object Variable Declaration
    private MulticastSocket socket;
    private InetAddress group;
    private int port;
    private static final int MAX_LEN = 1000;

    // Constructor
    ChatNode(MulticastSocket socket,InetAddress group,int port)
    {
        this.socket = socket;
        this.group = group;
        this.port = port;
    }

    // run method for chatNode
    @Override
    public void run()
    {
        while(!DistributedChat.finished)
        {
                byte[] buffer = new byte[ChatNode.MAX_LEN];
                DatagramPacket datagram = new
                DatagramPacket(buffer,buffer.length,group,port);
                String message;
            try
            {
                socket.receive(datagram);
                message = new
                String(buffer,0,datagram.getLength(),"UTF-8");
                if(!message.startsWith(DistributedChat.name))
                    System.out.println(message);
            }
            // Error catching
            catch(IOException e)
            {
                System.out.println("Socket closed!");
            }
        }
    }
}
