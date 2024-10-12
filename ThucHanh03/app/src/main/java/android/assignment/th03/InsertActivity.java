package android.assignment.th03;

import android.annotation.SuppressLint;
import android.assignment.th03.Model.Student;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InsertActivity extends AppCompatActivity {
    EditText txtMsv,txtName,edtDate,edtGPA,edtEmail;
    Spinner spAddress,spMajor,spYear;
    RadioButton rdNam,rdNu,rdKhac;
    Button btnSubmit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
        rdKhac = findViewById(R.id.rdKhac);
       // rdNam.setChecked(true);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_insert);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtMsv = findViewById(R.id.txtMsv);
        txtName = findViewById(R.id.txtName);
        edtDate = findViewById(R.id.edtDate);
        edtGPA = findViewById(R.id.edtGPA);
        spAddress = findViewById(R.id.spAddress);
        spMajor = findViewById(R.id.spMajor);
        spYear = findViewById(R.id.spYear);
        edtEmail = findViewById(R.id.edtEmail);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtMsv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(txtMsv.getText().toString()+"" == "") {
                        Toast.makeText(getApplicationContext(),"Mã sinh viên không được để trống",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(txtName.getText().toString()+"" == "") {
                        Toast.makeText(getApplicationContext(),"Họ tên không được để trống",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        edtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(edtEmail.getText().toString()+"" == "") {
                        Toast.makeText(getApplicationContext(),"Email không được để trống",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        edtGPA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    if(edtGPA.getText().toString()+"" == "") {
                        Toast.makeText(getApplicationContext(),"GPA không được để trống",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtMsv.getText().toString()+""=="") {
                    Toast.makeText(getApplicationContext(),"Mã sinh viên bị trống",Toast.LENGTH_SHORT).show();
                    txtMsv.requestFocus();
                    return;
                }
                if(txtName.getText().toString()+""=="") {
                    Toast.makeText(getApplicationContext(),"Họ tên bị trống",Toast.LENGTH_SHORT).show();
                    txtName.requestFocus();
                    return;
                }
                if(edtDate.getText().toString()+""=="") {
                    Toast.makeText(getApplicationContext(),"Ngày sinh bị trống",Toast.LENGTH_SHORT).show();
                    edtDate.requestFocus();
                    return;
                }
                if(edtEmail.getText().toString()+""=="") {
                    Toast.makeText(getApplicationContext(),"Email bị trống",Toast.LENGTH_SHORT).show();
                    edtEmail.requestFocus();
                    return;
                }
                if(edtGPA.getText().toString()+""=="") {
                    Toast.makeText(getApplicationContext(),"GPA bị trống",Toast.LENGTH_SHORT).show();
                    edtGPA.requestFocus();
                    return;
                }
                if(rdNam.isChecked()==false&&rdNu.isChecked()==false&rdKhac.isChecked()==false) {
                    Toast.makeText(getApplicationContext(),"Vui lòng check bạn học năm thứ mấy",Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                    String msv = txtMsv.getText().toString()+"";
                    String name = txtName.getText().toString()+"";
                    String date = edtDate.getText().toString()+"";
                    String address = spAddress.toString()+"";
                    String email = edtEmail.getText().toString()+"";
                    String major = spMajor.toString();
                    Double gpa = Double.parseDouble(edtGPA.getText().toString());
                    String gender;
                    String year = spYear.toString();
                    int image = 0;
                    if(rdNam.isChecked()) {
                        gender = "Nam";
                    }else if(rdNu.isChecked()) {
                        gender = "Nữ";
                    }else {
                        gender = "Khác";
                    }
                    if(gender.equals("Nam")) {
                        image = R.drawable.ic_man;
                    }else {
                        image = R.drawable.ic_woman;
                    }



                    Intent intent = new Intent(InsertActivity.this,MainActivity.class);
                    Bundle student = new Bundle();
                    student.putString("msv",msv);
                    student.putString("name",name);
                    student.putString("date",date);
                    student.putString("address",address);
                    student.putString("email",email);
                    student.putString("major",major);
                    student.putDouble("gpa",gpa);
                    student.putString("gender",gender);
                    student.putString("year",year);
                    student.putInt("image",image);
                   intent.putExtra("student",student);
                   startActivity(intent);
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}