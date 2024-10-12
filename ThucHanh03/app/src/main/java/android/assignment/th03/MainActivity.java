package android.assignment.th03;

import android.assignment.th03.Adater.StudentAdater;
import android.assignment.th03.Model.Student;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
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
        RecyclerView recyclerView = findViewById(R.id.rcv);
        List<Student> students = new ArrayList<>();

        students.add(new Student("Nghệ An","06/09/2003",
                "nguyentrungk495@gmail.com","Nam",3.9,"BDMN",
                "Nguyễn Trung Kiên", "CNTT","1",R.drawable.ic_man));
        students.add(new Student("Nghệ An","06/09/2003",
                "nguyentrungk495@gmail.com","Nam",3.9,"BDMN",
                "Nguyễn Trung Kiên", "CNTT","1",R.drawable.ic_man));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentAdater(this,students));
        ImageButton btnInsert = findViewById(R.id.btnInsert6);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });
        Intent intent1 = getIntent();
        if(intent1!=null) {
            try {
                intent1 = getIntent();
                Bundle bd = intent1.getBundleExtra("student");
                String msv = bd.getString("msv");
                String name = bd.getString("name");
                String date = bd.getString("date");
                String address = bd.getString("address");
                String email = bd.getString("email");
                String major = bd.getString("major");
                Double gpa = bd.getDouble("gpa");
                String gender = bd.getString("gender");
                String year = bd.getString("year");
                Integer image = bd.getInt("image");
                Student student = new Student();
                student.setId(msv);
                student.setFullName(name);
                student.setBirthDay(date);
                student.setAddress(address);
                student.setEmail(email);
                student.setMajor(major);
                student.setGpa(gpa);
                student.setGender(gender);
                student.setYear(year);
                student.setImage(image);
                students.add(student);
            }catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Insert error",Toast.LENGTH_SHORT).show();
            }
        }

    }
}