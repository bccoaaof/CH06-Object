package tw.sgft.m0608;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class M0608 extends AppCompatActivity {

      private RelativeLayout layout;
      private ArrayList<Button> buttons = new ArrayList<Button>();

      private EditText e001;
      private TextView t002;
      private Button btn0, btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12,
                btn13, btn14, btn15;

      private String s;
      private double nn1, nn2;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0608);

            setupViewComponent();
      }

      private void setupViewComponent() {
            layout = (RelativeLayout) findViewById(R.id.m0608_layout);

            e001 = (EditText) findViewById(R.id.m0608_t001);
            t002 = (TextView) findViewById(R.id.m0608_t002);

            btn0 = (Button) findViewById(R.id.m0608_b000);
            btn1 = (Button) findViewById(R.id.m0608_b001);
            btn2 = (Button) findViewById(R.id.m0608_b002);
            btn3 = (Button) findViewById(R.id.m0608_b003);
            btn4 = (Button) findViewById(R.id.m0608_b004);
            btn5 = (Button) findViewById(R.id.m0608_b005);
            btn6 = (Button) findViewById(R.id.m0608_b006);
            btn7 = (Button) findViewById(R.id.m0608_b007);
            btn8 = (Button) findViewById(R.id.m0608_b008);
            btn9 = (Button) findViewById(R.id.m0608_b009);
            btn10 = (Button) findViewById(R.id.m0608_b010); //.

            btn11 = (Button) findViewById(R.id.m0608_b011);// +
            btn12 = (Button) findViewById(R.id.m0608_b012);// -
            btn13 = (Button) findViewById(R.id.m0608_b013);// *
            btn14 = (Button) findViewById(R.id.m0608_b014);// /
            btn15 = (Button) findViewById(R.id.m0608_b015); // =


            btn0.setOnClickListener(numberOnClick);
            btn1.setOnClickListener(numberOnClick);
            btn2.setOnClickListener(numberOnClick);
            btn3.setOnClickListener(numberOnClick);
            btn4.setOnClickListener(numberOnClick);
            btn5.setOnClickListener(numberOnClick);
            btn6.setOnClickListener(numberOnClick);
            btn7.setOnClickListener(numberOnClick);
            btn8.setOnClickListener(numberOnClick);
            btn9.setOnClickListener(numberOnClick);
            btn10.setOnClickListener(numberOnClick);

            btn11.setOnClickListener(calOnClick);
            btn12.setOnClickListener(calOnClick);
            btn13.setOnClickListener(calOnClick);
            btn14.setOnClickListener(calOnClick);

            btn15.setOnClickListener(equalOnClick);
      }

      private View.OnClickListener numberOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String keyin = e001.getText().toString();

                  switch (v.getId()) {
                        case R.id.m0608_b000:
                              e001.setText(keyin + "0");
                              break;
                        case R.id.m0608_b001:
                              e001.setText(keyin + "1");
                              break;
                        case R.id.m0608_b002:
                              e001.setText(keyin + "2");
                              break;
                        case R.id.m0608_b003:
                              e001.setText(keyin + "3");
                              break;
                        case R.id.m0608_b004:
                              e001.setText(keyin + "4");
                              break;
                        case R.id.m0608_b005:
                              e001.setText(keyin + "5");
                              break;
                        case R.id.m0608_b006:
                              e001.setText(keyin + "6");
                              break;
                        case R.id.m0608_b007:
                              e001.setText(keyin + "7");
                              break;
                        case R.id.m0608_b008:
                              e001.setText(keyin + "8");
                              break;
                        case R.id.m0608_b009:
                              e001.setText(keyin + "9");
                              break;
                        case R.id.m0608_b010:
                              e001.setText(keyin + ".");
                              break;
                  }
            }
      };


      private View.OnClickListener calOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  try {
                        nn1 = Double.parseDouble(e001.getText().toString());
                  } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
                  }

//                  nn = Double.parseDouble(e001.getText().toString());
                  e001.setText("");

                  switch (v.getId()) {
                        case R.id.m0608_b011:
                              s = "P";
                              break;
                        case R.id.m0608_b012:
                              s = "M";
                              break;
                        case R.id.m0608_b013:
                              s = "X";
                              break;
                        case R.id.m0608_b014:
                              s = "D";
                              break;
                  }
            }
      };

      private View.OnClickListener equalOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  //trim()剪刀？剪文字？
                  if (e001.getText().toString().trim().length() != 0) {
                        nn2 = Double.parseDouble(e001.getText().toString());
                        //格式化，設定為顯示小數點後四位
                        DecimalFormat nnf = new DecimalFormat("0.0000");

                        if (s.equals("P")) t002.setText(nnf.format(nn1 + nn2));
                        if (s.equals("M")) t002.setText(nnf.format(nn1 - nn2));
                        if (s.equals("X")) t002.setText(nnf.format(nn1 * nn2));
                        if (s.equals("D")) t002.setText(nnf.format(nn1 / nn2));

                        e001.setText("");
                        nn1 = 0;

                  } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.m0608_error), Toast.LENGTH_LONG).show();
                  }

            }
      };

      void cal() {
            
      }

}