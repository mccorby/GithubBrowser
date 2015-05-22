package com.mccorby.testandroidmccorby.ui.fragments;

import com.mccorby.testandroidmccorby.ActivityScope;
import com.mccorby.testandroidmccorby.ChallengeAppComponent;
import com.mccorby.testandroidmccorby.ui.adapters.RepoListAdapter;
import com.mccorby.testandroidmccorby.ui.presenters.MainPresenter;

import dagger.Component;

/**
 * Created by JAC on 22/05/2015.
 */
@ActivityScope
@Component (
        dependencies = ChallengeAppComponent.class,
        modules = RepositoryListModule.class
)
public interface RepositoryListComponent {
    void inject(RepositoryListFragment fragment);

    MainPresenter getMainPresenter();

    RepoListAdapter getAdapter();
}
