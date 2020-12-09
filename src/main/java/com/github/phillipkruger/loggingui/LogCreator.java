package com.github.phillipkruger.loggingui;

import io.quarkus.scheduler.Scheduled;
import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

/**
 * Generating some log lines
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
@ApplicationScoped
public class LogCreator {
    private static final Logger LOG = Logger.getLogger(LogCreator.class);
    
    private final AtomicInteger infoCounter = new AtomicInteger();
    private final AtomicInteger warnCounter = new AtomicInteger();
    private final AtomicInteger errorCounter = new AtomicInteger();
    
    @Scheduled(every="10s")     
    void logInfo() {
        LOG.info("Information message (" + infoCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="11s")     
    void logWarn() {
        LOG.warn("Warning message (" + warnCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="12s")     
    void logError() {
        LOG.error("Error message (" + errorCounter.incrementAndGet() + ")");
    }
}
