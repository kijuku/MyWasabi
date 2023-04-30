package com.main.mywasabi.Fragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.main.mywasabi.Chat.Chat;
import com.main.mywasabi.Chat.Message;
import com.main.mywasabi.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {
    private RecyclerView recyclerView;
    private Chat chatStorage;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton imgBtnLiveSend;
    private ImageButton imgBtnSendEmoji;
    private TextView msgLiveChat;
    private ChatListAdapter chatAdapter;
    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        chatStorage = Chat.getInstance();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = view.findViewById(R.id.fragmentArea);
        imgBtnLiveSend = view.findViewById(R.id.imgBtnLiveSend);
        imgBtnSendEmoji = view.findViewById(R.id.imgBtnSendEmoji);

        msgLiveChat = view.findViewById(R.id.msgChatLive);

        chatAdapter = new ChatListAdapter(view.getContext(),chatStorage.getLive());

        recyclerView = view.findViewById(R.id.LiveChatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext().getApplicationContext() ));
        recyclerView.setAdapter(new ChatListAdapter(view.getContext(), chatStorage.getLive()));
        recyclerView.scrollToPosition(chatStorage.getLive().size()-1);
        imgBtnLiveSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(msgLiveChat.getText());
                Message message = new Message(chatStorage.getUsers().get(0).getName(), str);
                chatStorage.getLive().add(message);
                System.out.println(message);

                chatAdapter.setNotes(chatStorage.getLive());

                chatAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(chatAdapter);
                if (str.contains("?")) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    Runnable end = () -> {
                        addBotComment(view);
                    };
                    handler.postDelayed(end, 1400);

                }
                if (str.contains("!")){
                    Handler handler = new Handler(Looper.getMainLooper());
                    Runnable end = () -> {
                        addBotCommentSup(view);
                    };
                    handler.postDelayed(end, 1400);

                    Runnable end2 = () -> {
                        addBotComment(view);
                    };
                    handler.postDelayed(end2, 1400);
                } else {
                    Handler handler = new Handler(Looper.getMainLooper());
                    Runnable end = () -> {
                        addBotAnswer(view);
                    };
                    handler.postDelayed(end, 1400);

                    Runnable end2 = () -> {
                        addBotComment(view);
                    };
                    handler.postDelayed(end2, 1400);

                }
                msgLiveChat.setText(" ");
                msgLiveChat.setFocusable(true);
                recyclerView.scrollToPosition(chatStorage.getLive().size()-1);

            }

        });

      imgBtnSendEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(chatStorage.getUsers().get(0).getFavoriteComment());
                Message message = new Message(chatStorage.getUsers().get(0).getName(), str);
                chatStorage.getLive().add(message);
                System.out.println(message);

                chatAdapter.setNotes(chatStorage.getLive());

                chatAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(chatAdapter);
                if (str.contains("?")) {
                    addBotComment(view);
                    addBotComment(view);
                } else {
                    addBotAnswer(view);
                    addBotComment(view);
                }

                msgLiveChat.setText(" ");
                msgLiveChat.setFocusable(true);
                recyclerView.scrollToPosition(chatStorage.getLive().size()-1);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager=LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    //you have reached to the bottom of your recycler view
                    System.out.println("+totalItemCount: " + totalItemCount);
                    //recyclerView.scrollToPosition(totalItemCount-1);
                    recyclerView.smoothScrollToPosition(totalItemCount-1);
                }
                System.out.println("totalItemCount: " + totalItemCount);

            }

    /*        @Override
           public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }*/
        });


        return view;
    }

    public void addBotComment(View view){
        Random rnd = new Random();
        chatStorage = Chat.getInstance();

        int low = 0;
        int botCount = chatStorage.getBots().size();
        int botId = rnd.nextInt(botCount-low) + low;



        String str = String.valueOf(chatStorage.getBots().get(botId).randomComment());
        //Message message = new Message(chatStorage.getBots().get(botId).getName(), str);
        int id = chatStorage.getLive().size();

        Message message = new Message(id,  str,
                chatStorage.getBots().get(botId).getBotUser(),
                chatStorage.getBots().get(botId).getBotUser().getBackgroundColor());

        chatStorage.getLive().add(message);
        System.out.println(message);

        chatAdapter.setNotes(chatStorage.getLive());

        chatAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(chatAdapter);


    }


    public void addBotCommentSup(View view){
        Random rnd = new Random();
        chatStorage = Chat.getInstance();

        int low = 0;
        int botCount = chatStorage.getBots().size();
        int botId = rnd.nextInt(botCount-low) + low;
        int id = chatStorage.getLive().size();

        String str = String.valueOf("OLETKO VIHAINEN?");
        Message message = new Message(id,  str,
                chatStorage.getBots().get(botId).getBotUser(),
                chatStorage.getBots().get(botId).getBotUser().getBackgroundColor());

        chatStorage.getLive().add(message);
        System.out.println(message);

        chatAdapter.setNotes(chatStorage.getLive());

        chatAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(chatAdapter);


    }
    public void addBotAnswer(View view){
        Random rnd = new Random();
        chatStorage = Chat.getInstance();

        int low = 0;
        int botCount = chatStorage.getBots().size();
        int botId = rnd.nextInt(botCount-low) + low;

        String str = String.valueOf(chatStorage.getBots().get(botId).randomAnswer());
//        Message message = new Message(chatStorage.getBots().get(botId).getName(), str);
        int id = chatStorage.getLive().size();

        Message message = new Message(id,  str,
                chatStorage.getBots().get(botId).getBotUser(),
                chatStorage.getBots().get(botId).getBotUser().getBackgroundColor());

        chatStorage.getLive().add(message);
        System.out.println(message);

        chatAdapter.setNotes(chatStorage.getLive());

        chatAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(chatAdapter);

    }

}