package com.main.mywasabi.Fragment;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

    }
    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        LinearLayout linearLayout = holder.itemView.findViewById(R.id.msgBackground);

        switch (notes.get(position).getId()) {
            case 0:
                //notes.get(position).setBackgroundColor(Color.parseColor("#8BC34A"));
                //holder.msgBackground.setBackgroundColor(notes.get(position).getBackgroundColor());
                holder.txtSenderId.setTextColor(Color.parseColor("#000000"));
                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() + ": ");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
            break;
            case 1:
                holder.txtSenderId.setTextColor(Color.parseColor("#6633ff"));
                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() + ": ");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
                break;
            case 2:
                holder.txtSenderId.setTextColor(Color.parseColor("#660055"));
                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() + ": ");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
                break;
            default:
                break;
        }
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

    @Override
    public void onViewRecycled(@NonNull ChatViewHolder holder) {
        super.onViewRecycled(holder);
    }
}
