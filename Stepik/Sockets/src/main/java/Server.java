/**
 * Класс Server
 *
 * @author : Хильченко А.Н
 * @project : Sockets
 * @date : 20.12.2021
 * @comments :
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static void runServer(){
        try (ServerSocket serverSocket = new ServerSocket(8079)) {
            System.out.println("Cервер запущен, ожидаем соединения");
            Socket socket = serverSocket.accept();

            System.out.println("Клиент подключился к серверу");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
             String clientRequest = dataInputStream.readUTF();
             if (clientRequest.equals("end")) break;
             System.out.println("\tПолучена строка : "+clientRequest);
             dataOutputStream.writeUTF("\tОтвет от сервера : "+clientRequest);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
