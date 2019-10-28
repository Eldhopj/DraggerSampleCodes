package com.example.draggersamplecodes;

import dagger.Component;

/**
 * From component class the activity gets the objects they wanna use , For that component makes a dependency class
 * Component create and stores our object and provides them to us (Injector)
 * There are 2 ways component can provide us the dependency
 * 1. Injecting into our member variable
 * 2. using provision method (getter method)
 */

@Component //dagger will implements this interface and creates all necessary codes at compile time
public interface CarComponent {

    /**
     * provision method
     */
    Car getCar();

}
