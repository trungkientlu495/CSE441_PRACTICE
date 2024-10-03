package android.assignment.ex07_2;

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
        EditText edtInputA,edtInputB;
        Button btnResult;
        edtInputA = findViewById(R.id.edtInputA);
        edtInputB = findViewById(R.id.edtInputB);
        btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int a = Integer.parseInt(edtInputA.getText().toString());
                    int b = Integer.parseInt(edtInputB.getText().toString());
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    Bundle bl = new Bundle();
                    bl.putInt("numberA",a);
                    bl.putInt("numberB",b);
                    intent.putExtra("bl",bl);
                    startActivity(intent);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}