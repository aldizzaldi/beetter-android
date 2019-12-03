package com.example.beetter.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.model.dummy.Member;
import com.example.beetter.model.dummy.MemberAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IHomeView{

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private HomePresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)root.findViewById(R.id.toolnbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        presenter = new HomePresenter(this);
        presenter.getListMemberInTeam();


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


    @Override
    public void getTeamMember(ArrayList<ReportProductivity> reportProductivities) {
        homeAdapter = new HomeAdapter(reportProductivities, getContext());
        Log.e("hehe", reportProductivities.size() + "!");

        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}