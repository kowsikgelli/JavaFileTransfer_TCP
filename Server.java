import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(int port_num){
        try {
            ServerSocket serverSocket = new ServerSocket(port_num);
            System.out.println("Server running..");

            Socket socket = serverSocket.accept();
            System.out.println("Client connection successful..");

            FileInputStream fileInputStream = new FileInputStream("D:\\inputfiles\\ATT00001.txt");
            byte[] b = new byte[4*1024];
            fileInputStream.read(b,0,b.length);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(b,0,b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server(8813);
    }
}
