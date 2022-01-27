package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is show how to use Logging.
 * In this example I am using slf4j, that is
 * Simple Logging Facade For Java.
 * This is library that can help to use different logging
 * instruments for teams.
 * For example, one team can use LogBack and another log4j throw slf4j.
 * SLF uses a design pattern - facade. The facade template simplifies
 * API loggers, so makes them understandable.
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
