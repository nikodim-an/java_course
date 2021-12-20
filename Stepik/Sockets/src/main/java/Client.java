/**
 * Класс Client
 *
 * @author : Хильченко А.Н
 * @project : Sockets
 * @date : 20.12.2021
 * @comments :
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class Client {
    static Scanner scanner = new Scanner(System.in);

    public static void runClient(){
        try (Socket socket = new Socket("localhost",8079)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Введите сообщение:");
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);
                if (request.equals("end")) break;
                System.out.println("Получен ответ: "+dataInputStream.readUTF());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
