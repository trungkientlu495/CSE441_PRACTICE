package android.assignment.ex05_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        EditText edtYearPlus,edtYear;
        Button btnConvert;
        edtYearPlus = findViewById(R.id.edtYearPlus);
        edtYear = findViewById(R.id.edtYear);
        btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int yearPlus = Integer.parseInt(edtYearPlus.getText().toString());
                    int a,b;
                    a = yearPlus%10;
                    b = yearPlus%12;
                    String can = "",chi = "";
                    switch (a) {
                        case 0:
                            can = "Canh";
                            break;
                        case 1:
                            can = "Tân";
                            break;
                        case 2:
                            can = "Nhâm";
                            break;
                        case 3:
                            can = "Quý";
                            break;
                        case 4:
                            can = "Giáp";
                            break;
                        case 5:
                            can = "Ất";
                            break;
                        case 6:
                            can = "Bính";
                            break;
                        case 7:
                            can = "Đinh";
                            break;
                        case 8:
                            can = "Mậu";
                            break;
                        case 9:
                            can = "Kỷ";
                            break;

                    }
                    switch (b) {
                        case 0:
                            chi = "Thân";
                            break;
                        case 1:
                            chi = "Dậu";
                            break;
                        case 2:
                            chi = "Tuất";
                            break;
                        case 3:
                            chi = "Hợi";
                            break;
                        case 4:
                            chi = "Tý";
                            break;
                        case 5:
                            chi = "Sửu";
                            break;
                        case 6:
                            chi = "Dần";
                            break;
                        case 7:
                            chi = "Mão";
                            break;
                        case 8:
                            chi = "Thìn";
                            break;
                        case 9:
                            chi = "Tỵ";
                            break;
                        case 10:
                            chi = "Ngọ";
                            break;
                        case 11:
                            chi = "Mùi";
                            break;

                    }
                    edtYear.setText(can + " " +chi);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}