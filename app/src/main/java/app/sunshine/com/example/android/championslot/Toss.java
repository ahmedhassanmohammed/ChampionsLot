package app.sunshine.com.example.android.championslot;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.util.Collections.shuffle;


public class Toss extends AppCompatActivity {

    @BindView(R.id.toss21)
    Button toss21;

    @BindView(R.id.toss31)
    Button toss31;

    @BindView(R.id.black_white)
    TextView black_white;

    @BindView(R.id.Scissors_Stone_Paper)
    TextView scissors_Stone_Paper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        ButterKnife.bind(this);

        final ArrayList<String> t21 =new ArrayList<>();
        final ArrayList<String> t31 =new ArrayList<>();
        t21.add("Black");
        t21.add("White");
        t21.add("Black");
        t21.add("White");
        t21.add("Black");
        t21.add("White");
        t31.add("Scissors");
        t31.add("Stone");
        t31.add("Paper");

        toss21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffleList(t21);
                black_white.setText(t21.get(2)+" Wins");
            }
        });

        toss31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffleList(t31);
                scissors_Stone_Paper.setText(t31.get(1)+" Wins");
            }
        });
    }

    static void shuffleList(List<String> list) {
        long seed = System.nanoTime();
        shuffle(list, new Random(seed));
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void forceRTLIfSupported()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
    }
}
