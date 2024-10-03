package android.assignment.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
        Button btnSubmit;
        TextView edtContent;
        btnSubmit = findViewById(R.id.btnSubmit);
        edtContent = findViewById(R.id.edtContent);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChildActivity.class);
                startActivity(intent);
            }
        });
        try{
            Intent yourIntent = getIntent();
            Bundle bd = yourIntent.getBundleExtra("bd");
            if(bd==null) {
                Toast.makeText(getApplicationContext(),"NULL",Toast.LENGTH_SHORT).show();
                return;
            }
            String name = bd.getString("name");
            DecimalFormat dcf = new DecimalFormat("0.##");
            Double gpa = bd.getDouble("gpa");
            String message = "Họ và tên: "+name+"\n"
                    +"Điểm GPA: "+dcf.format(gpa);
            edtContent.setText(message);
        }catch (Exception e) {

        }


    }
}