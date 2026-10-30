package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientProcess extends Thread {

    Socket socket;
    int numeroClient;

    public ClientProcess(Socket socket, int numeroClient) {
        this.socket = socket;
        this.numeroClient = numeroClient;
    }

    public void run() {
        System.out.println("Le client n°" + numeroClient
                + " est connecté !");

        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            pw.println("Vous êtes le client n°" + numeroClient);

            socket.close();

        } catch (IOException e) {















            e.printStackTrace();
        }
    }
}