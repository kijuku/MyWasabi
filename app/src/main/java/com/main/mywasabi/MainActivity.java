package com.main.mywasabi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.main.mywasabi.Bot.Answer;
import com.main.mywasabi.Bot.Bot;
import com.main.mywasabi.Bot.BotA;
import com.main.mywasabi.Bot.Comment;
import com.main.mywasabi.Chat.Chat;
import com.main.mywasabi.Chat.ConsoleColors;
import com.main.mywasabi.Chat.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Chat chatStorage;
    private Context context;
    private Bot bot;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatStorage = Chat.getInstance();
        context = MainActivity.this;

        chatStorage.generateBotArmy(5);

        //System.out.println(chatStorage);

        bot = new BotA("Jarppi");

        Random rnd = new Random();
        int low = 0;
        int high = bot.getAnswers().size();
        if (high > bot.getComments().size())
            high = bot.getComments().size();

        int pos = 0, pos1= 0, pos2 = 0;
        for (int i = 0; i < 10 ; i++) {
            pos = rnd.nextInt(high-low) + low;
            pos1 = rnd.nextInt(high-low) + low;
            pos2 = rnd.nextInt(high-low) + low;

            chatStorage.addNewMessageToList
                    (
                    new Message(chatStorage.getBots().get(0).getName(),chatStorage.getBots().get(0).getAnswer(pos))
            );
            chatStorage.addNewMessageToList(
                    new Message(chatStorage.getBots().get(1).getName(),chatStorage.getBots().get(1).getComment(pos1))
            );
            chatStorage.addNewMessageToList(
                    new Message(chatStorage.getBots().get(2).getName(),chatStorage.getBots().get(2).getComment(pos2))
            );

            System.out.println(chatStorage.getBots().get(0).getName()+": "+chatStorage.getBots().get(0).getAnswer(pos));
            System.out.println(chatStorage.getBots().get(1).getName()+": "+chatStorage.getBots().get(1).getComment(pos1));
            System.out.println(chatStorage.getBots().get(2).getName()+": "+chatStorage.getBots().get(2).getComment(pos2));
        }

        TabLayout tabLayout = findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = findViewById(R.id.fragmentArea);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
        fragmentArea.setAdapter(tabPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }
    public void createBotArmy(){

    }

}