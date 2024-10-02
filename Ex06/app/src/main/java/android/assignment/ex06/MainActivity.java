package android.assignment.ex06;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtCMND,edtInsertInfo;
    RadioButton rdTrungCap,rdCaoDang,rdDaiHoc;
    CheckBox cbDocBao,cbDocSach,cbDocCode;
    Button btnSubmit;

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
        btnSubmit = findViewById(R.id.btnSubmit);
        rdDaiHoc = findViewById(R.id.rdDaiHoc);
        rdDaiHoc.setChecked(true);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doShowInfomation();
            }
        });
    }
    public void doShowInfomation() {
        edtName = findViewById(R.id.edtName);
        edtCMND = findViewById(R.id.edtCMND);
        edtInsertInfo = findViewById(R.id.edtInsertInfo);
        rdTrungCap = findViewById(R.id.rdTrungCap);
        rdCaoDang = findViewById(R.id.rdCaoDang);
        rdDaiHoc = findViewById(R.id.rdDaiHoc);
        cbDocBao = findViewById(R.id.cbDocBao);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocCode = findViewById(R.id.cbDocCode);
        if(edtName.getText().length()<3) {
            Toast.makeText(getApplicationContext(), "Họ tên không được < 3 kí tự", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            int cmnd = Integer.parseInt(edtCMND.getText().toString());
            if(edtCMND.getText().length()!=9) {
                Toast.makeText(getApplicationContext(), "CMND phải có 9 chữ số", Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Input CMND valid", Toast.LENGTH_SHORT).show();
        }
        String bangcap = "";
        if(rdDaiHoc.isChecked()) {
            bangcap = "Đại học";
        }else if(rdCaoDang.isChecked()) {
            bangcap = "Cao đẳng";
        }else {
            bangcap = "Trung cấp";
        }
        String tailieu = "";
        if(cbDocCode.isChecked()&&cbDocSach.isChecked()&&cbDocBao.isChecked()) {
            tailieu = "Đọc báo - Đọc sách - Đọc code";
        }else if(cbDocBao.isChecked()&&cbDocSach.isChecked()) {
            tailieu = "Đọc báo - Đọc sách";
        }else if(cbDocSach.isChecked()&&cbDocCode.isChecked()) {
            tailieu = "Đọc sách - Đọc code";
        }else if(cbDocBao.isChecked()&&cbDocCode.isChecked()) {
            tailieu = "Đọc báo - Đọc code";
        }else if(cbDocBao.isChecked()) {
            tailieu = "Đọc báo";
        }else if(cbDocSach.isChecked()) {
            tailieu = "Đọc sách";
        }else if(cbDocCode.isChecked()) {
            tailieu = "Đọc code";
        }
        String info = "";
        if(edtInsertInfo.getText().length()==0) {
            info = "Không có thông tin";
        }else {
            info = edtInsertInfo.getText().toString();
        }
        if(cbDocBao.isChecked() || cbDocSach.isChecked() || cbDocCode.isChecked()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String message = edtName.getText().toString()+"\n"
                    + edtCMND.getText().toString()+"\n"
                    + bangcap+"\n"+tailieu+"\n"+"-----------------------------------"+"\n"
                    +"Thông tin bổ sung:"+"\n"+info+"\n"+"-----------------------------------";
// Thiết lập tiêu đề và nội dung
            builder.setTitle("Thông tin cá nhân")
                    .setMessage(message);
            builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }else{
            Toast.makeText(getApplicationContext(), "Sở thích phải chọn ít nhất 1 loại", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        b.create().show();
    }
}