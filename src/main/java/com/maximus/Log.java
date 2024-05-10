package com.maximus;

import java.util.logging.Logger;

public class Log {
    private Log() {
        throw new IllegalStateException("Utility class");
    }

    public static void log(String message) {
        Logger logger = Logger.getLogger(Log.class.getName());
        logger.info(message);
    }
}