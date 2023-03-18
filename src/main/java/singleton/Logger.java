package singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger logger;

    public void log(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss ");
        System.out.println("[" + formatter.format(new Date()) + (num++) + "] " + msg);
    }

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
