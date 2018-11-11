package cn.matrix.ui;
/*
 * 包名：untitled
 * 文件名： ModelingActivity
 * 创建者：wushiqian
 * 创建时间 2018/11/11 8:06 PM
 * 描述： TODO//
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.InputStreamBitmapDecoderFactory;

import java.io.IOException;

import cn.matrix.R;

public class ModelingActivity extends AppCompatActivity{

    private LargeImageView mModelImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modeling);

        mModelImageView = findViewById(R.id.imageView);
        try
        {
            mModelImageView.setImage(new InputStreamBitmapDecoderFactory(getAssets().open("tu.jpg")));

        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
