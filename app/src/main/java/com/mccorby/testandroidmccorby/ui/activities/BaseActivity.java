package com.mccorby.testandroidmccorby.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mccorby.testandroidmccorby.ChallengeApp;
import com.mccorby.testandroidmccorby.ChallengeAppComponent;

/**
 * Created by JAC on 22/05/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((ChallengeAppComponent) ChallengeApp.get(this).component());
    }

    protected abstract void setupComponent(ChallengeAppComponent appComponent);
}
