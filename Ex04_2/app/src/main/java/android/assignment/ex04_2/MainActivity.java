package android.assignment.ex04_2;

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

import java.text.DecimalFormat;

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
        EditText edtName,edtHeight,edtWeight,edtBMI,edtDiagnosis;
        Button btnBMI;
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtBMI = findViewById(R.id.edtBMI);
        edtDiagnosis = findViewById(R.id.edtDiagnosis);
        btnBMI = findViewById(R.id.btnBMI);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    double height = Double.parseDouble(edtHeight.getText().toString());
                    double weight = Double.parseDouble(edtWeight.getText().toString());
                    DecimalFormat dcf = new DecimalFormat("#0");

                    double BMI = weight/(height*height);
                    edtBMI.setText(dcf.format(BMI));

                        if(BMI<18) {
                            edtDiagnosis.setText("GẦY");
                        }
                        else if(BMI>=18&&BMI<=24.9) {
                            edtDiagnosis.setText("BÌNH THƯƠỜNG");
                        }
                        else if(BMI>=25&&BMI<=29.9) {
                            edtDiagnosis.setText("BÉO PHÌ CẤP I");
                        }
                        else if(BMI>=30&&BMI<=34.9) {
                            edtDiagnosis.setText("BÉO PHÌ CẤP II");
                        }
                        else if(BMI>35) {
                            edtDiagnosis.setText("BÉO PHÌ CẤP III");
                        }

                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "Input valid", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}