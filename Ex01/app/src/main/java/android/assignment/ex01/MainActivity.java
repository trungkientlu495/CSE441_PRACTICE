package android.assignment.ex01;

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
        EditText edtInputA,edtInputB,edtResult;
        Button btnSum;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtInputA = findViewById(R.id.edtInputA);
        edtInputB = findViewById(R.id.edtInputB);
        edtResult = findViewById(R.id.edtResult);
        btnSum = findViewById(R.id.btnSum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int number1 = Integer.parseInt(edtInputA.getText().toString());
                    int number2 = Integer.parseInt(edtInputB.getText().toString());
                    int sum = number1 + number2;
                    edtResult.setText(sum+"");
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}