package com.mccorby.testandroidmccorby.ui.views;

import android.app.Activity;

import com.mccorby.testandroidmccorby.domain.entities.Repository;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public interface MainView {

    Activity getActivity();

    void setRepositoryList(List<Repository> repositoryList);
}
