# kcjava
Membres du groupe : Flouriot Lehyan, Michel Damien, Duplessis Loann, Poitrineau Paul

L'architecture MVC est organis� en diff�rents packages pour les controlleurs, les vues et les mod�les.
Le reste des sources est situ� dans le package kcjava o� on retrouve deux classes contenants le main Client et le main Serveur (MainClient.java et MainServer.java)
Il n'y a aucune contraintes sur l'ordre de lancement des deux programmes.
Si un client envoie des pointages alors que les serveur n'est pas lanc�, elles seront toutes envoy�es au prochain pointage envoy� lorsque le serveur est lanc�.
Toutes les informations sont sauvegard�s � la fermetures des programmes.
