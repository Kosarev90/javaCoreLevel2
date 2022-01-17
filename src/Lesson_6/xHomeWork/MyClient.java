package Lesson_6.xHomeWork;

import java.io.*;
import java.net.Socket;

public class MyClient {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 8778);
                while (true) {
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    System.out.println(" Введите ваше сообщение: ");
                    String message = reader.readLine();
                    out.write(message + "\n");
                    out.flush();
                    String serverMessage = in.readLine();
                    System.out.println(serverMessage);

                }
            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}