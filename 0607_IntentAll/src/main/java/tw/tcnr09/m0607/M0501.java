package tw.tcnr09.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0501 extends AppCompatActivity {

    private Spinner s001;
    private EditText e001;
    private Button b001;
    private TextView ans01;
    private String sSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewComponent();
    }

    private void setupViewComponent() {
        //接收傳遞來的參數
        Intent intent = this.getIntent();
        String str = intent.getStringExtra("class_tittle");
        this.setTitle(str);
        //接收參數結束
        s001 = (Spinner) findViewById(R.id.m0501_s001);
        e001 = (EditText) findViewById(R.id.m0501_e001);
        b001 = (Button) findViewById(R.id.m0501_b001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);

        ArrayAdapter<CharSequence> adaperSexList =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.m0501_a001,
                        R.layout.spinner_item);
        s001.setAdapter(adaperSexList);

        //超過1個的物件所使用的
        //使用的位置
        //使用的資料來源
        //使用的樣式
        //這個例子分別為
        //此，存於Value中的m0501的StringArray，系統內建樣式
        //設置後讓s001使用
        s001.setOnItemSelectedListener(s001On);
        //設置讓soo1被按後的反應
        b001.setOnClickListener(b001On);
    }

    private AdapterView.OnItemSelectedListener s001On = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sSex = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strsug = getString(R.string.m0501_f000);

//  ------------------------------------------------------------------------------
            //檢查年齡是否輸入
            if (e001.getText().toString().length() > 0) {
                int iAge = Integer.parseInt(e001.getText().toString());

                if (sSex.equals(getString(R.string.chk01))) {
                    //男-------------男
                    //判斷年齡開始
                    if (iAge < 28) {
                        strsug += getString(R.string.m0501_f001);
                    } else if (iAge > 33) {
                        strsug += getString(R.string.m0501_f003);
                    } else {
                        strsug += getString(R.string.m0501_f002);
                    }
                    //判斷年齡結束
                } else {
                    //女-------------女
                    //判斷年齡開始
                    if (iAge < 25) {
                        strsug += getString(R.string.m0501_f001);
                    } else if (iAge > 30) {
                        strsug += getString(R.string.m0501_f003);
                    } else {
                        strsug += getString(R.string.m0501_f002);
                    }
                    //判斷年齡結束
                }

            } else {
                strsug = getString(R.string.nospace);
            }

// ------------------------------------------------------------------------------

            ans01.setText(strsug);//輸出
        }
    };
}