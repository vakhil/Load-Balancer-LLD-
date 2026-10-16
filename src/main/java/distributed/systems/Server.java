package distributed.systems;

public class Server {
    HealthServer healthServer = null;
    int id = 0;
    public Server next = null;

    public Server(int id, HealthServer healthServer){
        this.id = id;
        this.healthServer= healthServer;
    }

    // TO-DO : Every 10 seconds a health update is sent

    public void setId(int id) {
        this.id = id;
    }

    public void receiveMessage(String message){
        System.out.println("Processing is happening in server id " + String.valueOf(this.id) + " and the message is " + message);
       // return "Message has been received by server id " + message;
    }
}
