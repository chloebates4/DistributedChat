public class ChatNode implements MessageTypes
{
    // Private Class vars to store important node info
    //Limit max size to 100
    private ChatNode[] nodeArr = new ChatNode [100];
    private int nodeIp;
    private String name;

    // These get the node info and return each of them
    public ChatNode[] getNodeArr()
    {
        return nodeArr;
    }

    public int getNodeIp ()
    {
        return nodeIp;
    }

    public String getName ()
    {
        return name;
    }

    // These functions sets the node info
    public void setNodeArr( ChatNode[] newNodeArr )
    {
        nodeArr = newNodeArr;
    }

    public void setNodeIp (int newNodeIp)
    {
        nodeIp = newNodeIp;
    }

    public void setName ( String newName )
    {
        name = newName;
    }
    // End of getters and setters

    //This calls the receiver and leaves it running
    public int callReceiver()
    {
        return 1;
    }

    // This makes a message based on the type the user enters
    public int makeMessage()
    {
        return 1;
    }

}
