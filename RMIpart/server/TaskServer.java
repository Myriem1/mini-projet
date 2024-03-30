package server;

import java.rmi.Naming;

public class TaskServer {
    public static void main(String[] args) {
        try {
            TaskService taskService = new TaskServiceImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099); // Créer le registre RMI
            Naming.rebind("TaskService", taskService); // Publier le service
            System.out.println("Service de gestion des tâches démarré...");
        } catch (Exception e) {
            System.err.println("Erreur: " + e);
        }
    }
}


