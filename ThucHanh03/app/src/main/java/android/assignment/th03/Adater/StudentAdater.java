package android.assignment.th03.Adater;

import android.assignment.th03.Model.Student;
import android.assignment.th03.R;
import android.assignment.th03.StudentViewHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdater extends RecyclerView.Adapter<StudentViewHolder> {
    private Context context;
    private List<Student> students;

    public StudentAdater(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.getTvId().setText(students.get(position).getId());
        holder.getTvName().setText(students.get(position).getFullName());
        holder.getTvGPA().setText(students.get(position).getGpa().toString());
//        if(students.get(position).getGender().equals("Nam")) {
            holder.getImageView().setImageResource(students.get(position).getImage());
//        }

    }
}
