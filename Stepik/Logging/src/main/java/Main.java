import ru.khan.logging.*;

/**
 * пример работы со встроенным логером
 */

public class Main {
    // Этот лог будет выводиться в окно терминала (консоль)
    public static void main(String[] args) {
        ToConsole.main();
        ToFile.main();
        LoggerInterface.main();
    }
}
