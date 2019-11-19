package com.example.beetter;

import android.os.Bundle;

import com.example.beetter.model.Member;
import com.example.beetter.model.MemberAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MemberAdapter memberAdapter;
    private ArrayList<Member> memberArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_daily_report, R.id.navigation_report_productivity, R.id.navigation_team)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
      //  NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        memberAdapter = new MemberAdapter(memberArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NavigationActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(memberAdapter);

    }

    void addData(){
        memberArrayList = new ArrayList<>();
        memberArrayList.add(new Member("Buddy", 80));
        memberArrayList.add(new Member("Steven", 70));
        memberArrayList.add(new Member("JefLam", 30));
    }

}
