package distributed.systems;

public class HealthServer {

    private static final HealthServer INSTANCE =
            new HealthServer("localhost", 8080);

    String address;
    int port;

    int totalNoOfServers = 0;
    Server currentServer = null;
    Server firstServer = null;
    Server previousServer = null;

    private HealthServer(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public static HealthServer getInstance() {
        return INSTANCE;
    }

    // Linked list of servers
    public void addServer(Server server){
        if(totalNoOfServers == 0){
            totalNoOfServers += 1 ;
            getInstance().firstServer = server;
            getInstance().currentServer = server;
            getInstance().currentServer.next = server;
        } else {
            getInstance().totalNoOfServers += 1 ;
            getInstance().currentServer.next = server;
            getInstance().currentServer = server;
            getInstance().currentServer.next = getInstance().firstServer;
        }
    }

    //LoadBalancer will consult HealthServer regarding which server the information
    // should be sent next and then forward it to the right node .
    public void forwardMessage(String message){
        if (this.previousServer == null ){
            this.previousServer = firstServer;
            this.previousServer.receiveMessage(message);
        }else{
            this.previousServer = this.previousServer.next;
            this.previousServer.receiveMessage(message);
        }
    }

    public Server fetchNextServer(){
        return getInstance().currentServer.next;
    }

    public void sendHearBeart(String heartBeat){
        String[] heartBeatArr = heartBeat.split(" ");
        System.out.println("Server "+heartBeatArr[0]+" is up and healthy");
    }

    // Keep your existing addServer(), forwardMessage(),
    // fetchNextServer(), and sendHeartBeat() methods here.
}