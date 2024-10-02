package android.assignment.ex05_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        EditText edtInputA,edtInputB,edtInputC;
        TextView edtResult;
        Button btnContinue,btnResult,btnClose;
        edtInputA = findViewById(R.id.edtInputA);
        edtInputB = findViewById(R.id.edtInputB);
        edtInputC = findViewById(R.id.edtInputC);
        edtResult = findViewById(R.id.edtResult);
        btnContinue = findViewById(R.id.btnContinue);
        btnResult = findViewById(R.id.btnResult);
        btnClose = findViewById(R.id.btnClose);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtInputA.setText("");
                edtInputB.setText("");
                edtInputC.setText("");
                edtResult.setText("");
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String sa = edtInputA.getText()+"";
                    String sb = edtInputB.getText()+"";
                    String sc = edtInputC.getText()+"";
                    int a = Integer.parseInt(sa);
                    int b = Integer.parseInt(sb);
                    int c = Integer.parseInt(sc);
                    String kq = "";
                    DecimalFormat dcf = new DecimalFormat("#0.00");
                    if(a==0) {
                        if(b==0) {
                            if(c==0) {
                                kq="PT vô số nghiệm";
                            }else{
                                kq="PT vô nghiệm";
                            }
                        }else{
                            kq="PT có 1 nghiệm "+dcf.format(-c/b);
                        }
                    }else {
                        double delta = b*b-4*a*c;
                        if(delta<0) {
                            kq="PT vô nghiệm";
                        }else if(delta==0) {
                            kq="PT có nghiệm kép x1=x2="+dcf.format(-b/(2*a));
                        }else{
                            kq="PT có 2 nghiệm x1 = "+dcf.format((-b+Math.sqrt(delta/(2*a))))+" x2 = "+dcf.format((b-Math.sqrt(delta/(2*a))));
                        }
                    }
                    edtResult.setText(kq);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}