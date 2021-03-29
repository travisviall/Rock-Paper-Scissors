package edu.weber.cs.w01370618.cs3270a3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BottomFragment extends Fragment {

    private View root;
    private TextView gamesPlayedView;
    private TextView phoneWinsView;
    private TextView myWinsView;
    private TextView tiesView;
    private resetButtonListener mCallback;

    public interface resetButtonListener{
        void resetButtonPressed();
    }

    public BottomFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        gamesPlayedView =root.findViewById(R.id.games_played_total);
        phoneWinsView = root.findViewById(R.id.phone_win_total);
        myWinsView = root.findViewById(R.id.my_win_total);
        tiesView = root.findViewById(R.id.tie_games_total);

        Button resetBtn = root.findViewById(R.id.btn_reset);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamesPlayedView.setText(String.valueOf(0));
                phoneWinsView.setText(String.valueOf(0));
                myWinsView.setText(String.valueOf(0));
                tiesView.setText(String.valueOf(0));
                mCallback.resetButtonPressed();

                Toast toast = Toast.makeText(getActivity(),"Counts are reset", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    public void updateGamesPlayed(int gamesPlayed, int phoneWins, int myWins, int ties) {
        gamesPlayedView.setText(String.valueOf(gamesPlayed));
        phoneWinsView.setText(String.valueOf(phoneWins));
        myWinsView.setText(String.valueOf(myWins));
        tiesView.setText(String.valueOf(ties));
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (resetButtonListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString() + "Must implement resetButtonListener");
        }

    }
}