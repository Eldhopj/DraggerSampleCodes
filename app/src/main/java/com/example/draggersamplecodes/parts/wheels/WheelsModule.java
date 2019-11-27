package com.example.draggersamplecodes.parts.wheels;

import com.example.draggersamplecodes.parts.Wheels;

import dagger.Module;
import dagger.Provides;

/**
 * Modules are class that contributes to the object graph.
 * <p>
 * NOTE: When ever these provides methods don't depends on any instance state of the module then we can make these methods static for better perf
 */
@Module
public class WheelsModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
