package com.main.mywasabi.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.main.mywasabi.Bot.Bot;
import com.main.mywasabi.Chat.Message;
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
      //  RecyclerView.LayoutParams linearLayout = holder.itemView.findViewById(R.id.msgBackground);

        switch (notes.get(position).getUser().getId()) {
            case 0:
                holder.txtSenderMessage.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));
                holder.txtSenderId.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));

                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() +
                        ": [" + notes.get(position).getUser().getDescription() + "]");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
            break;
            case 1:
                holder.txtSenderMessage.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));
                holder.txtSenderId.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));

                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() +
                        ":[" + notes.get(position).getUser().getDescription() + "]");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
            break;
            case 2:
                holder.txtSenderMessage.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));
                holder.txtSenderId.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));

                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() +
                        ": [" + notes.get(position).getUser().getDescription() + "]");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
            break;
            default:
                holder.txtSenderMessage.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));
                holder.txtSenderId.setBackgroundColor(
                        Color.parseColor(notes.get(position).getUser().getBackgroundColor() ));

                holder.txtSenderId.setText("" + notes.get(position).getUser().getName() +
                        ": [" + notes.get(position).getUser().getDescription() + "]");
                holder.txtSenderMessage.setText((CharSequence) notes.get(position).getMessage());
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
