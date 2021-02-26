package com.hammer67.multiplevideoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmt.dev.videoplayer.VideoPlayerRecyclerView;
import edmt.dev.videoplayer.adapter.VideoPlayerRecyclerAdapter;
import edmt.dev.videoplayer.model.MediaObject;
import edmt.dev.videoplayer.utils.VerticalSpacingItemDecorator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.video_player)
    VideoPlayerRecyclerView video_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        init();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        video_player.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(10);
        video_player.addItemDecoration(verticalSpacingItemDecorator);

        ArrayList<MediaObject> sourceVideo = new ArrayList<>(sampleVideoList());
        video_player.setMediaObjects(sourceVideo);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(sourceVideo, initGlide());
        video_player.setAdapter(adapter);
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this).setDefaultRequestOptions(options);
    }

    private List<MediaObject> sampleVideoList() {
        return Arrays.asList(
                new MediaObject(
                        "Big Buck Bunny",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                        "https://www.google.com/imgres?imgurl=https%3A%2F%2Fwallpapercave.com%2Fwp%2Fwp4752796.jpg&imgrefurl=https%3A%2F%2Fwallpapercave.com%2Fbig-buck-bunny-wallpapers&tbnid=akqtBLVUR_o04M&vet=12ahUKEwi52O-sn4bvAhUJQcAGHTzTBe4QMygXegUIARC0AQ..i&docid=5goZqdDUmlu0LM&w=1920&h=1080&q=images%2FBig%20Buck%20Bunny.jpg&ved=2ahUKEwi52O-sn4bvAhUJQcAGHTzTBe4QMygXegUIARC0AQ",
                        "Una pelicula amimada para los ifantes"),

                new MediaObject(
                        "Elephant Dream",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                        "data:image/jpeg;base64,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",
                        "Una pelicula amimada para los ifantes"),

                new MediaObject(
                        "For Bigger Escape",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJjDyxUnEgsDpvy403f3_yd9e8kGEJxCeXZg&usqp=CAU",
                        "Una pelicula amimada para los ifantes"),

                new MediaObject(
                        "Subaru Outback On Street And Dirt",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg",
                        "Una pelicula amimada para los ifantes"),

                new MediaObject(
                        "Volkswagen GTI Review",
                        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
                        "images/VolkswagenGTIReview.jpg",
                        "Una pelicula amimada para los ifantes")
        );
    }
}