package android.assignment.prac03.Adater;

import android.annotation.SuppressLint;
import android.assignment.prac03.Model.ConuntryInfo;
import android.assignment.prac03.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdater extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ConuntryInfo> conuntrys;

    public CountryAdater(Context context, List<ConuntryInfo> conuntrys, int layout) {
        this.context = context;
        this.conuntrys = conuntrys;
        this.layout = layout;
    }



    @Override
    public int getCount() {
        return conuntrys.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ConuntryInfo country = conuntrys.get(i);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        ImageView imageView = view.findViewById(R.id.image);
        tvName.setText(country.getCountryName());
        tvDescription.setText(country.getDescription());
        imageView.setImageResource(country.getImage());
        return view;
    }
}
