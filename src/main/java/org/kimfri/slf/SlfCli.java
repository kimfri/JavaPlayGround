package org.kimfri.slf;

import org.kimfri.trash.TrashLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlfCli {

    private Logger logger = LoggerFactory.getLogger(SlfCli.class);

    public static void main(String[] args) {
        SlfCli slfCli = new SlfCli();
        slfCli.doit();
    }

    private void doit() {

        logger.error("From Slf4j-error");
        if(logger.isDebugEnabled()) {
            logger.debug("From Slf4j-debug");
        }
        logger.warn("From Slf4j-warn");
        logger.info("From Slf4j-info");

        new TrashLog().aMethodThatWillWriteALogInfoEntry();
        new TrashLog().aMethodThatWillWriteALogErrorEntry();
    }
}
