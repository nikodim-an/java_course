import java.util.logging.*;
import java.util.Date;
// готовое решение вопроса логирования с применением стандартного логгера

public class Decision {
    static void toConsole () {
        // вывод в консоль
        Logger logger = Logger.getLogger("Логгер");
        logger.info("Информационное сообщение …");
        logger.warning("Предупреждение …");
        logger.severe("Сообщение об ошибке");
    }

    static void toFile (){
        // вывод в консоль и в файл
        Logger logger = Logger.getLogger("Логгер в файл");
        try {
            FileHandler fileHandler = new FileHandler("/home/alex/DeskTop/log.log");
            fileHandler.setFormatter(new SimpleFormatter() {
                private static final String format = "[%1$tF %1$tT] [%2$-7s] → %3$s %n";
                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(format,
                            new Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    );
                }
            });
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            System.err.println("не получилось записывать лог в файл…");
        }
        logger.info("Информационное сообщение в файл…");
        logger.warning("Предупреждение в файл…");
        logger.severe("Сообщение об ошибке в файл");
        logger.config("ошибки в конфигурации");
        logger.fine("сообщение «все ок»");
        logger.finer("сообщение «все лучше чем ок»");
        logger.finest("сообщение типа «совсем все ок»");
    }

    public static void main(String[] args) {
        toConsole(); // выводится только в консоль
        toFile(); // лог переписывается, выводится в файл и в консоль
    }


}
