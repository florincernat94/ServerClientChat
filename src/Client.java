/**
 * Created by florin on 3/10/2017.
 */
import java.net.*;
import java.io.*;
import java.lang.String.*;
import java.util.Scanner;

public class Client {
    public static int PORT=8001;
    public static String ADDRESS="127.0.0.1";
    Socket socket = null ;
    PrintWriter out = null ;
    BufferedReader in = null ;
    String receivedMessage="";
    public Client() throws IOException {
        try {
            socket=new Socket(ADDRESS,PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(!receivedMessage.contains("bye")){
            Scanner scanner=new Scanner(System.in);
            String myMessage=scanner.nextLine();
            out.println(myMessage);
            out.flush();
            try {
                receivedMessage=in.readLine();
                System.out.println(receivedMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
    public static void main(String[] args){
        try {
            Client client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
