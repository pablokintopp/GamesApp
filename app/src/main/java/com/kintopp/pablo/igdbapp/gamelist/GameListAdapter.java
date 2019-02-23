package com.kintopp.pablo.igdbapp.gamelist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kintopp.pablo.igdbapp.data.model.Game;
import com.kintopp.pablo.igdbapp.databinding.GameListItemBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.CustomViewHolder> {

    private Activity activity;
    private List<Game> games;

    public GameListAdapter(Activity activity) {
        this.activity = activity;
        this.games = new ArrayList<>();
    }

    public void setItems(List<Game> games) {
        int startPosition = this.games.size();
        this.games.addAll(games);
        notifyItemRangeChanged(startPosition, games.size());
    }

    public Game getItem(int position) {
        return games.get(position);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        GameListItemBinding itemBinding = GameListItemBinding.inflate(layoutInflater, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(itemBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private GameListItemBinding binding;

        public CustomViewHolder(GameListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void bindTo(Game game){
            Glide.with(activity).load(game.getCover())
                    .into(binding.imageCover);

            binding.textGameName.setText(game.getName());
        }
    }
}
