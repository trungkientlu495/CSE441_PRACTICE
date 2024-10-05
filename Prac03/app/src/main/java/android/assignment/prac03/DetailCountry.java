package android.assignment.prac03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class DetailCountry extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_country);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<android.assignment.prac03.Model.DetailCountry> detailCountryList = new ArrayList<>();
        detailCountryList.add(new android.assignment.prac03.Model.DetailCountry("Việt Nam",R.drawable.vietnam,"Hà Nội"));
        detailCountryList.add(new android.assignment.prac03.Model.DetailCountry("Trung Quốc",R.drawable.china,"Bắc Kinh"));
        detailCountryList.add(new android.assignment.prac03.Model.DetailCountry("Ấn độ",R.drawable.india,"New Delhi"));
//        detailCountryList.add(new android.assignment.prac03.Model.DetailCountry("Anh",R.drawable.anh,"LonDon"));
//        detailCountryList.add(new android.assignment.prac03.Model.DetailCountry("Nigeria",R.drawable.nigeria,"Abuja"));
//        detailCountryList.add(new android.assignment.prac03.Model.DetailCountry("Indonesia",R.drawable.indonesia,"New Delhi"));
        TextView edtNational,edtCapital,edtTitle;
        ImageView image;
        edtNational = findViewById(R.id.edtNational);
        edtCapital = findViewById(R.id.edtCapital);
        edtTitle = findViewById(R.id.edtTitle);
        image = findViewById(R.id.abc);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bd");
        int position = bundle.getInt("position");
        for(int i=0;i<detailCountryList.size();i++) {
            if(i==position) {
                edtNational.setText(detailCountryList.get(i).getNation());
                edtCapital.setText(detailCountryList.get(i).getCapital());
                image.setImageResource(detailCountryList.get(i).getImage());
                edtTitle.setText(detailCountryList.get(i).getNation());
            }
        }
    }
}