package com.example.flymarco.simpleprojects.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flymarco.simpleprojects.MainActivity;
import com.example.flymarco.simpleprojects.R;
import com.example.flymarco.simpleprojects.data.ApiList;
import com.example.flymarco.simpleprojects.data.BaseApi;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

    private MainActivity mMainActivity;

    public ApiAdapter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ApiViewHolder(LayoutInflater.from(mMainActivity).inflate(R.layout
                .layout_main_activity_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        holder.setData(ApiList.getData().get(position));
    }

    @Override
    public int getItemCount() {
        return ApiList.getData().size();
    }

    class ApiViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ConstraintLayout mConstraintLayout;

        public ApiViewHolder(View itemView) {
            super(itemView);
            mConstraintLayout = itemView.findViewById(R.id.cl_item_root);
            mTextView = itemView.findViewById(R.id.tv_list_item);
        }

        void setData(final BaseApi baseApi) {
            mTextView.setText(baseApi.getName());
            mConstraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseApi.onClick(mMainActivity);
                }
            });
        }
    }
}
