package tw.tcnr09.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity {

    private Button b001;
    private TextView ans01;
    private RadioGroup rb01, rb02;//RaidoGroup
    private RadioButton rb021, rb022, rb023;//RadioButton

    private  int debuglog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);
        setupViewComponent();
    }

    private void setupViewComponent() {
        //接收傳遞來的參數
        Intent intent = this.getIntent();
        String str = intent.getStringExtra("class_tittle");
        this.setTitle(str);
        //接收參數結束
        b001 = (Button) findViewById(R.id.m0502_b001);
        ans01 = (TextView) findViewById(R.id.m0502_f000);

        rb01 = (RadioGroup) findViewById(R.id.m0502_r001);//性別
        rb02 = (RadioGroup) findViewById(R.id.m0502_r002);//年齡

        rb021 = (RadioButton) findViewById(R.id.m0502_r002a);
        rb022 = (RadioButton) findViewById(R.id.m0502_r002b);
        rb023 = (RadioButton) findViewById(R.id.m0502_r002c);

        rb01.setOnCheckedChangeListener(rb01On);//性別改變
        b001.setOnClickListener(b001On);
    }

    private RadioGroup.OnCheckedChangeListener rb01On = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int x) {
            switch (x) {//從上面中的x取值
                case R.id.m0502_r001a://點男性，並設定對應的顯示字串
                    rb021.setText(getString(R.string.m0502_r002aa));
                    rb022.setText(getString(R.string.m0502_r002ab));
                    rb023.setText(getString(R.string.m0502_r002ac));
                    break;//中斷跳出
                case R.id.m0502_r001b://點女性，並設定對應的顯示字串
                    rb021.setText(getString(R.string.m0502_r002ba));
                    rb022.setText(getString(R.string.m0502_r002bb));
                    rb023.setText(getString(R.string.m0502_r002bc));
                    break;//中斷跳出
            }
        }
    };

    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strsug = getString(R.string.m0502_f000);
            int ichksex = rb01.getCheckedRadioButtonId();

            switch (ichksex) {
                case R.id.m0502_r001a://男
                    switch (rb02.getCheckedRadioButtonId()) {//從rb02群組RaidoGroup的三個按鈕中選取哪個？
                        case R.id.m0502_r002a://選取第一個按鈕
                            strsug += getString(R.string.m0502_f001);
                            break;
                        case R.id.m0502_r002b:
                            strsug += getString(R.string.m0502_f002);
                            break;
                        case R.id.m0502_r002c:
                            strsug += getString(R.string.m0502_f003);
                            break;
                    }
                    break;
                case R.id.m0502_r001b://女
                    switch (rb02.getCheckedRadioButtonId()) {//從rb02群組RaidoGroup的三個按鈕中選取哪個？
                        case R.id.m0502_r002a:
                            strsug += getString(R.string.m0502_f004);
                            break;
                        case R.id.m0502_r002b:
                            strsug += getString(R.string.m0502_f005);
                            break;
                        case R.id.m0502_r002c:
                            strsug += getString(R.string.m0502_f006);
                            break;
                    }
                    break;
            }

            ans01.setText(strsug);//輸出
        }
    };

}