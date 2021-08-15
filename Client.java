import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public Client(String ip,int port_num){
        try {
            Socket socket = new Socket(ip,port_num);
            System.out.println("Connection sucessful..");
            InputStream inputStream = socket.getInputStream();
            byte[] b =new byte[4*1024];
            inputStream.read(b,0,b.length);

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\outputfiles\\abc.txt");
            fileOutputStream.write(b,0,b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client client = new Client("localhost",8813);
    }
}
