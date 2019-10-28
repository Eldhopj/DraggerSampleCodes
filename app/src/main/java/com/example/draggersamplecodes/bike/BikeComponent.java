package com.example.draggersamplecodes.bike;

import com.example.draggersamplecodes.MainActivity;

import dagger.Component;

@Component
public interface BikeComponent {

    // Where all class the injection goes
    void inject(MainActivity mainActivity);
}
