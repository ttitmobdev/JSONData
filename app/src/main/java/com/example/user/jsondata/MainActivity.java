package com.example.user.jsondata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.jsondata.Model.Item;
import com.example.user.jsondata.Model.Response;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private RecyclerView recyclerView;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = ApiUtils.getApi();
        recyclerView = findViewById(R.id.rec);
        adapter = new Adapter(new ArrayList<Item>(0), this, new Adapter.PostItemListener() {
                    @Override
                    public void onPostClick(long id) {
                        Toast.makeText(MainActivity.this,"POST ID IS "+id,Toast.LENGTH_LONG).show();
                    }
                });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers(){
        api.getAnswers().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()){
                    adapter.updateAnswers(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
