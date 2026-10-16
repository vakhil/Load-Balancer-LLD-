package distributed.systems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startProcess();

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        }

        public void startProcess(){
            System.out.println("Give me the number of servers");
            Scanner sc = new Scanner(System.in);

            int noOfServers = sc.nextInt();
            HealthServer healthServer = new HealthServer("127.0.0.1",80);

            LoadBalancer loadBalancer = new LoadBalancer();
            for (int i = 0; i < noOfServers; i++) {
                Server server = new Server(i,healthServer);
                loadBalancer.addServer(server);
            }


            while(true){

                String commandWithArguments = sc.nextLine();

                String[] totalCommand = commandWithArguments.split(" ");
                String commandHead = totalCommand[0];
                String[] arguments = Arrays.copyOfRange(totalCommand,1,totalCommand.length);

                if(commandHead.equals("SEND")){
                    String message =  String.join(" ",arguments);
                    loadBalancer.sendMessage(message);
                } else if (commandHead.equals("DELS")) {
                    System.out.println("OK");
                }

            }

    }
}