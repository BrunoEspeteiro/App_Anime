package com.example.brunopereira.app_anime.Activies;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.brunopereira.app_anime.R;

public class Anime_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_layout);

        //////////////////////////////escondendo a actionbar default


        getSupportActionBar().hide();

        /////////////////////////////Recuperando dados

        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String category = getIntent().getExtras().getString("anime_category");
        String rating = getIntent().getExtras().getString("anime_rating");
        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode");
        String image_url = getIntent().getExtras().getString("anime_image_url");

        /////////////////////////////////iniciando as views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtollbar_id);

        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_category = findViewById(R.id.aa_category);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView img = findViewById(R.id.aa_thumpnail);



        ////////////////////////////setando valores para views

        tv_name.setText(name);
        tv_studio.setText(studio);
        tv_category.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);


        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder
                (R.drawable.loading_shape).error(R.drawable.loading_shape);


        ///////////////////////EStando imagem usando o Glide

        Glide.with(this).load(image_url).apply(requestOptions).into(img);
    }
}
