package in.vcaretechs.mrecyclerview;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import in.vcaretechs.mrecyclerview.Api.Api;
import in.vcaretechs.mrecyclerview.Api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Course> data;
    private CourseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyler);
        get_recycelrview();




    }

    private void get_recycelrview() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        loadJSON();

    }
    private void loadJSON() {
        Retrofit retrofit = RetrofitClient.getApiClient();
        final Api request = retrofit.create(Api.class);
        Call<BasicResponse> call = request.getcourse();

        call.enqueue(new Callback<BasicResponse>() {
            @Override
            public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                if (response.isSuccessful()) {
                    BasicResponse res = response.body();
                    data = new ArrayList<Course>(Arrays.asList(res.getCourses()));
                    adapter = new CourseAdapter(data, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<BasicResponse> call, Throwable t) {

            }
        });
    }

}
