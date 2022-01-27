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
        byte month = 1;
        short day = 1;
        int year = 1998;
        long livingDays = 123456789L;
        double goodDays = 365;
        float badDays = 1;
        boolean isAlive = true;
        char firstLetterOfName = 'V';
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("User information: Year of birth: {}, Day of birth: {}, Month of birth: {}, "
                        + "Living days: {}, Good days: {}, Bad days: {},"
                        + "First letter of name: {}, Is he alive: {}",
                year, day, month, livingDays, goodDays, badDays, firstLetterOfName, isAlive);
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
