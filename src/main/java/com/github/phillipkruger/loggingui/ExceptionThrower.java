package com.github.phillipkruger.loggingui;

import javax.enterprise.context.RequestScoped;

/**
 * Throwing some exceptions
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
@RequestScoped
public class ExceptionThrower {

    public void throwException() {
        throw new IllegalStateException("This state is not legal !!");
    }
    
}
