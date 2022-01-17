package Lesson_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ExoServer {

    public static final int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server begin to work,  expected NEW connection");
            Socket clientSocket = serverSocket.accept();// accept = принимать
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            while (true){
                String message = input.readUTF();
                if (message.equals("/end")){
                    break;
                }
                output.writeUTF("Exo " + message);
            }

            System.out.println("Clint connect");

        } catch (IOException e) {
            System.err.println("Port connection ERROR " + PORT);
            e.printStackTrace();
        }
    }
}
