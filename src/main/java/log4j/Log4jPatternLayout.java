package log4j;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Log4jPatternLayout {

static{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
    
    final static Logger log = Logger.getLogger(Log4jPatternLayout.class);
    
    public static void main(String[] args) {
        
        log.trace("This is Trace Message.");
        log.debug("This is Debug Message.");
        log.info("This is Info Message.");
        log.warn("This is Warn Message.");
        log.error("This is Error Message.");
        log.fatal("This is Fatal Message.");
    }
}
