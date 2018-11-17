package cn.matrix.ui;


import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;

import cn.matrix.R;

public class LogActivity extends AppCompatActivity implements View.OnClickListener{

    private final static int LOGIN_ENABLE = 0x01;
    private final static int LOGIN_UNABLE = 0x02;
    private final static int PASS_ERROR = 0x03;
    private final static int NAME_ERROR = 0x04;

    private String passWord = "",userName ="";

    private Button logIn_button ,scanLog_button;
    private ImageButton clear_pw ,clear_name ,see_pw;
    private EditText pw_editText ,name_editText ;
    private TextView iWarming_editText;
    private CheckBox remPW ,logA;
    private Boolean isEyeOpen = false;
    private TextWatcher name_watcher ,pw_watcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        init();

    }

    protected void init(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //Buttons
        logIn_button = (Button)findViewById(R.id.logIn);
        //ImageButtons
        clear_name = (ImageButton)findViewById(R.id.clear_name_bt);
        clear_pw = (ImageButton)findViewById(R.id.clear_pw_bt);
        see_pw = (ImageButton)findViewById(R.id.see_pw_bt);
        //EditText
        pw_editText = (EditText)findViewById(R.id.pw_editText);
        name_editText = (EditText)findViewById(R.id.name_editText);
        iWarming_editText = (TextView)findViewById(R.id.I_warning);
        //CheckBox
        remPW = (CheckBox)findViewById(R.id.rPW_checkBox);
        logA = (CheckBox)findViewById(R.id.logA_checkBox);

        name_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0){
                    clear_name.setVisibility(View.VISIBLE);
                    userName = s.toString();
                }else{
                    clear_name.setVisibility(View.INVISIBLE);
                }
            }
        };
        pw_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0){
                    clear_pw.setVisibility(View.VISIBLE);
                    passWord = s.toString();
                }else{
                    clear_pw.setVisibility(View.INVISIBLE);
                }
            }
        };

        //set Listeners
        logIn_button.setOnClickListener(this);
        clear_name.setOnClickListener(this);
        clear_pw.setOnClickListener(this);
        see_pw.setOnClickListener(this);
        //add editText's watcher
        name_editText.addTextChangedListener(name_watcher);
        pw_editText.addTextChangedListener(pw_watcher);
    }

//    final Handler uiHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case LOGIN_ENABLE:
//                    break;
//                case LOGIN_UNABLE:
//                    break;
//                case PASS_ERROR:
//                    break;
//                case NAME_ERROR:
//                    break;
//            }
//            super.handleMessage(msg);
//        }
//    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logIn:
                if(passWord == "" || userName =="") {
                    iWarming_editText.setVisibility(View.VISIBLE);
                }else {
                    iWarming_editText.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.clear_name_bt:
                name_editText.setText("");
                userName = "";
                clear_name.setVisibility(ImageButton.INVISIBLE);
                break;
            case R.id.clear_pw_bt:
                pw_editText.setText("");
                passWord = "";
                clear_pw.setVisibility(ImageButton.INVISIBLE);
                break;
            case R.id.see_pw_bt:
                if(isEyeOpen == true){
                    //password can be seen
                    isEyeOpen = false;
                    see_pw.setBackgroundResource(R.drawable.ic_eye);
                    pw_editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    isEyeOpen = true;
                    see_pw.setBackgroundResource(R.drawable.ic_eye2);
                    pw_editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
        }
    }
}
