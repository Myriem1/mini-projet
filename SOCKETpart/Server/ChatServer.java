package Server;
import java.io.*;
import java.net.*;

public class ChatServer {
    private static final int PORT = 9093;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running...");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Créer un thread pour gérer les communications avec le client
                ClientHandler clientHandler = new ClientHandler(clientSocket, consoleReader);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                    System.out.println("Server socket closed.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private BufferedReader consoleReader;

        public ClientHandler(Socket socket, BufferedReader consoleReader) {
            this.clientSocket = socket;
            this.consoleReader = consoleReader;
        }

       public void run() {
    try {
        // Initialiser les flux de communication avec le client
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client: " + inputLine);
            
            // Ajouter une condition pour terminer la conversation côté serveur
            if (inputLine.equalsIgnoreCase("quit") || inputLine.equalsIgnoreCase("exit")) {
                // Fermer la connexion socket avant de quitter
                out.println(inputLine); // Envoyer la commande au client
                clientSocket.close(); // Fermer la connexion client
                break;
            }
            
            String response;
           
                System.out.println("Entrez la réponse à envoyer au client:");
                response = consoleReader.readLine();
            
            
            out.println("Server: " + response);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    }
}