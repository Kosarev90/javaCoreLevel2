package Lesson_6.xHomeWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        sendMessage();
    }

    private static void sendMessage() {
        try {
            try {
                server = new ServerSocket(8778);
                System.out.println("Сервер работает");
                clientSocket = server.accept();
                try {
                    while (true) {
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                        String message = in.readLine();
                        System.out.println(message);
                        out.write("Сервер принял сообщение: " + message + "\n");
                        if(message.equals("end")){
                            break;
                        }
                    }
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("Подключение закрыто");

        }
    }
}