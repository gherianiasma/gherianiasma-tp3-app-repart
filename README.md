# TP3 – Serveur Multi-threads TCP

## 1. Objectif

Créer un serveur Java capable de gérer plusieurs clients en même temps grâce aux threads et aux sockets TCP.

## 2. Les classes

- **ServeurMT.java :** accepte les connexions et attribue un numéro à chaque client.
- **ClientProcess.java :** envoie le numéro du client.
- **Client.java :** se connecte au serveur et affiche le message reçu.

## 3. Exécution

1. Démarrer le serveur `ServeurMT`.
2. Exécuter plusieurs fois le client `Client`.
3. Le serveur affiche les informations de chaque client.
4. Chaque client reçoit son numéro de connexion.
## 4. ServeurMT:
![serveurmt.png](cap/serveurmt.png)

## 5. ClientProcess.java:
![clientprocess.png](cap/clientprocess.png)

## 6. Client:
![client.png](cap/client.png)


## 7.resultats:
![exp1.png](cap/exp1.png)

![exp2.png](cap/exp2.png)
