package android.assignment.prac01;

import android.content.Intent;
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

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack;
        EditText edtName,edtGPA;
        btnBack = findViewById(R.id.btnBack);
        edtName = findViewById(R.id.edtName);
        edtGPA = findViewById(R.id.edtGPA);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name = edtName.getText().toString().trim();
                    double gpa = Double.parseDouble(edtGPA.getText().toString());
                    Intent intent = new Intent(ChildActivity.this,MainActivity.class);
                    Bundle bd = new Bundle();
                    bd.putString("name",name);
                    bd.putDouble("gpa",gpa);
                    intent.putExtra("bd",bd);
                    startActivity(intent);
                }catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}