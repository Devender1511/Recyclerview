package in.vcaretechs.mrecyclerview;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>
{
    private ArrayList<Course> android;
    private Context context;


    public CourseAdapter(ArrayList<Course> android, Context context) {
        this.android = android;
        this.context=context;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dashboard, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int positon)
    {
        final Course c = android.get(positon);

        holder.tv_name.setText(c.getCourse());

        Glide.with(context).load(c.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        private TextView tv_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_course);
            tv_name = itemView.findViewById(R.id.text_course);

        }
    }
}
