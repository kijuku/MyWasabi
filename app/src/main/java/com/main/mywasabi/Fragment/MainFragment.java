package com.main.mywasabi.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.main.mywasabi.Chat.Chat;
import com.main.mywasabi.Chat.Message;
import com.main.mywasabi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private Chat noteStorage;
    private ImageView imgBtnSend;

    private TextView msgChat;
    private ChatListAdapter chatAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        noteStorage = Chat.getInstance();

        chatAdapter = new ChatListAdapter(view.getContext(),noteStorage.getMessages());

        TabLayout tabLayout = view.findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = view.findViewById(R.id.fragmentArea);
        imgBtnSend = view.findViewById(R.id.imgBtnSend);
        msgChat = view.findViewById(R.id.msgChat);

        recyclerView = view.findViewById(R.id.ChatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext().getApplicationContext() ));
       // recyclerView.setAdapter(new ChatListAdapter(view.getContext(), noteStorage.getMessages()));

        recyclerView.setAdapter(chatAdapter);
        recyclerView.scrollToPosition(noteStorage.getMessages().size()-1);
        msgChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(msgChat.getText());
                Message message = new Message(noteStorage.getUsers().get(0).getName(), str
                        );
                noteStorage.getMessages().add(message);
                System.out.println(message);

                chatAdapter.setNotes(noteStorage.getMessages());

                chatAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(chatAdapter);
            }

        });
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager=LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 10 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    //you have reached to the bottom of your recycler view
                    System.out.println("totalItemCount: " + totalItemCount);
                    recyclerView.smoothScrollToPosition(totalItemCount-1);
                    recyclerView.canScrollVertically(1);
                }
              }
       /* public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager=LinearLayoutManager.class.cast(recyclerView.getLayoutManager());

                if (!recyclerView.canScrollVertically(0)){
                    layoutManager.setReverseLayout(false);
                //layoutManager.canScrollVertically();
                }
            }*/
        }
        );


        return view;
    }


}