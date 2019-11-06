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
 * Constructor injection check -> Car class
 * provision method injection -> CarComponent
 * Field injection -> BikeComponent
 * Method injection -> codes inside car package in car, remote
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
