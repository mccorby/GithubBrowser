package com.mccorby.testandroidmccorby.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mccorby.testandroidmccorby.R;
import com.mccorby.testandroidmccorby.domain.entities.Repository;

import java.util.List;

/**
 * Created by JAC on 21/05/2015.
 */
public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> {

    private final Context mContext;
    private final OnLongClickListener mListener;
    private List<Repository> mRepositoryList;

    public interface OnLongClickListener {
        void repositorySelected(Repository repository);
    }

    public RepoListAdapter(Context context, List<Repository> repositories, OnLongClickListener listener) {
        this.mContext = context;
        mRepositoryList = repositories;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Repository repo = mRepositoryList.get(i);
        viewHolder.mNameTv.setText(repo.getName());
        viewHolder.mDescriptionTv.setText(repo.getDescription());
        viewHolder.mOwerTv.setText(repo.getOwner().getLogin());

        if (repo.isFork()) {
            viewHolder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.green_bg));
        } else {
            viewHolder.itemView.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return mRepositoryList != null ? mRepositoryList.size() : 0;
    }


    public void setRepositoryList(List<Repository> repositoryList) {
        this.mRepositoryList = repositoryList;
    }

    /**
     * This class implements the required ViewHolder pattern.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mNameTv;
        TextView mDescriptionTv;
        TextView mOwerTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTv = (TextView) itemView.findViewById(R.id.item_repo_list_name);
            mDescriptionTv = (TextView) itemView.findViewById(R.id.item_repo_list_description);
            mOwerTv = (TextView) itemView.findViewById(R.id.item_repo_list_owner);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mListener.repositorySelected(mRepositoryList.get(getPosition()));
                    return true;
                }
            });
        }
    }
}
