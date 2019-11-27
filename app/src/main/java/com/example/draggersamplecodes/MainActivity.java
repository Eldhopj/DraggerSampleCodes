package com.example.draggersamplecodes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.draggersamplecodes.bike.Bike;
import com.example.draggersamplecodes.bike.BikeComponent;
import com.example.draggersamplecodes.bike.DaggerBikeComponent;
import com.example.draggersamplecodes.car.Car;
import com.example.draggersamplecodes.car.CarComponent;
import com.example.draggersamplecodes.car.DaggerCarComponent;

import javax.inject.Inject;

/**
 * Types of injections :
 *      1.Constructor injection check -> Car class
 *      2.provision method injection -> CarComponent
 *      3.Field injection -> BikeComponent
 *      4.Method injection -> codes inside car package in car, remote ( very rarely used)
 *
 *NOTE : Consider if there are Constructor, field, and method injections,
 *              The order in which it calls is Constructor injection -> Field injection -> Method injection
 *
 * MODULES & PROVIDER METHODS : For the dependency injections we need to annotate the constructor of that class with @Inject,
 *                              But what if the class which we need is from an external libs?
 *                              Implementation in Wheels class, in there the constructor in not annotated with @Inject
 *                              Check : Wheels class and wheels packages
 *
 *
 */

public class MainActivity extends AppCompatActivity {
    @Inject
    Bike bike;
    private Car car; //provision method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        provisionMethodInjection();
        fieldInjection();
    }

    private void provisionMethodInjection() {
        CarComponent component = DaggerCarComponent.create();

        car = component.getCar();
        car.drive();
    }

    //UseCase : the benefit of this is you can add multiple member variables
    //NOTE : field injection is meant for Framework types like activities and fragments
    private void fieldInjection() {
        BikeComponent component = DaggerBikeComponent.create();

        component.inject(this); //We are telling dager to take our activity and inject all member variables in the class (MainActivity) with the annotation @Inject
        bike.drive();
    }
}
