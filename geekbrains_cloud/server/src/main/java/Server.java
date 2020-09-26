import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String[] agrs){


        try (ServerSocket sc = new ServerSocket(8089))
        {
            System.out.println("Server is listening");
            Socket socket = sc.accept();
            System.out.println("Client connected");
            InputStream in = socket.getInputStream();
            OutputStream out = new FileOutputStream("server\\picture.jpg");

            byte [] bytes = new byte[20*8192];
            int i;

        while ((i = in.read(bytes))>0){
            out.write(bytes,0,i);
        }


/*            try(Socket socket = sc.accept();
                Stream  ois = new ObjectInputStream(socket.getInputStream())
            ) {


                String  message = (String) ois.readObject();
                System.out.println(message);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject("From server: Message recieved");
            }*/

        } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

