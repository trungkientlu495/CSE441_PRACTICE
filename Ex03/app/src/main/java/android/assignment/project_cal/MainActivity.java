package android.assignment.project_cal;

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
        EditText edtInputA,edtInputB,edtInputC;
        Button btnSum,btnTru,btnTich,btnDivide;
        edtInputA = findViewById(R.id.edtInputA);
        edtInputB = findViewById(R.id.edtInputB);
        edtInputC = findViewById(R.id.edtInputC);
        btnSum = findViewById(R.id.btnSum);
        btnTru = findViewById(R.id.btnTru);
        btnTich = findViewById(R.id.btnTich);
        btnDivide = findViewById(R.id.btnDivide);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edtInputA.getText().toString());
                    int b = Integer.parseInt(edtInputB.getText().toString());
                    int c = a + b;
                    edtInputC.setText(a+" + "+b+" = " +c);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edtInputA.getText().toString());
                    int b = Integer.parseInt(edtInputB.getText().toString());
                    int c = a - b;
                    edtInputC.setText(a+" - "+b+" = " +c);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edtInputA.getText().toString());
                    int b = Integer.parseInt(edtInputB.getText().toString());
                    int c = a * b;
                    edtInputC.setText(a+" * "+b+" = " +c);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edtInputA.getText().toString());
                    int b = Integer.parseInt(edtInputB.getText().toString());
                    double c =(double) a / b;
                    edtInputC.setText(a+" : "+b+" = " +c);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}