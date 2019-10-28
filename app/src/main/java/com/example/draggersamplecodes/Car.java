package com.example.draggersamplecodes;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;

    /**
     * Constructor injection
     */
    //NOTE :if  a class have multiple constructor @Inject can be used only for one constructor
    @Inject // dagger will now know this is the way it has to instantiate the car object
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "driving...");
    }
}
