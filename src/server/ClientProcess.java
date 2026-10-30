package server;


import java.io.*;
import java.net.*;

public class ClientProcess extends Thread {

    Socket socket;
    int numeroClient;

    public ClientProcess(Socket socket, int numeroClient) {
        this.socket = socket;
        this.numeroClient = numeroClient;
    }

    public void run() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    socket.getOutputStream());
            out.flush();

            ObjectInputStream in = new ObjectInputStream(
                    socket.getInputStream());

            Operation op = (Operation) in.readObject();

            double a = op.getA();
            String operateur = op.getOperateur();
            double b = op.getB();

            double resultat = 0;
            String reponse;

            switch (operateur) {

                case "+":
                    resultat = a + b;
                    reponse = "Resultat : " + resultat;
                    break;

                case "-":
                    resultat = a - b;
                    reponse = "Resultat : " + resultat;
                    break;

                case "*":
                    resultat = a * b;
                    reponse = "Resultat : " + resultat;
                    break;

                case "/":
                    if (b == 0) {
                        reponse = "Erreur : division par zero";
                    } else {
                        resultat = a / b;
                        reponse = "Resultat : " + resultat;
                    }
                    break;

                default:
                    reponse = "Erreur : operateur invalide";
            }

            if (!reponse.startsWith("Erreur")) {
                ServeurMT.incrementerCompteur();
            }

            out.writeObject(reponse);
            out.flush();

            System.out.println("Client n°" + numeroClient
                    + " : " + reponse);

            in.close();
            out.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}