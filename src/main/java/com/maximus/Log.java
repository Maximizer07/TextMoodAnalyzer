package com.maximus;

import java.util.logging.Logger;

public class Log {
    static Logger logger = Logger.getLogger(Log.class.getName());
    private Log() {
        throw new IllegalStateException("Utility class");
    }

    public static void log(String message) {
        logger.info(message);
    }
}