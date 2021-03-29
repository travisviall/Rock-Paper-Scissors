package edu.weber.cs.w01370618.cs3270a3;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TopFragment extends Fragment  {

    private View root;
    private onButtonListener mCallback;
    private Button btnRock;
    private Button btnPaper;
    private Button btnScissors;
    private String selectedValue;
    private TextView replacedValue;
    private TextView results;
    private int gamesPlayedCount;
    private int phoneWinsCount;
    private int myWinsCount;
    private int tiesCount;
    final private String [] phoneSelectionValues = {"Rock", "Paper", "Scissors"};

    public interface onButtonListener {
        void topButtonPressed(int gamesPlayed, int phoneWins, int myWins, int ties);
    }

    public TopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        btnRock = root.findViewById(R.id.btn_rock);
        btnPaper = root.findViewById(R.id.btn_paper);
        btnScissors = root.findViewById(R.id.btn_scissors);
        replacedValue = root.findViewById(R.id.phone_pick_value);
        results = root.findViewById(R.id.game_result);

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedValue = btnRock.getText().toString();
                playGame(selectedValue);
                gamesPlayedCount++;
                mCallback.topButtonPressed(gamesPlayedCount, phoneWinsCount, myWinsCount, tiesCount);
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedValue = btnPaper.getText().toString();
                playGame(selectedValue);
                gamesPlayedCount++;
                mCallback.topButtonPressed(gamesPlayedCount, phoneWinsCount, myWinsCount, tiesCount);
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedValue = btnScissors.getText().toString();
                playGame(selectedValue);
                gamesPlayedCount++;
                mCallback.topButtonPressed(gamesPlayedCount, phoneWinsCount, myWinsCount, tiesCount);
            }
        });
    }

    public void playGame(String myPick) {

        Random rand = new Random();
        String phonePick = phoneSelectionValues[rand.nextInt(phoneSelectionValues.length)];
        replacedValue.setText(phonePick);

        if(myPick.equals(phonePick)) {
            results.setText(R.string.tie);
            tiesCount++;
        }
        else if(myPick.equals("Rock") && phonePick.equals("Scissors")) {
            results.setText(R.string.win);
            myWinsCount++;
        }
        else if(myPick.equals("Rock") && phonePick.equals("Paper")) {
            results.setText(R.string.lose);
            phoneWinsCount++;
        }
        else if(myPick.equals("Scissors") && phonePick.equals("Paper")) {
            results.setText(R.string.win);
            myWinsCount++;
        }
        else if (myPick.equals("Scissors") && phonePick.equals("Rock")) {
            results.setText(R.string.lose);
            phoneWinsCount++;
        }
        else if (myPick.equals("Paper") && phonePick.equals("Rock")) {
            results.setText(R.string.win);
            myWinsCount++;
        }
        else if (myPick.equals("Paper") && phonePick.equals("Scissors")) {
            results.setText(R.string.lose);
            phoneWinsCount++;
        }
    }

    public void resetCounts() {
       gamesPlayedCount = 0;
        phoneWinsCount = 0;
        myWinsCount = 0;
        tiesCount = 0;
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (onButtonListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString() + "Must implement onButtonListener");
        }

    }
}