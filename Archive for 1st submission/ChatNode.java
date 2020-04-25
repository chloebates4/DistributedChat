public class ChatNode implements MessageTypes
{
    // Private Class vars to store important node info
    //Limit max size to 100
    private int[] nodeArr = new int[100];
    private int nodeIp;
    private String name;

    ChatNode(int newNodeIp, String newName)
    {
        nodeIp = newNodeIp;
        name = newName;
        callReceiver();
    }

    // These get the node info and return each of them
    public int[] getNodeArr()
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
    public void setNodeArr( int[] newNodeArr )
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
