package com.main.mywasabi.Fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.mywasabi.R;

public class BotInfoViewHolder extends RecyclerView.ViewHolder{

    public TextView txtBotName, txtBotDescription, txtBotStyle;
    public LinearLayout msgBackground;

    public BotInfoViewHolder(@NonNull View itemView) {
        super(itemView);
        txtBotName = itemView.findViewById(R.id.txtBotName);
        txtBotDescription = itemView.findViewById(R.id.txtBotDescription);
        txtBotStyle = itemView.findViewById(R.id.txtBotStyle);
    }
}
