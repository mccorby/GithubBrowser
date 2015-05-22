package com.mccorby.testandroidmccorby.ui.presenters;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.domain.interactors.RequestRepositoriesInteractor;
import com.mccorby.testandroidmccorby.ui.loaders.RepositoriesLoader;
import com.mccorby.testandroidmccorby.ui.views.MainView;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public class MainPresenterImpl implements MainPresenter, LoaderManager.LoaderCallbacks<List<Repository>> {

    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private static final int REPOSITORIES_LOADER = 0;

    private MainView mView;
    private RequestRepositoriesInteractor mInteractor;

    public MainPresenterImpl(MainView view, RequestRepositoriesInteractor interactor) {
        this.mView = view;
        this.mInteractor = interactor;
        init();
    }

    private void init() {
        mView.getActivity().getLoaderManager().initLoader(REPOSITORIES_LOADER, null, this);
    }


    @Override
    public void onResume() {

    }

    @Override
    public Loader<List<Repository>> onCreateLoader(int id, Bundle args) {
        return new RepositoriesLoader(mView.getActivity(), mInteractor);
    }

    @Override
    public void onLoadFinished(Loader<List<Repository>> loader, List<Repository> data) {
        for (Repository rep : data) {
            Log.d(TAG, "Repository name " + rep.getName());
        }
        mView.setRepositoryList(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Repository>> loader) {

    }
}
