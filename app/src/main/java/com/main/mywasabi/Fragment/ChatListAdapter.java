package com.main.mywasabi.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.mywasabi.Chat.Message;
import com.main.mywasabi.Chat.MessageList;
import com.main.mywasabi.R;

import java.util.ArrayList;
import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatViewHolder> {
    private Context context;
    //private MessageList notes = MessageList.getInstance();
    private ArrayList<Message> notes = new ArrayList<>();

    public ChatListAdapter(Context context, ArrayList<Message> notes) {
        this.context = context;
        this.notes = notes;
    }
    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_message,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

    }

    // SETTER AND GETTERS
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Message> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Message> notes) {
        this.notes = notes;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

        holder.txtSenderId.setText(notes.get(position).getId());
        holder.txtSenderMessage.setText(notes.get(position).getMessage());
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
