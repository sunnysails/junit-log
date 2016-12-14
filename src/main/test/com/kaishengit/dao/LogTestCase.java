package com.kaishengit.dao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by sunny on 2016/12/14.
 */
public class LogTestCase {
    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(LogTestCase.class);

        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
    }
}
