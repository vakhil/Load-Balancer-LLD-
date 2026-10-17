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
            Scanner sc = new Scanner(System.in);
            HealthServer healthServer = HealthServer.getInstance();
            LoadBalancer loadBalancer = new LoadBalancer();

            while(true){
                System.out.print("Your order is my command");
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