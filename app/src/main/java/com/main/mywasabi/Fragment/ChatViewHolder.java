package com.main.mywasabi.Fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.mywasabi.R;

public class ChatViewHolder extends RecyclerView.ViewHolder {
    public TextView txtSenderId, txtSenderMessage;
    public LinearLayout msgBackground;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        msgBackground = itemView.findViewById(R.id.msgBackground);
        txtSenderId = itemView.findViewById(R.id.txtViewSenderId);
        txtSenderMessage = itemView.findViewById(R.id.txtSenderMessage);
    }
}
