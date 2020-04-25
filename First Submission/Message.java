public class Message implements MessageTypes
{

    public void generateMessage(String message, int messageType, ChatNode sender)
    {
        //TODO: Add Code
        String errorString;
        switch (messageType) {
            case 1:  messageType = 1;
                     // Ping to everyone that the (ChatNode Sender) wants to join
                     break;
            case 2:  messageType = 2;
                     // Ping to everyone that the the (ChatNode Sender) has joined
                     break;
            case 3:  messageType = 3;
                     // Update the nodeArray excluding the (ChatNode Sender)
                     break;
            case 4:  messageType = 4;
                     // Create a Note for the (ChatNode Sender)
                     break;
            default: errorString = "Invalid Message Type";
                     break;
        }
        System.out.println(messageType);
    }
}
