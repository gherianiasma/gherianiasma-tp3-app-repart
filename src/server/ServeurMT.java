package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread {

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Le serveur attend...");

            int numeroClient = 0;

            while (true) {
                Socket socket = ss.accept();

                numeroClient++;

                System.out.println("Client n°" + numeroClient
                        + " connecté");
                System.out.println("Adresse IP : "
                        + socket.getRemoteSocketAddress());

                new ClientProcess(socket, numeroClient).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServeurMT().start();
    }
}