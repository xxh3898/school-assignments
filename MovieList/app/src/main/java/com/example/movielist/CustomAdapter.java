package com.example.movielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private String[] localTitles;
    private int[] localImages;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView tvTitle;
        private final TextView tvRating;
        private final TextView tvGenre;
        private final TextView tvYear;
        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvGenre = view.findViewById(R.id.tvGenre);
            tvRating = view.findViewById(R.id.tvRating);
            tvYear = view.findViewById(R.id.tvYear);
// Define click listener for the ViewHolder's View
        }
        public ImageView getImageView() { return imageView; }
        public TextView getTvTitle() { return tvTitle; }
        public TextView getTvRating() { return tvRating; }
        public TextView getTvGenre() { return tvGenre; }
        public TextView getTvYear() { return tvYear; }}


        public CustomAdapter(String[] titles, int[] images) {
                    localTitles = titles;
                    localImages = images;
                }
                public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movieitem, viewGroup, false);
                    return new ViewHolder(view);
                }
                public void onBindViewHolder(ViewHolder viewHolder, final int position) {
                    viewHolder.getImageView().setImageResource(localImages[position]);
                    viewHolder.getTvTitle().setText(localTitles[position]);
                    viewHolder.getTvRating().setText("9.0" + position);
                    viewHolder.getTvGenre().setText("판타지");
                    viewHolder.getTvYear().setText("2020" + position);
                }
                public int getItemCount() {
                    return localTitles.length;
                }}
