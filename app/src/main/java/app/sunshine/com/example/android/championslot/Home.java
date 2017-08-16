package app.sunshine.com.example.android.championslot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {
//    @BindView(R.id.no_of_player_et)
//    EditText NumOfPlayers;
    @BindView(R.id.no_of_grouped_etd)
    EditText NumOfGroupes;
    @BindView(R.id.Add_player_et)
    EditText Players;
    @BindView(R.id.toss)
    TextView toss;
    @BindView(R.id.btn_submit)
    AppCompatButton Submit_Button;
    @BindView(R.id.add)
    Button AddBtn;
    ArrayList<String> playerlist;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        playerlist=new ArrayList<String>();

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(Players.getText().toString().equals("")){
                    Toast.makeText(Home.this, "Plaese Write Player name", Toast.LENGTH_SHORT).show();
                }else {
                    playerlist.add(Players.getText().toString());
                Players.setText("");
                Toast.makeText(Home.this, "Player " +i +" Added", Toast.LENGTH_SHORT).show();
                i++;
                }

            }
        });

        Submit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NumOfGroupes.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Select num of groups, please", Toast.LENGTH_LONG).show();
                }
                else {
                    int no_of_player = 0;
                    int num_of_groups = Integer.parseInt(NumOfGroupes.getText().toString());

                    Intent intent = new Intent(getApplicationContext(), Groupes.class);

                    for (int i = 0; i < playerlist.size(); i++) {


                        intent.putExtra("t" + i, playerlist.get(i));
                        no_of_player++;
                    }
                    intent.putExtra("no_of_player", no_of_player);
                    intent.putExtra("no_of_groups", num_of_groups);

                    if (num_of_groups > 4 || num_of_groups <= 1) {

                        Toast.makeText(getApplicationContext(), "Check no.of groups", Toast.LENGTH_LONG).show();
                        return;
                    }


                    startActivity(intent);
                }

            }
        });


        toss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this , Toss.class);
                startActivity(intent);
            }
        });
    }
}
