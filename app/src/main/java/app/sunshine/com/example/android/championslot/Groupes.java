package app.sunshine.com.example.android.championslot;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.shuffle;

public class Groupes extends AppCompatActivity {

    ListView gruop1;
    ListView gruop2;
    ListView gruop3;
    ListView gruop4;

    ArrayAdapter<String> Adapter1;
    ArrayAdapter<String> Adapter2;
    ArrayAdapter<String> Adapter3;
    ArrayAdapter<String> Adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupes);
        gruop1 = (ListView) findViewById(R.id.Group1);
        gruop2 = (ListView) findViewById(R.id.Group2);
        gruop3 = (ListView) findViewById(R.id.Group3);
        gruop4 = (ListView) findViewById(R.id.Group4);

        TextView g3textview = (TextView) findViewById(R.id.G3Text);
        TextView g4textview = (TextView) findViewById(R.id.G4Text);


        String[] text = new String[16];       // recieve the intent of players

        List<String> players_name = new ArrayList<String>();     // list of players
        int num_of_players;
        int num_of_groups;
        int num_of_players_in_each_group;
        Intent intent = getIntent();

        for (int i = 0; i < 16; i++) {   // for loop for fill the list with players

            text[i] = intent.getStringExtra("t" + i);

            if (text[i] != null)
                players_name.add(text[i]);
        }

        num_of_players = intent.getIntExtra("no_of_player", 10);
        num_of_groups = intent.getIntExtra("no_of_groups", 10);
        num_of_players_in_each_group = num_of_players / num_of_groups;

        shuffleList(players_name);


        if (num_of_groups == 2)

        {


            g3textview.setTextColor(000);
            g4textview.setTextColor(000);
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            if (num_of_players % num_of_groups != 0) {
                list1.add(players_name.get(0));
                players_name.remove(0);
                num_of_players--;
            }
            for (int i = 0; i < num_of_players; i += 2) {
                list1.add(players_name.get(i));
                list2.add(players_name.get(i + 1));
            }

            Adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list1);
            gruop1.setAdapter(Adapter1);
            Adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
            gruop2.setAdapter(Adapter2);

        } else if (num_of_groups == 3)

        {
            g4textview.setTextColor(000);
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            List<String> list3 = new ArrayList<String>();
            if (num_of_players % num_of_groups != 0) {
                list1.add(players_name.get(0));
                players_name.remove(0);
                num_of_players--;
            }
            for (int i = 0; i < num_of_players; i += 3) {
                list1.add(players_name.get(i));
                list2.add(players_name.get(i + 1));
                list3.add(players_name.get(i + 2));

            }
            Adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list1);
            gruop1.setAdapter(Adapter1);
            Adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
            gruop2.setAdapter(Adapter2);
            Adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list3);
            gruop3.setAdapter(Adapter3);

        }
        else if (num_of_groups == 4)

        {

            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            List<String> list3 = new ArrayList<String>();
            List<String> list4 = new ArrayList<String>();
            if (num_of_players % num_of_groups != 0) {
                list1.add(players_name.get(0));
                players_name.remove(0);
                num_of_players--;
            }
            for (int i = 0; i < num_of_players; i += 4) {
                list1.add(players_name.get(i));
                list2.add(players_name.get(i + 1));
                list3.add(players_name.get(i + 2));
                list4.add(players_name.get(i + 3));

            }

            Adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list1);
            gruop1.setAdapter(Adapter1);
            Adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
            gruop2.setAdapter(Adapter2);
            Adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list3);
            gruop3.setAdapter(Adapter3);
            Adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list4);
            gruop4.setAdapter(Adapter4);

        }

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
