package tw.tcnr09.m0608b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0608B extends AppCompatActivity {
      private Button b001;
      private TextView t001;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0608b);
            setViewComponent();
      }

      private void setViewComponent() {
            b001 = (Button) findViewById(R.id.m0608b_b001);

            t001 = (TextView) findViewById(R.id.m0608b_t001);

            b001.setOnClickListener(b001On);
      }

      private View.OnClickListener b001On = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String ans = getString(R.string.m0608b_t001);

                  for (int i = 1; i < 21; i++) {
                        String idName = "m0608b_chb" + String.format("%02d", i);//String.format格式化"%02d"為顯示兩位(02)整數字(d)，自動補0
                        int resID = getResources().getIdentifier(idName, "id", getPackageName());
                        CheckBox chb = (CheckBox) findViewById(resID);
                        if (chb.isChecked()) ans += chb.getText().toString() + " ";
                  }

                  t001.setText(ans);
            }
      };
}