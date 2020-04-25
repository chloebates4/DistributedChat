# DistributedChat

**Problems:**
* We were trying to copy our Design Document from our Part 2 assignment for too long even though it wasn’t working with our system.  
* Working with Sockets is challenging, especially since most of the team members have not taken the prerequisite, Computer Networks.
Scheduling times to meet

**Design Deviations:**
* Merged MessageJoin, MessageJoined, MessageLeave, and MessageNote into one class, Message.java. The class Message uses switch statements to determine what the message type is. 
* Merged NodeInfo (interface for the message types) into ChatInfo.  
* Added the “ChatGod” that was supposed to create a server like socket that added ChatNodes into the conversation. 
