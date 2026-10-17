package distributed.systems;

import java.util.List;

public class LoadBalancer {

    public LoadBalancer(){
    }

    //TO-DO: LoadBalancer should get the details of the servers from HealthServer when it needs to forward the message
    public Server fetchServerDetails() {
        return HealthServer.getInstance().fetchNextServer();
    }

    public void sendMessage(String message){
        //Consult HealthServer and then get the next server
        Server server = fetchServerDetails();
        server.receiveMessage(message);

    }

}
