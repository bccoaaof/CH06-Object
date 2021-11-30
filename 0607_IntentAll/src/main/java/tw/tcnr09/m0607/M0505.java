package tw.tcnr09.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class M0505 extends AppCompatActivity {

      private Button b001, b002;
      private AutoCompleteTextView e001;
      private ArrayAdapter<String> adapAutoCompText;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0505);

            setViewComponent();
      }

      private void setViewComponent() {
            //接收傳遞來的參數
            Intent intent = this.getIntent();
            String str = intent.getStringExtra("class_tittle");
            this.setTitle(str);
            //接收參數結束
            b001 = (Button) findViewById(R.id.m0505_b001);
            b002 = (Button) findViewById(R.id.m0505_b002);

            e001 = (AutoCompleteTextView) findViewById(R.id.m0505_a001);


//            adapAutoCompText = new ArrayAdapter<String>(this,
//                      android.R.layout.simple_dropdown_item_1line);

            //樣式
            adapAutoCompText = new ArrayAdapter<String>(this,
                      android.R.layout.simple_dropdown_item_1line);

            b001.setOnClickListener(buttonOn);
            b002.setOnClickListener(buttonOn);

            e001.setAdapter(adapAutoCompText);
      }

      private View.OnClickListener buttonOn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  //用getId()判斷哪個按鈕被按
                  //用switch判斷決定方法
                  switch (view.getId()) {
                        case R.id.m0505_b001:
                              //抓取輸入文字
                              String s = e001.getText().toString();
                              //將文字丟進樣式內
                              adapAutoCompText.add(s);
                              e001.setText("");
                              break;
                        case R.id.m0505_b002:
                              //將樣式內的內容全部清空
                              adapAutoCompText.clear();
                              e001.setText("");
                              break;
                  }
            }
      };
}