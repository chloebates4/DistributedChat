# Specifications

* At any given time, there is at least one active "participant" in the chat application. This is how e.g. the chat application starts out.
* Any node interested in chatting to the already existing participants will contact any one of the participants with a join request. Any participating node can handle a join request. We assume that a none-participating node "just knows" the IP address and post number of one other node that is a participant.
* Messages sent out by one participant are generally broadcast to all other, current participants and contain a logical name of the sender.
* A participant may leave the chat at any time.
* Communication connections may be held open or maybe closed after each interaction.
* To keep the system simple, we assume that new participants don't see old messages, i.e. there is no concept of "history".
* The is no assumption about a limit on the number of participants.