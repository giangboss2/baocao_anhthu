package project.anhthu.travelinvietnam_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.MediaItem;

import project.anhthu.travelinvietnam_app.R;


public class VideoPlayerActivity extends AppCompatActivity {

    private PlayerView playerView;
    private ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        playerView = findViewById(R.id.player_view);
        initializePlayer();
    }

    private void initializePlayer() {
        player = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        String videoUrl = getIntent().getStringExtra("VIDEO_URL");
        MediaSource mediaSource = buildMediaSource(videoUrl);
        player.setMediaSource(mediaSource);
        player.prepare();
        player.play();
    }

    private MediaSource buildMediaSource(String url) {
        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, getString(R.string.app_name)));
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(url));
        return new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(mediaItem);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
    }
}