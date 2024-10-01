package android.assignment.ex04;

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
        Button btnCelcius,btnFahrenheit;
        EditText edtCelcius,edtFahrenheit;
        btnFahrenheit = findViewById(R.id.btnFahrenheit);
        btnCelcius = findViewById(R.id.btnCelcius);
        edtCelcius = findViewById(R.id.edtCelcius);
        edtFahrenheit = findViewById(R.id.edtFahrenheit);
        btnFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    String doC = edtCelcius.getText()+"";
                    int C = Integer.parseInt(doC);
                    edtFahrenheit.setText(""+dcf.format(C*1.8+32));
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();;
                }

            }
        });
        btnCelcius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    String doF = edtFahrenheit.getText()+"";
                    int F = Integer.parseInt(doF);
                    edtCelcius.setText(""+dcf.format((F-32)/1.8));
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}