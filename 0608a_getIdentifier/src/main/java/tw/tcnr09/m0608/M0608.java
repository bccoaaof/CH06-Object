package tw.tcnr09.m0608;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class M0608 extends AppCompatActivity {

      private EditText num1;
      private double n1 = 0;
      private String s = "S"; //用來判斷+-*/
      private DecimalFormat nf;
      private TextView show;
      private double nn;
      private double n2 = 0;
      private String se = "";
      private String st = "";
      private Boolean e_ok = true;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0608);
            setupViewComponent();
      }

      private void setupViewComponent() {
            num1 = (EditText) findViewById(R.id.m0608_e001);
            show = (TextView) findViewById(R.id.m0608_show);

//        clearOnClick.onClick(null);

            nf = new DecimalFormat("0.0000");
            //-----巨集執行----
            for (int i = 0; i < 18; i++) {
                  String idName = "m0608_b0" + String.format("%02d", i);
                  int resID = getResources().getIdentifier(idName, "id", getPackageName());

                  Button btn = ((Button) findViewById(resID));
                  if (i < 11) btn.setOnClickListener(numberOnClick);
                  if (i > 10 && i < 15) btn.setOnClickListener(calOnClick);
                  if (i == 15) btn.setOnClickListener(equalOnClick);
                  if (i == 16) btn.setOnClickListener(delOnClick);
                  if (i == 17) btn.setOnClickListener(clearOnClick);
            }
            num1.setText("");
            show.setText("");
      }


      private Button.OnClickListener numberOnClick = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String keyin = num1.getText().toString();
                  switch (v.getId()) {
                        case R.id.m0608_b000:
                              num1.setText(keyin + "0");
                              break;
                        case R.id.m0608_b001:
                              num1.setText(keyin + "1");
                              break;
                        case R.id.m0608_b002:
                              num1.setText(keyin + "2");
                              break;
                        case R.id.m0608_b003:
                              num1.setText(keyin + "3");
                              break;
                        case R.id.m0608_b004:
                              num1.setText(keyin + "4");
                              break;
                        case R.id.m0608_b005:
                              num1.setText(keyin + "5");
                              break;
                        case R.id.m0608_b006:
                              num1.setText(keyin + "6");
                              break;
                        case R.id.m0608_b007:
                              num1.setText(keyin + "7");
                              break;
                        case R.id.m0608_b008:
                              num1.setText(keyin + "8");
                              break;
                        case R.id.m0608_b009:
                              num1.setText(keyin + "9");
                              break;
                        case R.id.m0608_b010:
                              num1.setText(keyin + ".");
                              break;
                  }
            }
      };
      ////-----------修正 1-1-1=-1
      private View.OnClickListener calOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  try {
                        if (num1.getText().toString().equals("") && v.getId() == R.id.m0608_b012) {
                              num1.setText("-");
                        } else {

                              //-----------進行執行中的運算----------//
                              nn = Double.parseDouble(num1.getText().toString());
                              int a = 0;
//                u_Calculation(nn);
                              if (s.equals("S")) n1 = nn;
                              u_Calculation(nn);
                              num1.setText("");
                              switch (v.getId()) {
                                    case R.id.m0608_b011:
                                          s = "P";
                                          show.setText(getString(R.string.m0608_b011));
                                          break;
                                    case R.id.m0608_b012:
                                          s = "M";
                                          show.setText(getString(R.string.m0608_b012));
                                          break;
                                    case R.id.m0608_b013:
                                          s = "X";
                                          show.setText(getString(R.string.m0608_b013));
                                          break;
                                    case R.id.m0608_b014:
                                          s = "D";
                                          show.setText(getString(R.string.m0608_b014));
                                          break;
                              }
                        }
                  } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
                  }
            }
      };
      //------------------------------------------------------

      private void u_Calculation(double in_nn) {
            if (s.equals("P")) n1 += in_nn; //上一個運算符號
            if (s.equals("M")) n1 -= in_nn;
            if (s.equals("X")) n1 *= in_nn;
            if (s.equals("D")) n1 /= in_nn;
      }

      private View.OnClickListener equalOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if (num1.getText().toString().trim().length() != 0) {
                        n2 = Double.parseDouble(num1.getText().toString());
                        DecimalFormat nf = new DecimalFormat("0.0000");
                        u_Calculation(n2);
                        num1.setText(nf.format(n1));
                        show.setText(getString(R.string.m0608_b015));
                        n1 = 0;
                        nn = 0;
                  }
            }
      };
      //-----------------------可連續計算-------------------
//private View.OnClickListener equalOnClick = new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
////            Toast.makeText(getApplicationContext(), Double.toString(n1), Toast.LENGTH_LONG).show();
//        if (num1.getText().toString().trim().length() != 0) {
//            if (!se.equals("1")){
//                n2 = Double.parseDouble((num1.getText().toString()));
//
//            } else{
//                s=st;
//
//            }
//
//            nf = new DecimalFormat("0.0000");
//            u_Calculation(n2);
//            num1.setText(nf.format(n1));
////                if (s.equals("")) num1.setText(nf.format(n2));
////                num1.setText("");
//            //n1 = 0;
//            se = "1";
//            st=s;
//            s="E";
//            show.setText(getString(R.string.m0608_b015));
////                num1.setText(ans.getText());
////                num1.setText("");
////                n1 = 0;
//        }
//    }
//};
      //----------------------------------------

      private View.OnClickListener delOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  num1.setText("");
            }
      };
      private Button.OnClickListener clearOnClick = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                  n1 = 0;
                  num1.setText("");
                  show.setText("");
                  if (!s.equals("E")) {  //按= 狀態 不清除結果欄
                        num1.setText("");
                        show.setText("");
                  }
                  s = "S";  //設成起始狀態
            }
      };
      //------------------end---------------
}





//package tw.tcnr09.m0608;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.text.DecimalFormat;
//
//public class M0608 extends AppCompatActivity {
//
//      private EditText e001;
//      private TextView t001;
////      private Button btn0, btn1, btn2, btn3, btn4,
////                btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12,
////                btn13, btn14, btn15;
//
//      private String s;
//      private double nnn, nn1=0, nn2;
//      private DecimalFormat nnf;
//
//
//      @Override
//      protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.m0608);
//
//            setupViewComponent();
//      }
//
//      private void setupViewComponent() {
//
//            e001 = (EditText) findViewById(R.id.m0608_e001);
//            t001 = (TextView) findViewById(R.id.m0608_show);
//
//            //格式化，設定為顯示小數點後四位
//            nnf = new DecimalFormat("0.0000");
//
//            for (int i = 0; i < 18; i++) {
//                  //%d十進位，2位數，0位數不足補0
//                  String idName = "m0608_b0" + String.format("%02d", i);
//                  //getIdentifier()方法得到ID，也就是R.id.(物件名稱)
//                  //下面的參數"id"可換成"string"或"drawable"或其他
//                  int resID = getResources().getIdentifier(idName, "id", getPackageName());
//
//                  Button btn = (Button) findViewById(resID);
//
//                  if (i < 11) btn.setOnClickListener(numberOnClick);
//
//                  if (i > 10 && i < 15) btn.setOnClickListener(calOnClick);
//
//                  if (i == 15) btn.setOnClickListener(equalOnClick);
//
//                  if (i == 16) btn.setOnClickListener(delOnClick);
//
//                  if (i == 17) btn.setOnClickListener(clearOnClick);
//
//            }
//            //
//            e001.setText("");
//            t001.setText("");
//      }
//
//      private View.OnClickListener numberOnClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  String keyin = e001.getText().toString();
//
//                  switch (v.getId()) {
//                        case R.id.m0608_b000:
//                              e001.setText(keyin + "0");
//                              break;
//                        case R.id.m0608_b001:
//                              e001.setText(keyin + "1");
//                              break;
//                        case R.id.m0608_b002:
//                              e001.setText(keyin + "2");
//                              break;
//                        case R.id.m0608_b003:
//                              e001.setText(keyin + "3");
//                              break;
//                        case R.id.m0608_b004:
//                              e001.setText(keyin + "4");
//                              break;
//                        case R.id.m0608_b005:
//                              e001.setText(keyin + "5");
//                              break;
//                        case R.id.m0608_b006:
//                              e001.setText(keyin + "6");
//                              break;
//                        case R.id.m0608_b007:
//                              e001.setText(keyin + "7");
//                              break;
//                        case R.id.m0608_b008:
//                              e001.setText(keyin + "8");
//                              break;
//                        case R.id.m0608_b009:
//                              e001.setText(keyin + "9");
//                              break;
//                        case R.id.m0608_b010:
//                              e001.setText(keyin + ".");
//                              break;
//                  }
//            }
//      };
//
//
//      private View.OnClickListener calOnClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                  try {
//                        if (e001.getText().toString().equals("") && v.getId() == R.id.m0608_b012) {
//                              e001.setText("-");
//                        } else {
//
//                              //-----------進行執行中的運算----------//
//                              nnn = Double.parseDouble(e001.getText().toString());
//                              int a = 0;
////                u_Calculation(nn1);
//                              if (s.equals("S")) nn1 = nnn;
//                              u_Calculation(nnn);
//                              e001.setText("");
//                              switch (v.getId()) {
//                                    case R.id.m0608_b011:
//                                          s = "P";
//                                          t001.setText(getString(R.string.m0608_b011));
//                                          break;
//                                    case R.id.m0608_b012:
//                                          s = "M";
//                                          t001.setText(getString(R.string.m0608_b012));
//                                          break;
//                                    case R.id.m0608_b013:
//                                          s = "X";
//                                          t001.setText(getString(R.string.m0608_b013));
//                                          break;
//                                    case R.id.m0608_b014:
//                                          s = "D";
//                                          t001.setText(getString(R.string.m0608_b014));
//                                          break;
//                              }
//                        }
//                  } catch (Exception e) {
//                        Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
//                  }
//////
//////                  e001.setText("");
//////
//////                  switch (v.getId()) {
//////                        case R.id.m0608_b011:
//////                              s = "P";
//////                              break;
//////                        case R.id.m0608_b012:
//////                              s = "M";
//////                              break;
//////                        case R.id.m0608_b013:
//////                              s = "X";
//////                              break;
//////                        case R.id.m0608_b014:
//////                              s = "D";
//////                              break;
//////                  }
//            }
//      };
//
//      private void u_Calculation(double in_nn) {
//            if (s.equals("P")) nn1 += in_nn; //上一個運算符號
//            if (s.equals("M")) nn1 -= in_nn;
//            if (s.equals("X")) nn1 *= in_nn;
//            if (s.equals("D")) nn1 /= in_nn;
//      }
//
//      private View.OnClickListener equalOnClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  //trim()剪刀？剪文字？
////                  if (e001.getText().toString().trim().length() != 0) {
////                        nn2 = Double.parseDouble(e001.getText().toString());
////
////                        if (s.equals("P")) t001.setText(nnf.format(nn1 + nn2));
////                        if (s.equals("M")) t001.setText(nnf.format(nn1 - nn2));
////                        if (s.equals("X")) t001.setText(nnf.format(nn1 * nn2));
////                        if (s.equals("D")) t001.setText(nnf.format(nn1 / nn2));
////
////                        e001.setText("");
////                        nn1 = 0;
////
////                  } else {
////                        Toast.makeText(getApplicationContext(), getString(R.string.m0608_error), Toast.LENGTH_LONG).show();
////                  }
//                  if (e001.getText().toString().trim().length() != 0) {
//                        nn2 = Double.parseDouble(e001.getText().toString());
//
//                        u_Calculation(nn2);
//                        e001.setText(nnf.format(nn1));
//                        t001.setText(getString(R.string.m0608_b015));
//                        nn1 = 0;
//                        nnn = 0;
//                  }
//
//            }
//      };
//
//      private View.OnClickListener delOnClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  e001.setText("");
//            }
//      };
//      private Button.OnClickListener clearOnClick = new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  nn1 = 0;
//                  e001.setText("");
//                  t001.setText("");
//                  if (!s.equals("E")) {  //按= 狀態 不清除結果欄
//                        e001.setText("");
//                        t001.setText("");
//                  }
//                  s = "S";  //設成起始狀態
//            }
//      };
//
//
//}