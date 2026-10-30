package server;
import java.io.*;
import java.net.*;

public class ServeurMT {

    public static int compteur = 0;

    public static synchronized void incrementerCompteur() {
        compteur++;
        System.out.println("Nombre total d'operations : " + compteur);
    }

    public static void main(String[] args) {

        try {
            ServerSocket serveur = new ServerSocket(1234);

            System.out.println("Serveur en attente...");

            int numeroClient = 0;

            while (true) {

                Socket socket = serveur.accept();

                numeroClient++;

                System.out.println("Client n°" + numeroClient + " connecté.");

                new ClientProcess(socket, numeroClient).start();
            }
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}