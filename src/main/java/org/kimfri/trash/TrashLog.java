package org.kimfri.trash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrashLog {

    private final Logger logger = LoggerFactory.getLogger(TrashLog.class);

    public void aMethodThatWillWriteALogInfoEntry() {
        logger.info("info from TrashLog");
    }

    public void aMethodThatWillWriteALogErrorEntry() {
        logger.error("error from TrashLog");
    }
}
