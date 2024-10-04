package android.assignment.prac2;

import android.assignment.prac2.Models.Staff;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Staff> staffs = new ArrayList<>();
    TextView edtData,edtStaffId,edtFullName,edtBirthDay,edtSalary;
    Button btnAdd;
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
        edtData = findViewById(R.id.edtData);
        edtStaffId = findViewById(R.id.edtStaffId);
        edtFullName = findViewById(R.id.edtStaffName);
        edtBirthDay = findViewById(R.id.edtStaffBirth);
        edtSalary = findViewById(R.id.edtStaffSalary);
        btnAdd = findViewById(R.id.btnAdd);
        if(checkListStaff(staffs)) {
            edtData.setText("No Result");
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String staffId = edtStaffId.getText()+"";
                    String staffName = edtFullName.getText()+"";
                    String staffBirthDay = edtBirthDay.getText()+"";
                    int staffSalary = Integer.parseInt(edtSalary.getText().toString());
                    if(checkAlreadyStaffId(staffs,staffId)) return;
                    Staff staff = new Staff();
                    staff.setStaffId(staffId);
                    staff.setFullName(staffName);
                    staff.setBirthDay(staffBirthDay);
                    staff.setSalary(staffSalary);
                    staffs.add(staff);
                    if(!checkListStaff(staffs)) {
                        String msg = "";
                        for (int i=0;i<staffs.size();i++) {
                            msg = msg + staffs.get(i).getStaffId()+"-"+staffs.get(i).getFullName()+"-"+staffs.get(i).getBirthDay()
                                    +"-"+staffs.get(i).getSalary()+"\n";
                        }
                        edtData.setText(msg);
                    }


                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Input Valid",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public Boolean checkListStaff(List<Staff> staffs) {
        if(staffs.size()==0) {
           return true;
        }return false;
    }

    public Boolean checkAlreadyStaffId(List<Staff> staffs,String id) {
        if(!checkListStaff(staffs)) {
            for(int i=0;i<staffs.size();i++) {
                if(id.equals(staffs.get(i).getStaffId())) {
                    Toast.makeText(MainActivity.this, "Id already exists", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        }
        return false;
    }
}