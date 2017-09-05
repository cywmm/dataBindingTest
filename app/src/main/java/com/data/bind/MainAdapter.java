package com.data.bind;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.data.bind.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmingming on 2017/9/5.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context mContext;
    private List<User> userList = new ArrayList<>();


    public MainAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setUserList(List<User> list) {
        userList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext);
        ItemBinding binding = ItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTo(userList.get(position));

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemBinding binding = null;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(User user) {
            binding.setUser(user);
            binding.executePendingBindings();
        }
    }
}
