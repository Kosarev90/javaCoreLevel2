package Lesson_6.Home_Work2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static final int DEFAULT_PORT = 8189;

    public static void main(String[] args) throws Exception {
        int port = DEFAULT_PORT;
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }
        new Server().start(port);
    }

    private void start(int port) throws Exception {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        Thread inputThread = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен!");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился!");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            inputThread = runInputThraed(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }

    private void runOutputLoop(DataOutputStream out) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            out.writeUTF(message);
            if (message.equals("/exit")) {
                break;
            }
        }
    }

    private Thread runInputThraed(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("From client: " + message);
                    if (message.equals("/exit")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Подключение закрыто");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }

}
