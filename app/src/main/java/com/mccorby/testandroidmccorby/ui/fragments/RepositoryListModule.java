package com.mccorby.testandroidmccorby.ui.fragments;

import com.mccorby.testandroidmccorby.domain.interactors.RequestRepositoriesInteractor;
import com.mccorby.testandroidmccorby.ui.presenters.MainPresenter;
import com.mccorby.testandroidmccorby.ui.presenters.MainPresenterImpl;
import com.mccorby.testandroidmccorby.ui.views.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JAC on 22/05/2015.
 */
@Module
public class RepositoryListModule {
    private MainView mMainView;

    public RepositoryListModule(MainView mainView) {
        this.mMainView = mainView;
    }

    @Provides
    public MainView provideView() {
        return mMainView;
    }

    @Provides
    public MainPresenter provideMainPresenter(RequestRepositoriesInteractor interactor) {
        return new MainPresenterImpl(mMainView, interactor);
    }
}
