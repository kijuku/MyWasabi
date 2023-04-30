package com.main.mywasabi.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.mywasabi.Bot.Bot;
import com.main.mywasabi.Chat.Message;
import com.main.mywasabi.R;

import java.util.ArrayList;

public class BotInfoAdapter extends RecyclerView.Adapter<BotInfoViewHolder> {
    private Context context;
    //private MessageList notes = MessageList.getInstance();
    private ArrayList<Bot> bots = new ArrayList<>();

    public BotInfoAdapter(Context context, ArrayList<Bot> bots) {
        this.context = context;
        this.bots = bots;
    }


    @NonNull
    @Override
    public BotInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BotInfoViewHolder(LayoutInflater.from(context).inflate(R.layout.bot_info,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BotInfoViewHolder holder, int position) {
        holder.txtBotName.setBackgroundColor(
                Color.parseColor(bots.get(position).getBotUser().getBackgroundColor() ));
        holder.txtBotDescription.setBackgroundColor(
                Color.parseColor(bots.get(position).getBotUser().getBackgroundColor() ));
        holder.txtBotStyle.setBackgroundColor(
                Color.parseColor(bots.get(position).getBotUser().getBackgroundColor() ));

        holder.txtBotName.setText("" + bots.get(position).getBotUser().getName() +"" );
        holder.txtBotDescription.setText((CharSequence) bots.get(position).getBotUser().getDescription());
        holder.txtBotStyle.setText((CharSequence) bots.get(position).getConfig().getName());

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Bot> getBots() {
        return bots;
    }

    public void setBots(ArrayList<Bot> bots) {
        this.bots = bots;
    }

    @Override
    public int getItemCount() {
        return bots.size();
    }
}
