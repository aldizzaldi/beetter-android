package com.example.beetter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Set;

public class SlidingUp extends BottomSheetDialogFragment {
    private SlidingUpListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.team, container, false);

        Button btnExitTeam = v.findViewById(R.id.btnGoToAnotherTeam);

        btnExitTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

    public interface SlidingUpListener {
        void onClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (SlidingUpListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + " must implemet Sliding Up Listener");
        }

    }
}
