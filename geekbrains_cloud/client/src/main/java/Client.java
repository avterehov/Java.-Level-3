import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main (String [] agrs){
        try (Socket socket = new Socket("localhost", 8089)){

            BufferedInputStream bis = new BufferedInputStream( new FileInputStream("client\\picture.jpg"));
            BufferedOutputStream bos = new BufferedOutputStream( (socket.getOutputStream()));
            byte[] bytes = new  byte [8192];
            int in;
            while ( (in = bis.read(bytes)) != -1) {
             bos.write(bytes,0,in);

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
