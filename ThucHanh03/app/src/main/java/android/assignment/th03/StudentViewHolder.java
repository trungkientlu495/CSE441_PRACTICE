package android.assignment.th03;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView tvId,tvName,tvGPA;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView5);
        tvId = itemView.findViewById(R.id.tvId);
        tvName = itemView.findViewById(R.id.tvName);
        tvGPA = itemView.findViewById(R.id.tvGPA);
    }



    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTvGPA() {
        return tvGPA;
    }

    public void setTvGPA(TextView tvGPA) {
        this.tvGPA = tvGPA;
    }

    public TextView getTvId() {
        return tvId;
    }

    public void setTvId(TextView tvId) {
        this.tvId = tvId;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }
}
