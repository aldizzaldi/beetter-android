package com.example.beetter.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.model.Member;
import com.example.beetter.model.MemberAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private MemberAdapter memberAdapter;
    private ArrayList<Member> memberArrayList;
    private TextView txtName;
    private TextView txtPercent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        txtName = (TextView) root.findViewById(R.id.home_member_name);
        txtPercent = (TextView)root.findViewById(R.id.home_percent_productivities);

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)root.findViewById(R.id.toolnbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        addData();

        memberAdapter = new MemberAdapter(memberArrayList);
        recyclerView.setAdapter(memberAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    void addData(){
        memberArrayList = new ArrayList<>();
        memberArrayList.add(new Member("Buddy", 80));
        memberArrayList.add(new Member("Steven", 70));
        memberArrayList.add(new Member("JefLam", 30));
        memberArrayList.add(new Member("Wifda", 80));
    }


}