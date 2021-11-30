package tw.tcnr09.m0607;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M0607 extends AppCompatActivity {

      //呼叫內部或外部程式
      private Intent intent = new Intent();//企圖
      private Button b001, b002, b003, b004, b005, b006, b007;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0607);

            setupViewComponent();
      }

      private void setupViewComponent() {
            b001 = (Button) findViewById(R.id.m0607_b001);
            b002 = (Button) findViewById(R.id.m0607_b002);
            b003 = (Button) findViewById(R.id.m0607_b003);
            b004 = (Button) findViewById(R.id.m0607_b004);
            b005 = (Button) findViewById(R.id.m0607_b005);
            b006 = (Button) findViewById(R.id.m0607_b006);
            b007 = (Button) findViewById(R.id.m0607_b007);

            b001.setOnClickListener(buttonOn);
            b002.setOnClickListener(buttonOn);
            b003.setOnClickListener(buttonOn);
            b004.setOnClickListener(buttonOn);
            b005.setOnClickListener(buttonOn);
            b006.setOnClickListener(buttonOn);
            b007.setOnClickListener(buttonOn);
      }

      private View.OnClickListener buttonOn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  switch (view.getId()) {
                        case R.id.m0607_b001:
                              //傳遞參數，先設定key,value方便接收
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0500));
                              intent.setClass(M0607.this, M0500.class);
                              break;
                        case R.id.m0607_b002:
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0501));
                              intent.setClass(M0607.this, M0501.class);
                              break;
                        case R.id.m0607_b003:
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0502));
                              intent.setClass(M0607.this, M0502.class);
                              break;
                        case R.id.m0607_b004:
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0504));
                              intent.setClass(M0607.this, M0504.class);
                              break;
                        case R.id.m0607_b005:
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0505));
                              intent.setClass(M0607.this, M0505.class);
                              break;
                        case R.id.m0607_b006:
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0604));
                              intent.setClass(M0607.this, M0604.class);
                              break;
                        case R.id.m0607_b007:
                              intent.putExtra("class_tittle", getString(R.string.m0000_b0606));
                              intent.setClass(M0607.this, M0606.class);
                              break;
                  }

                  startActivity(intent);
            }
      };
}