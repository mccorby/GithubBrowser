package com.mccorby.testandroidmccorby;

import android.app.Application;
import android.content.Context;

/**
 * Created by JAC on 22/05/2015.
 */
public class ChallengeApp extends Application {

    private ChallengeAppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerChallengeAppComponent.builder()
                .challengeAppModule(new ChallengeAppModule(this))
                .build();
        component.inject(this);
    }

    public ChallengeAppComponent component() {
        return component;
    }

    public static ChallengeApp get(Context context) {
        return (ChallengeApp) context.getApplicationContext();
    }
}
