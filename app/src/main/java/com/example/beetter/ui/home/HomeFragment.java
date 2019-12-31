package com.example.beetter.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beetter.R;
import com.example.beetter.SharedPrefUtils;
import com.example.beetter.ui.login.LoginActivity;
import com.example.beetter.ui.profile.ProfileActivity;
import com.example.beetter.ui.splashscreen.SplashScreen;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements IHomeView{

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private HomePresenter presenter;
    private View root;

    @BindView(R.id.overall_productivity)
    TextView overallProductivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.home, container, false);

//        androidx.appcompat.widget.Toolbar toolbar = (Toolbar)root.findViewById(R.id.toolnbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ButterKnife.bind(this, root);

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.profile){
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            this.startActivity(intent);
        }
        else {
            SharedPrefUtils.removeSavedPref("token");
            Intent intent = new Intent(getActivity(), SplashScreen.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getTeamMember(ArrayList<HomeReportProductivity> reportProductivities) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewMember);
        homeAdapter = new HomeAdapter(reportProductivities, getContext());
        Log.e("hehe", reportProductivities.size() + "!");

        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showOverallProductivitiesTeam(double value) {
        overallProductivity.setText(value + "%");
    }
}