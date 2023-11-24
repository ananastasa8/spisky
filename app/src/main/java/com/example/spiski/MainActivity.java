package com.example.spiski;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    ArrayList<gam> games = new ArrayList<gam>();
    ListView gruskiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        gruskiList = findViewById(R.id.countriesList);
        // создаем адаптер
        GameAdapter stateAdapter = new GameAdapter(this, R.layout.list_item, games);

        // устанавливаем адаптер
        gruskiList.setAdapter(stateAdapter);

        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                gam selectedState = (gam)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };

    }
    private void setInitialData(){

        games.add(new gam ("Выпечка", " хлеб", R.drawable.xleb,1));
        games.add(new gam ("Овощь", " Баклажан", R.drawable.baklacgan,1 ));
        games.add(new gam ("Овощь", "Кукуруза", R.drawable.kykyryza,1  ));
        games.add(new gam ("Овощь", "Огурец ", R.drawable.ogurez,1 ));
        games.add(new gam ("Овощь", "Помидор", R.drawable.pomidor,1 ));
    }
}
