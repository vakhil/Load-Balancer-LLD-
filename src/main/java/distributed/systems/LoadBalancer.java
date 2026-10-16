package distributed.systems;

import java.util.List;

public class LoadBalancer {

    int totalNoOfServers = 0 ;
    Server currentServer = null;
    Server firstServer = null;
    Server previousServer = null;

    // Linked list of servers
    public void addServer(Server server){
        if(totalNoOfServers == 0){
            totalNoOfServers += 1 ;
            this.firstServer = server;
            this.currentServer = server;
        } else {
            this.totalNoOfServers += 1 ;
            this.currentServer.next = server;
            this.currentServer = server;
            this.currentServer.next = this.firstServer;
        }

    }




    public void sendMessage(String message){
        forwardMessage(message);
       // serverList.get(serVerName).receiveMessage(message);

    }

    public void forwardMessage(String message){
        if (this.previousServer == null ){
            this.previousServer = firstServer;
            this.previousServer.receiveMessage(message);
        }else{
            this.previousServer = this.previousServer.next;
            this.previousServer.receiveMessage(message);
        }

    }
}
