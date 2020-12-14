package com.github.phillipkruger.loggingui;

import io.quarkus.scheduler.Scheduled;
import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
    private final AtomicInteger debugCounter = new AtomicInteger();
    private final AtomicInteger traceCounter = new AtomicInteger();
    
    @Inject
    ExceptionThrower exceptionThrower;
    
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
    
    @Scheduled(every="13s")
    void debugError() {
        LOG.debug("Debug message (" + debugCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="14s")
    void traceError() {
        LOG.trace("Trace message (" + traceCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="30s")
    void logException(){
        try {
            exceptionThrower.throwException();
        }catch(Exception e){
            LOG.error("Some exception !", e);
        }
    }
    
}
