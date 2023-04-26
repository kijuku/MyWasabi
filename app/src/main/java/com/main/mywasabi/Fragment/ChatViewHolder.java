package com.main.mywasabi.Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.mywasabi.R;

public class ChatViewHolder extends RecyclerView.ViewHolder {
    TextView txtSenderId, txtSenderMessage;
    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSenderId = itemView.findViewById(R.id.txtViewSenderId);
        txtSenderMessage = itemView.findViewById(R.id.txtSenderMessage);
    }
}
