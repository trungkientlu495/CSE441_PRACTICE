package android.assignment.prac03;

import android.assignment.prac03.Adater.CountryAdater;
import android.assignment.prac03.Model.ConuntryInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.listview);
        ArrayList<ConuntryInfo> conuntryInfos = new ArrayList<>();
        CountryAdater countryAdater = new CountryAdater(MainActivity.this,conuntryInfos,R.layout.activity_item_list_view);
        conuntryInfos.add(new ConuntryInfo("Việt Nam","Việt Nam",R.drawable.vietnam));
        conuntryInfos.add(new ConuntryInfo("Trung Quốc","Trung Quốc",R.drawable.china));
        conuntryInfos.add(new ConuntryInfo("Ấn Độ","Ấn Độ",R.drawable.india));
        listView.setAdapter(countryAdater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bd = new Bundle();
                bd.putInt("position",i);
                Intent intent = new Intent(MainActivity.this, DetailCountry.class);
                intent.putExtra("bd",bd);
                startActivity(intent);
            }
        });
    }
}