/**
 * Created by florin on 3/10/2017.
 */
import java.net.*;
import java.io.*;

public class Server {
    public static final int PORT = 8001;
    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try{
            serverSocket=new ServerSocket(PORT);
            System.out.println("Astept un client...");
            Socket socket= serverSocket.accept();
            String receivedMessage=" ";
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            while(!receivedMessage.equals("bye")){
                receivedMessage=in.readLine();
                out.println("[SERVER] Am primit mesajul: "+receivedMessage);
                out.flush();
                System.out.println("[SERVER] Am trimis mesajul: "+receivedMessage);

            }
            in.close();
            out.close();
            socket.close();
        }catch(IOException e){

            System.out.println("Eroare de la client");
        }
    }
    public static void main(String[] args) throws IOException {
        Server server=new Server();
    }
}
