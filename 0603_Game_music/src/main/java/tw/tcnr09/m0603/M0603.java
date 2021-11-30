package tw.tcnr09.m0603;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0603 extends AppCompatActivity {

      private TextView s001, f000;
      private String player_select, ans;
      private ImageView c001;
      private ImageButton b001, b002, b003;
      private MediaPlayer startmusic, mediaWin, mediaLose, mediaDraw, endmusic;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0603);

            setupViewComponent();
      }

      private void setupViewComponent() {
            c001 = (ImageView) findViewById(R.id.m0603_c001);
            s001 = (TextView) findViewById(R.id.m0603_s001);
            f000 = (TextView) findViewById(R.id.m0603_f000);

            b001 = (ImageButton) findViewById(R.id.m0603_b001);
            b002 = (ImageButton) findViewById(R.id.m0603_b002);
            b003 = (ImageButton) findViewById(R.id.m0603_b003);

            // --開啟片頭音樂-----
            //startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
            // startmusic.start();

            //兩個參數，是誰在用？,資料來源，宣告音樂
            startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//            startmusic = MediaPlayer.create(getApplication(), R.raw.goodnight);
            //使用宣告的音樂
            startmusic.start();

            //宣告依情況撥放的音樂
            mediaWin = MediaPlayer.create(getApplication(), R.raw.vctory);
            mediaLose = MediaPlayer.create(getApplication(), R.raw.lose);
            mediaDraw = MediaPlayer.create(getApplication(), R.raw.haha);

            endmusic = MediaPlayer.create(getApplication(), R.raw.goodnight);

            b001.setOnClickListener(buttonOn);
            b002.setOnClickListener(buttonOn);
            b003.setOnClickListener(buttonOn);
      }

      private View.OnClickListener buttonOn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                  int icomp = (int) (Math.random() * 3); // 0- scissors, 1 - rock, 2 - papper.

                  switch (view.getId()) {
                        case R.id.m0603_b001://玩家選剪刀
                              switch (icomp) {
                                    case 0:
                                          c001.setImageResource(R.drawable.scissors);
                                          music(2);
                                          break;
                                    case 1:
                                          c001.setImageResource(R.drawable.stone);
                                          music(3);
                                          break;
                                    case 2:
                                          c001.setImageResource(R.drawable.net);
                                          music(1);
                                          break;
                              }
                              player_select = getString(R.string.m0603_s001) + getString(R.string.scissor);
                              break;
                        case R.id.m0603_b002://玩家選石頭
                              switch (icomp) {
                                    case 0:
                                          c001.setImageResource(R.drawable.scissors);
                                          music(1);
                                          break;
                                    case 1:
                                          c001.setImageResource(R.drawable.stone);
                                          music(2);
                                          break;
                                    case 2:
                                          c001.setImageResource(R.drawable.net);
                                          music(3);
                                          break;
                              }
                              player_select = getString(R.string.m0603_s001) + getString(R.string.rock);
                              break;
                        case R.id.m0603_b003://玩家選布
                              switch (icomp) {
                                    case 0:
                                          c001.setImageResource(R.drawable.scissors);
                                          music(3);
                                          break;
                                    case 1:
                                          c001.setImageResource(R.drawable.stone);
                                          music(1);
                                          break;
                                    case 2:
                                          c001.setImageResource(R.drawable.net);
                                          music(2);
                                          break;
                              }
                              player_select = getString(R.string.m0603_s001) + getString(R.string.papper);
                              break;
                  }
                  //--------------------------------
                  s001.setText(player_select);

                  f000.setText(ans);
            }
      };

      private void music(int i) {
            if (startmusic.isPlaying()) startmusic.stop();
            if (mediaWin.isPlaying()) mediaWin.pause();
            if (mediaLose.isPlaying()) mediaLose.pause();
            if (mediaDraw.isPlaying()) mediaDraw.pause();
            //1贏,2平,3輸
            switch (i) {
                  case 1:
                        mediaWin.start();
                        ans = getString(R.string.m0603_f000) + getString(R.string.m0603_f001);
                        f000.setTextColor(Color.GREEN);
                        break;
                  case 2:
                        mediaDraw.start();
                        ans = getString(R.string.m0603_f000) + getString(R.string.m0603_f003);
                        f000.setTextColor(Color.YELLOW);
                        break;
                  case 3:
                        mediaLose.start();
                        ans = getString(R.string.m0603_f000) + getString(R.string.m0603_f002);
                        f000.setTextColor(Color.RED);
                        break;
                  case 4:
                        endmusic.start();
                        break;
            }
      }

      @Override
      public void onBackPressed() {
//            super.onBackPressed();
            //執行結束，也就是onStop()
            this.finish();
      }

      //結束
      @Override
      protected void onStop() {
            super.onStop();
            if (startmusic.isPlaying()) startmusic.stop();
            music(4);
      }
}