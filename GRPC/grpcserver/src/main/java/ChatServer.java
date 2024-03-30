
import com.example.grpc.ChatServiceGrpc.ChatServiceImplBase;
import com.example.grpc.ChatServiceProto.MessageList;
import com.example.grpc.ChatServiceProto.Message;
import com.example.grpc.ChatServiceProto.MessageRequest;
import com.example.grpc.ChatServiceProto.MessageResponse;
import com.example.grpc.ChatServiceProto.UserRequest;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService((BindableService) new ChatServiceImpl())
                .build();

        server.start();
        System.out.println("Server started at port 9090");
        server.awaitTermination();
    }

    static class ChatServiceImpl extends ChatServiceImplBase {
        @Override
        public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
            // Logique pour envoyer le message au destinataire
            // Ici, vous pouvez implémenter le code pour envoyer un message à l'utilisateur spécifié
            String status = "Message sent successfully";
            MessageResponse response = MessageResponse.newBuilder().setStatus(status).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getMessagesForUser(UserRequest request, StreamObserver<MessageList> responseObserver) {
            // Logique pour récupérer les messages pour un utilisateur donné
            // Ici, vous pouvez implémenter le code pour récupérer les messages destinés à un utilisateur spécifié
            MessageList messageList = MessageList.newBuilder()
                                    .addMessages(Message.newBuilder().setSender("Sender").setMessage("Hello").build())
                                    .build();
            responseObserver.onNext(messageList);
            responseObserver.onCompleted();
        }
    }
}


