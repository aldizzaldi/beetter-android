package com.example.beetter.ui.team;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.beetter.R;
import com.example.beetter.SharedPrefUtils;
import com.example.beetter.ui.listteam.ListTeamActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamFragment extends Fragment {
    private View root;
    @BindView(R.id.btnGoToAnotherTeam)
    Button goToAnotherTeam;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.team, container, false);
        ButterKnife.bind(this, root);
        goToAnotherTeam.setOnClickListener(listener);

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

    Button.OnClickListener listener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), ListTeamActivity.class);
            startActivity(intent);
            SharedPrefUtils.removeSavedPref("id_team");
            getActivity().finish();
        }
    };
}