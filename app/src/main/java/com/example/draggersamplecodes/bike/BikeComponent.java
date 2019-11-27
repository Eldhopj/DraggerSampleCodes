package com.example.draggersamplecodes.bike;

import com.example.draggersamplecodes.MainActivity;
import com.example.draggersamplecodes.parts.wheels.WheelsModule;

import dagger.Component;

@Component(modules = WheelsModule.class)
public interface BikeComponent {

    /**
     * Field injection
     */
    // Where all class the injection goes
    void inject(MainActivity mainActivity);
}
