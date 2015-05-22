package com.mccorby.testandroidmccorby.ui.fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mccorby.testandroidmccorby.R;
import com.mccorby.testandroidmccorby.datasource.CacheDatasourceImpl;
import com.mccorby.testandroidmccorby.datasource.FileDatasourceImpl;
import com.mccorby.testandroidmccorby.datasource.NetworkDatasourceImpl;
import com.mccorby.testandroidmccorby.domain.entities.Repository;
import com.mccorby.testandroidmccorby.domain.interactors.RequestRepositoriesInteractor;
import com.mccorby.testandroidmccorby.domain.interactors.RequestRepositoriesInteractorImpl;
import com.mccorby.testandroidmccorby.domain.repository.RepositoriesRepository;
import com.mccorby.testandroidmccorby.repository.RepositoriesRepositoryImpl;
import com.mccorby.testandroidmccorby.repository.datasource.CacheDatasource;
import com.mccorby.testandroidmccorby.repository.datasource.NetworkDatasource;
import com.mccorby.testandroidmccorby.ui.adapters.RepoListAdapter;
import com.mccorby.testandroidmccorby.ui.presenters.MainPresenter;
import com.mccorby.testandroidmccorby.ui.presenters.MainPresenterImpl;
import com.mccorby.testandroidmccorby.ui.views.MainView;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepositoryListFragment extends Fragment implements MainView, RepoListAdapter.OnLongClickListener {

    MainPresenter mPresenter;
    private RepoListAdapter mAdapter;

    public RepositoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_repository_list, container, false);


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_repos_list_rv);
        // Use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RepoListAdapter(getActivity(), null, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Activity is rolling... we can create the objects we need
        // NOTE: The following method would not be necessary if using Dependency Injection
        injectObjects();
    }

    private void injectObjects() {
        // Note: Due to problems to connect to github API, the network datasource is not used.
        // See comments in final_notes.txt
        NetworkDatasource networkDatasource = new NetworkDatasourceImpl(getString(R.string.api_url));
        NetworkDatasource fileDatasource = null;
        try {
            fileDatasource = new FileDatasourceImpl(getActivity().getAssets().open("static_result.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CacheDatasource cacheDatasource = new CacheDatasourceImpl(getActivity());
        RepositoriesRepository repository = new RepositoriesRepositoryImpl(networkDatasource, cacheDatasource);

        RequestRepositoriesInteractor interactor = new RequestRepositoriesInteractorImpl(repository);
        mPresenter = new MainPresenterImpl(this, interactor);
    }

    @Override
    public void setRepositoryList(List<Repository> repositoryList) {
        mAdapter.setRepositoryList(repositoryList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void repositorySelected(final Repository repository) {
        // Display dialog
        // Quite dirty way of doing it. It would require a custom adapter for the dialog but no more time!
        CharSequence options[] = new CharSequence[] {getString(R.string.owner_url), getString(R.string.repository_url)};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url = null;
                switch (which) {
                    case 0:
                        url = repository.getOwner().getHtmlUrl();
                        break;
                    case 1:
                        url = repository.getHtmlUrl();
                        break;
                }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        builder.show();
    }
}
