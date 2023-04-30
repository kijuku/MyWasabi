package com.main.mywasabi.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.main.mywasabi.Chat.Chat;
import com.main.mywasabi.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfigFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfigFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Chat noteStorage;

    private TextView txtUserName, txtUserDescription,  txtUserFavComment;
    private RadioGroup txtUserColor;

    private BotInfoAdapter botInfoAdapter;
    private ImageButton btnSaveConfig;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConfigFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfigFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfigFragment newInstance(String param1, String param2) {
        ConfigFragment fragment = new ConfigFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_config, container, false);
        noteStorage = Chat.getInstance();

        txtUserName = view.findViewById(R.id.txtUserNameEdit);
        txtUserColor = view.findViewById(R.id.rgColor);
        txtUserFavComment = view.findViewById(R.id.txtFavComment);
        btnSaveConfig = view.findViewById(R.id.btnSaveConfig);
        txtUserDescription = view.findViewById(R.id.txtUserDescription);

        txtUserName.setText((CharSequence) noteStorage.getUsers().get(0).getName());
        txtUserFavComment.setText((CharSequence) noteStorage.getUsers().get(0).getFavoriteComment());
        txtUserDescription.setText((CharSequence) noteStorage.getUsers().get(0).getDescription());
        btnSaveConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = String.valueOf(txtUserName.getText());
                String favComment = String.valueOf(txtUserFavComment.getText());
                String userDesc = String.valueOf(txtUserDescription.getText());

                if (!userName.isEmpty()) noteStorage.getUsers().get(0).setName(userName);
                if (!favComment.isEmpty())noteStorage.getUsers().get(0).setFavoriteComment(favComment);
                if (!userDesc.isEmpty())noteStorage.getUsers().get(0).setDescription(userDesc);

                Toast toast = Toast.makeText(getContext(), "User config saved: " + userName + ", " + favComment, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return view;
    }
}