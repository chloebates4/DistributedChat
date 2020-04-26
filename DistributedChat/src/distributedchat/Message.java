package distributedchat;

/**
 *
 * @author Chloe Bates, Sam Gilb, & Colton Spector
 */
public class Message implements MessageTypes
{

    public void generateMessage(String message, int messageType, ChatNode sender)
    {
        String errorString;
        switch (messageType) {
            // Join
            case 1:  messageType = 1;
                     // Ping to know IP Node that the (ChatNode sender) wants to joined
                     break;
            // Joined
            case 2:  messageType = 2;
                     // Ping to everyone that the the (ChatNode sender) has joined
                     break;
            // Leave
            case 3:  messageType = 3;
                     // Update the nodeArray excluding the (ChatNode sender)
                     break;
            // Note
            case 4:  messageType = 4;
                     // Send a Note for the (ChatNode sender)
                     // Calls (listenForMessages)
                     break;
            default: errorString = "Invalid Message Type";
                     break;
        }
        System.out.println(messageType);
    }

    private void join(ChatNode sender)
    {
      // Ping the ChatNode you know (Known by their IP Address)
      // Sends joining node the Node Array
    }

    private void joined(ChatNode sender)
    {
      // Update the Node Array and let all Nodes know Node has JOINED
      // Send JOINED (ChatNode sender) message to all nodes in Node Array
      System.out.println("%s has entered the chat" + sender.getName());
    }

    private void leave(ChatNode sender)
    {
      // (ChatNode sender) updates the Node Array excluding itself
      System.out.println("%s has left the chat" + sender.getName());
    }

    private void note(ChatNode sender, String message)
    {
      // Send the Reciever the message
      System.out.println("%s: " + message);
    }
}
