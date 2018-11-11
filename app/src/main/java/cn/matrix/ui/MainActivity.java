package cn.matrix.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.matrix.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RightFragment mRightFragment;
    private TodoFragment mTodoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRightFragment = new RightFragment();
        mTodoFragment = new TodoFragment();
        ImageButton button = findViewById(R.id.button);
        button.setOnClickListener(this);
        ImageButton button2 = findViewById(R.id.button2);
        button.setOnClickListener(this);
        ImageButton button3 = findViewById(R.id.button3);
        button.setOnClickListener(this);
        ImageButton button4 = findViewById(R.id.button4);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        replaceFragment(mRightFragment);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                replaceFragment(mRightFragment);
                break;
            case R.id.button2:
                replaceFragment(mTodoFragment);
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            default:
                break;
        }
    }

}
