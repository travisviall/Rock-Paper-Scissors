package edu.weber.cs.w01370618.cs3270a3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopFragment.onButtonListener, BottomFragment.resetButtonListener{

    private BottomFragment bottomFragment;
    private TopFragment topFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void topButtonPressed(int gamesPlayed, int phoneWins, int myWins, int ties) {
        if(bottomFragment == null) {
            FragmentManager fm = getSupportFragmentManager();
            bottomFragment = (BottomFragment)fm.findFragmentById(R.id.bottom_frag);
        }

        bottomFragment.updateGamesPlayed(gamesPlayed, phoneWins, myWins, ties);
    }

    @Override
    public void resetButtonPressed() {
        if(topFragment == null) {
            FragmentManager fm = getSupportFragmentManager();
            topFragment = (TopFragment) fm.findFragmentById(R.id.top_frag);
        }

        topFragment.resetCounts();
    }
}