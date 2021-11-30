package tw.tcnr09.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class M0500 extends AppCompatActivity {
      private Button b001;
      private TextView t003;
      private EditText e001;
      private DecimalFormat pondsFormat;//數值格式化，顯示到小數點後第五位
      private String ans;//儲存答案的字串變數
      //宣告變數
      //後宣告變數，有需要才宣告
      //有需求才宣告

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0500);
            setupViewcomponent();
            //自定義方法
      }

      private void setupViewcomponent() {
            //接收傳遞來的參數
            Intent intent = this.getIntent();
            String str = intent.getStringExtra("class_tittle");
            this.setTitle(str);
            //接收參數結束

            //定義自定義方法，設定配置碼
            e001 = (EditText) findViewById(R.id.m0500_e001);
            //定義輸入框，輸入公斤數值
            b001 = (Button) findViewById(R.id.m0500_b001);
            //定義按鈕
            t003 = (TextView) findViewById(R.id.m0500_t003);
            //定義顯示結果，顯示磅數值

            b001.setOnClickListener(b001On);
            //設定按下b001按鈕時會做的動作
      }

      private View.OnClickListener b001On = new View.OnClickListener() {
            //若b001按鈕被按會發生什麼事
            @Override
            public void onClick(View view) {
                  //DecimalFormat   pondsFormat = new DecimalFormat("0.00000");
                  pondsFormat = new DecimalFormat("0.00000");
                  //宣告數值格式化，顯示到小數點第5位
                  //(#.000000)功能：若數值為0.XXXXX則不顯示0

                  if (e001.getText().toString().length() > 0) {
                        ans = pondsFormat.format(Float.parseFloat(e001.getText().toString()) * 2.20462262);
                  } else {
                        ans = "";
                  }
                  //宣告if else建構式
                  //若未輸入數值，將顯示空白
                  //先判斷e001中字串長度是否大於0
                  //是則儲存正確計算結果在ans
                  //否則儲存空白在ans

                  t003.setText(ans);
                  //讓t003顯示儲存的字串
            }
      };
}