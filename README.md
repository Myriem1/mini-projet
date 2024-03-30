Ce projet compare et met en contraste trois technologies de communication distribuée populaires en Java : RMI, gRPC et les sockets. Chaque technologie est utilisée pour implémenter un service distinct, illustrant ses forces et ses faiblesses dans des contextes spécifiques.

Structure du projet: 

Le code est organisé en trois répertoires distincts :

RMIpart: Implémente un service de gestion de tâches utilisant Java RMI.
GRPC: Contient le code pour un service de messagerie utilisant gRPC.
SOCKETpart: Propose un service de chat simple utilisant des sockets Java.
Chaque répertoire contient le code source, les instructions de déploiement et les informations de test pour le service correspondant.
Fonctionnalités et tests
Gestionnaire de tâches avec Java RMI:
Déploiement:
- Clonez le dépôt GitHub sur votre machine.
. Exécutez TaskServer pour démarrer le serveur RMI.
. Exécutez TaskServiceClient pour lancer le client.
Test:
. Le client offre un menu pour ajouter, supprimer et afficher des tâches.
Service de messagerie avec gRPC:
Déploiement:
. Clonez les dépôts grpcserver et grpcclient.
. Exécutez ChatServer dans grpcserver pour démarrer le serveur.
. Exécutez ChatClient dans grpcclient pour lancer le client.
Test:
. Le client permet d'envoyer des messages au serveur.
Service de chat avec sockets:
Déploiement:
. Clonez le dépôt socket.
. Exécutez ChatServer pour démarrer le serveur.
. Exécutez ChatClient pour lancer le client.
Test:
. Le client permet d'envoyer et de recevoir des messages texte.
. Pour quitter l'application, vous pouvez entrer "exit".
. Le serveur affiche les messages reçus et peut envoyer des réponses.

