package com.example.retrofit2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit2.R;
import com.example.retrofit2.bootstrap.APIClient;
import com.example.retrofit2.model.Post;
import com.example.retrofit2.resource.PostResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void listarPosts(View view){

        Retrofit retrofit = APIClient.getClient();

        PostResource postResource = retrofit.create(PostResource.class);

        Call<List<Post>> lista = postResource.get();
        lista.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                List<Post> posts = response.body();

                for (int i=0; i<posts.size(); i++){
                    Log.i("post", String.format("%d %s", i,posts.get(i).toString()));
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Toast.makeText(getApplication(), "Ocorreu um erro no serviço", Toast.LENGTH_LONG).show();

            }
        });


    }

}