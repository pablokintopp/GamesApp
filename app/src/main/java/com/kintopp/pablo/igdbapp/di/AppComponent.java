package com.kintopp.pablo.igdbapp.di;

import android.app.Application;

import com.kintopp.pablo.igdbapp.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApiModule.class,
        DbModule.class,
        ActivityModule.class,
        ViewModelModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


    void inject(App app);

}
