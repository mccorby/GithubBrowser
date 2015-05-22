package com.mccorby.testandroidmccorby;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JAC on 22/05/2015.
 */
@Module
public class ChallengeAppModule {

    private ChallengeApp mChallengeApp;

    public ChallengeAppModule(ChallengeApp app) {
        this.mChallengeApp = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mChallengeApp;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mChallengeApp;
    }
}
