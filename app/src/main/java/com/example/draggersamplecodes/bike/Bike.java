package com.example.draggersamplecodes.bike;

import android.util.Log;

import com.example.draggersamplecodes.parts.Engine;
import com.example.draggersamplecodes.parts.Wheels;

import javax.inject.Inject;

public class Bike {
    private static final String TAG = "Bike";
    private Engine engine;
    private Wheels wheels;

    /**
     * Constructor injection
     */
    //NOTE :if  a class have multiple constructor @Inject can be used only for one constructor
    @Inject // dagger will now know this is the way it has to instantiate the car object
    public Bike(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "driving...");
    }
}
