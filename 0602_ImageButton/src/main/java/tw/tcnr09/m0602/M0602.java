package tw.tcnr09.m0602;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0602 extends AppCompatActivity {
      
      private TextView  s001, f000;
      private String player_select, com_select,ans;
      private ImageView c001;
      private ImageButton b001,b002,b003;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0602);

            setupViewComponent();
      }

      private void setupViewComponent() {
            c001 = (ImageView) findViewById(R.id.m0602_c001);
            s001 = (TextView) findViewById(R.id.m0602_s001);
            f000 = (TextView) findViewById(R.id.m0602_f000);

            b001 = (ImageButton) findViewById(R.id.m0602_b001);
            b002 = (ImageButton) findViewById(R.id.m0602_b002);
            b003 = (ImageButton) findViewById(R.id.m0602_b003);

            b001.setOnClickListener(buttonOn);
            b002.setOnClickListener(buttonOn);
            b003.setOnClickListener(buttonOn);
      }

      private View.OnClickListener buttonOn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  int iplayer = 0;
                  int icomp = (int) (Math.random() * 3); // 0- scissors, 1 - rock, 2 - papper.

                  switch (view.getId()) {
                        case R.id.m0602_b001://玩家選剪刀
                              switch (icomp) {
                                    case 0:
                                          c001.setImageResource(R.drawable.scissors);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f003);
                                          f000.setTextColor(Color.YELLOW);
                                          break;
                                    case 1:
                                          c001.setImageResource(R.drawable.stone);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f002);
                                          f000.setTextColor(Color.RED);
                                          break;
                                    case 2:
                                          c001.setImageResource(R.drawable.net);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f001);
                                          f000.setTextColor(Color.GREEN);
                                          break;
                              }
                              player_select = getString(R.string.m0602_s001) + getString(R.string.scissor);
                              break;
                        case R.id.m0602_b002://玩家選石頭
                              switch (icomp) {
                                    case 0:
                                          c001.setImageResource(R.drawable.scissors);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f001);
                                          f000.setTextColor(Color.GREEN);
                                          break;
                                    case 1:
                                          c001.setImageResource(R.drawable.stone);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f003);
                                          f000.setTextColor(Color.YELLOW);
                                          break;
                                    case 2:
                                          c001.setImageResource(R.drawable.net);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f002);
                                          f000.setTextColor(Color.RED);
                                          break;
                              }
                              player_select = getString(R.string.m0602_s001) + getString(R.string.rock);
                              break;
                        case R.id.m0602_b003://玩家選布
                              switch (icomp) {
                                    case 0:
                                          c001.setImageResource(R.drawable.scissors);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f002);
                                          f000.setTextColor(Color.RED);
                                          break;
                                    case 1:
                                          c001.setImageResource(R.drawable.stone);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f001);
                                          f000.setTextColor(Color.GREEN);
                                          break;
                                    case 2:
                                          c001.setImageResource(R.drawable.net);
                                          ans = getString(R.string.m0602_f000)+getString(R.string.m0602_f003);
                                          f000.setTextColor(Color.YELLOW);
                                          break;
                              }
                              player_select = getString(R.string.m0602_s001) + getString(R.string.papper);
                              break;
                  }
                  //--------------------------------
                  s001.setText(player_select);

                  f000.setText(ans);
            }
      };

//      private String check(int player, int com) {
//            int icheck;
//
//            if (player == com)
//                  return getString(R.string.m0602_f003);
//
//            if ((player == 0 && com == 2)||(player == 2 && com == 0))
//                  icheck = Math.min(player, com);
//            else
//                  icheck = Math.max(player, com);
//
//            if (player == icheck)
//                  return getString(R.string.m0602_f001);
//            else
//                  return getString(R.string.m0602_f002);
//      }
}