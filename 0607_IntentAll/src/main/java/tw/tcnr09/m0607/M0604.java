package tw.tcnr09.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0604 extends AppCompatActivity {

      private Button b001, b002, b003, b004;
      private Toast toast = null;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0604);
            setupViewComponent();
      }

      private void setupViewComponent() {
            //接收傳遞來的參數
            Intent intent = this.getIntent();
            String str = intent.getStringExtra("class_tittle");
            this.setTitle(str);
            //接收參數結束
            b001 = (Button) findViewById(R.id.m0604_b001);
            b002 = (Button) findViewById(R.id.m0604_b002);
            b003 = (Button) findViewById(R.id.m0604_b003);
            b004 = (Button) findViewById(R.id.m0604_b004);

            b001.setOnClickListener(buttonOn);
            b002.setOnClickListener(buttonOn);
            b003.setOnClickListener(buttonOn);
            b004.setOnClickListener(buttonOn);
      }

      private View.OnClickListener buttonOn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  toast = null;
                  switch (view.getId()) {
                        case R.id.m0604_b001:
                              Toast.makeText(getApplicationContext(), getText(R.string.m0604_t001), Toast.LENGTH_SHORT).show();
//                              Toast.makeText(getApplicationContext(),view.getId()+"/"+R.id.m0604_b001 ,Toast.LENGTH_SHORT).show();
                              break;
                        case R.id.m0604_b002:
                              toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_t002), Toast.LENGTH_SHORT);
                              toast.setGravity(Gravity.CENTER | Gravity.START, 0, 0);
                              toast.show();
                              break;
                        case R.id.m0604_b003:
                              toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_t003), Toast.LENGTH_LONG);
                              toast.setGravity(Gravity.TOP | Gravity.END, 150, 150);

                              LinearLayout toastView = (LinearLayout) toast.getView();
                              ImageView imageCodeProject = new ImageView(getApplicationContext());
                              imageCodeProject.setImageResource(R.drawable.net);
                              toast.setView(imageCodeProject);

                              toast.show();
                              break;
                        case R.id.m0604_b004:
                              LayoutInflater inflater = getLayoutInflater();
                              View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));

                              ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                              TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                              TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                              image.setImageResource(R.drawable.net);
                              title.setText(getString(R.string.m0604_t001).toString());
                              text.setText(getString(R.string.m0604_test).toString());
//-----------------------------------
                              toast = new Toast(getApplicationContext());
                              toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);
                              toast.setDuration(Toast.LENGTH_SHORT);
                              toast.setView(layout);
                              toast.show();
                              break;
                  }
            }
      };


}