package com.amaz.jobsaround.ui.fragments.chat;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.adapters.ChatFreindsAdapter;
import com.amaz.jobsaround.ui.activities.chat.ChatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {


    private static final String TAG = "ChatFragment";
    private Unbinder unbinder;
    private ChatFreindsAdapter chatFreindsAdapter;
    @BindView(R.id.chat_rv)
    RecyclerView chatRv;
    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chat, container, false);

        unbinder = ButterKnife.bind(this, view);
        initChatRv();

        return  view;
    }

    private void initChatRv() {
        chatFreindsAdapter = new ChatFreindsAdapter(getContext());
        chatRv.setAdapter(chatFreindsAdapter);
        chatRv.setHasFixedSize(true);
        chatRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
