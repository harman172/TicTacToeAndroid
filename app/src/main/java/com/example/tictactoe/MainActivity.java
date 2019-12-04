package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /*
        * 0 is player yellow
        * 1 is player red
    */

    private int player = 0;
    private int winner = -1;

    private int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int[][] winning =  { {0,1,2}, {0,3,6}, {3,4,5}, {6,7,8}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

    }

    public void dropImage(View view){

         if (winner < 0) {


            ImageView imageView = (ImageView) view;
            int state = Integer.valueOf(imageView.getTag().toString());

            imageView.setTranslationY(-1500);

            if (gameState[state] == -1) {
                gameState[state] = player;
                if (player == 0) {
                    imageView.setImageResource(R.drawable.yellow);
                    player = 1;
//                imageView.setClickable(false);
                } else {
                    imageView.setImageResource(R.drawable.red);
                    player = 0;
//                imageView.setClickable(false);

                }
            }


            imageView.animate().translationYBy(1500).setDuration(300);
            getWinner();

        }
    }


    private void getWinner(){
        for (int i = 0; i<winning.length; i++){
            if ((gameState[winning[i][0]] == gameState[winning[i][1]]) && (gameState[winning[i][0]] == gameState[winning[i][2]])){
                winner = gameState[winning[i][0]];
                if (winner >= 0) {
                    Toast.makeText(this, "Winnnnnner is: " + winner, Toast.LENGTH_SHORT).show();
                    if (winner == 0)
                        textView.setText("Yellow wins the game");
                    else
                        textView.setText("Red wins the game");
                }
            }

        }
    }


}
