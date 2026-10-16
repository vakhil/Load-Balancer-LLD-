package distributed.systems;

public class HealthServer {
    String address;
    int port;
    public HealthServer(String address ,int port){
        this.address = address;
        this.port = port;
    }


    public void sendHeartBeat(String heartBeat){
        if(heartBeat.equals("OK")){
            return ;
        }
    }
}
