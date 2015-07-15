package com.thoughtworks.shadow.guice.bindings.linked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogService implements Log {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public void log() {
        logger.info("use slf4j log");
    }
}
