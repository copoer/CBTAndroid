package com.theworld.help.cbtandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static List<String> titles;
    public static final String ENTRY = "ca.theworld.help.CustomAdapter.ENTRY";

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.entry_title);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, EntryActivity.class);
                    intent.putExtra(ENTRY, getAdapterPosition());
                    ((Activity) context).startActivityForResult(intent, 1);
                }
            });
        }
    }

    public CustomAdapter(List<String> dataSet) { this.titles = dataSet;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        String title = titles.get(position);
        viewHolder.title.setText(title);
    }

    @Override
    public int getItemCount() { return titles.size(); }
}
