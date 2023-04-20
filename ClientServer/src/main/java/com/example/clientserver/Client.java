package com.example.clientserver;

import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public Client(Socket socket){
        try {
            this.socket=socket;
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (IOException e){
            System.out.println("error creating client");
            e.printStackTrace();
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }
    public void sendMessageFromServer(String massageToServer){

                    try{
                        bufferedWriter.write(massageToServer);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error sending massage from clint");
                        closeEverything(socket, bufferedReader, bufferedWriter);

                    }
    }
    public void receivMessageFromServer(VBox vbox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String massageFromServer=bufferedReader.readLine();
                        HelloController.addLabel(massageFromServer,vbox);
                    }catch (IOException e){
                        e.printStackTrace();
                        System.out.println("Error receiving massage from clint");
                        closeEverything(socket,bufferedReader,bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }
    public void closeEverything(Socket socket,BufferedReader bufferedReader,BufferedWriter bufferedWriter){
        try{
            if (bufferedReader !=null){
                bufferedReader.close();
            }
            if(bufferedWriter !=null){
                bufferedWriter.close();
            }
            if(socket !=null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();

        }
    }

}
