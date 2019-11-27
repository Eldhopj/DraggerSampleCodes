package com.example.draggersamplecodes.car;

import android.util.Log;

import com.example.draggersamplecodes.parts.Engine;
import com.example.draggersamplecodes.parts.Wheels;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    @Inject
    Engine engine; // Filed injection
    //Disadvantage of field injection ? -> we cant make the variables private , it is meant for Framework types,
    private Wheels wheels;

    /**
     * Constructor injection
     * NOTE : In classes like activities we can't do constructor injection because android system initiates them, in those cases use field injection
     */
    //NOTE :if  a class have multiple constructor @Inject can be used only for one constructor
    @Inject // dagger will now know this is the way it has to instantiate the car object
    public Car(Wheels wheels) {
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "driving...");
    }

    /**
     * Method injection
     */
    // NOTE : its rarely used
    // Only good use case is that if you have to pass the injected object itself to the dependency
    @Inject
    public void enableRemote(Remote remote) { // remote object
        remote.setListener(this);
    }
}
