package tw.tcnr09.m0601;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class M0601 extends AppCompatActivity {

      private TextView c001, s001, f000;
      private Button b001, b002, b003;
      private String player_select, com_select,ans;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0601);

            setupViewComponent();
      }

      private void setupViewComponent() {
            c001 = (TextView) findViewById(R.id.m0601_c001);
            s001 = (TextView) findViewById(R.id.m0601_s001);
            f000 = (TextView) findViewById(R.id.m0601_f000);

            b001 = (Button) findViewById(R.id.m0601_b001);
            b002 = (Button) findViewById(R.id.m0601_b002);
            b003 = (Button) findViewById(R.id.m0601_b003);

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
                        case R.id.m0601_b001://玩家選剪刀
                              switch (icomp) {
                                    case 0:
                                          com_select=  getString(R.string.scissor);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f003);
                                          break;
                                    case 1:
                                          com_select= getString(R.string.rock);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f002);
                                          break;
                                    case 2:
                                          com_select=  getString(R.string.papper);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f001);
                                          break;
                              }
                              player_select = getString(R.string.m0601_s001) + getString(R.string.scissor);
                              break;
                        case R.id.m0601_b002://玩家選石頭
                              switch (icomp) {
                                    case 0:
                                          com_select=  getString(R.string.scissor);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f001);
                                          break;
                                    case 1:
                                          com_select= getString(R.string.rock);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f003);
                                          break;
                                    case 2:
                                          com_select=  getString(R.string.papper);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f002);
                                          break;
                              }
                              player_select = getString(R.string.m0601_s001) + getString(R.string.rock);
                              break;
                        case R.id.m0601_b003://玩家選布
                              switch (icomp) {
                                    case 0:
                                          com_select=  getString(R.string.scissor);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f002);
                                          break;
                                    case 1:
                                          com_select= getString(R.string.rock);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f001);
                                          break;
                                    case 2:
                                          com_select=  getString(R.string.papper);
                                          ans = getString(R.string.m0601_f000)+getString(R.string.m0601_f003);
                                          break;
                              }
                              player_select = getString(R.string.m0601_s001) + getString(R.string.papper);
                              break;
                  }
                  //--------------------------------
                  s001.setText(player_select);
                  c001.setText(com_select);
                  f000.setText(ans);
            }
      };

//      private String check(int player, int com) {
//            int icheck;
//
//            if (player == com)
//                  return getString(R.string.m0601_f003);
//
//            if ((player == 0 && com == 2)||(player == 2 && com == 0))
//                  icheck = Math.min(player, com);
//            else
//                  icheck = Math.max(player, com);
//
//            if (player == icheck)
//                  return getString(R.string.m0601_f001);
//            else
//                  return getString(R.string.m0601_f002);
//      }
}