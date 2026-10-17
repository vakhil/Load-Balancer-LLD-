package distributed.systems;

import java.util.Random;

public class Server {
    int id = 0;
    public Server next = null;

    public static void main(String[] args)  {
        Server server = new Server(new Random().nextInt());
        server.start();
    }

    //Start sending heartbeats to the HealthServer
    // TO-DO : Every 10 seconds a health update is sent
    public void start()  {
        HealthServer.getInstance().addServer(this);
        while(true){
            try {
                HealthServer.getInstance().sendHearBeart(String.valueOf(this.id) + " is sending the heartbeart");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Server(int id){
        this.id = id;
    }



    public void receiveMessage(String message){
        System.out.println("Processing is happening in server id " + String.valueOf(this.id) + " and the message is " + message);
    }
}
