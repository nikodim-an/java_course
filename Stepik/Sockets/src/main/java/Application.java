import java.util.*;

public class Application {
    public static void main(String[] args) {
        // точка входа
        if (args.length==1) {
            if (args[0].equals("server")){
                // запустим сервер
                Server.runServer();
            } else {
                // запустим клиент
                Client.runClient();
            }
        } else {
            System.out.println("Это эхосервер - запустите один его экземпляр с параметром «server»,\n другой - с параметром «client»");
        }
    }
}
