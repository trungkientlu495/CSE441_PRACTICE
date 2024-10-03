package android.assignment.ex07_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView edtResult;
        Button btnBack;
        edtResult = findViewById(R.id.edtResult);
        btnBack = findViewById(R.id.btnBack);
        Intent mainIntent = getIntent();
        Bundle bd = mainIntent.getBundleExtra("bl");
        int a = bd.getInt("numberA");
        int b = bd.getInt("numberB");
        String kq = "";
        if(a==0&&b!=0) {
            kq = "Phương trình vô nghiệm";
        } else if (a==0&&b==0) {
            kq = "Phương trình vô số nghiệm";
        }else if(a!=0&&b!=0) {
            DecimalFormat dcf = new DecimalFormat("0.##");
            double dkq = (double) -b/a;
            kq = "" + dcf.format(dkq);
        }
        edtResult.setText(kq);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}