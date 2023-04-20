package com.example.networking;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket){
        try {
            this.serverSocket = serverSocket;
            this.socket=serverSocket.accept();
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (IOException e){
            System.out.println("error creating server");
            e.printStackTrace();
        }
    }
    public  void sendMessageToClient(String massage){
        try {
            bufferedWriter.write(massage);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("error sending message to the Client");
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }
    public void receiveMessageFromClient(VBox vbox){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try{
                        String massage=bufferedReader.readLine();
                        HelloController.addLabel(massage,vbox);
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