package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import server.TaskService;

public class TaskServiceClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            TaskService taskService = (TaskService) registry.lookup("TaskService");

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("1. Ajouter une tâche");
                    System.out.println("2. Supprimer une tâche");
                    System.out.println("3. Afficher la liste des tâches");
                    System.out.println("4. Quitter");
                    System.out.print("Choisissez une option : ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consommer la nouvelle ligne

                    switch (choice) {
                        case 1:
                            System.out.print("Entrez la nouvelle tâche : ");
                            String newTask = scanner.nextLine();
                            taskService.addTask(newTask);
                            System.out.println("Tâche ajoutée avec succès.");
                            break;
                        case 2:
                            System.out.print("Entrez l'ID de la tâche à supprimer : ");
                            int taskId = scanner.nextInt();
                            scanner.nextLine(); // consommer la nouvelle ligne
                            taskService.removeTask(taskId);
                            System.out.println("Tâche supprimée avec succès.");
                            break;
                        case 3:
                            List<String> tasks = taskService.getAllTasks();
                            System.out.println("Liste des tâches :");
                            for (int i = 0; i < tasks.size(); i++) {
                                System.out.println(i + ". " + tasks.get(i));
                            }
                            break;
                        case 4:
                            System.out.println("Au revoir !");
                            System.exit(0);
                        default:
                            System.out.println("Option invalide. Veuillez réessayer.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur: " + e);
        }
    }
}
