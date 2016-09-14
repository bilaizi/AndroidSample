
package com.example.bilaizi.androidsample;

import android.app.Application;
import android.location.LocationManager;

import com.example.bilaizi.androidsample.ui.HomeActivity;

import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;

public class DemoApplication extends Application {

    @Singleton
    @Component(modules = AndroidModule.class)
    public interface ApplicationComponent {
        void inject(DemoApplication application);

        void inject(HomeActivity homeActivity);

        void inject(DemoActivity demoActivity);
    }

    // for some reason.
    @Inject
    LocationManager locationManager;
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDemoApplication_ApplicationComponent
                .builder()
                .androidModule(new AndroidModule(this))
                .build();
        // As of now, LocationManager should be injected into this.
        component().inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }
}

