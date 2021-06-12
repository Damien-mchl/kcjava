# kcjava
Membres du groupe : Flouriot Lehyan, Michel Damien, Duplessis Loann, Poitrineau Paul

L'architecture MVC est organisé en différents packages pour les controlleurs, les vues et les modèles.
Le reste des sources est situé dans le package kcjava où on retrouve deux classes contenants le main Client et le main Serveur (MainClient.java et MainServer.java)
Il n'y a aucune contraintes sur l'ordre de lancement des deux programmes.
Si un client envoie des pointages alors que les serveur n'est pas lancé, elles seront toutes envoyées au prochain pointage envoyé lorsque le serveur est lancé.
Toutes les informations sont sauvegardés à la fermetures des programmes.
