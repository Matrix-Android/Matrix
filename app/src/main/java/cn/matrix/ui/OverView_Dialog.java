package cn.matrix.ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import cn.matrix.R;

public class OverView_Dialog extends Dialog {

    private Activity context;
    private Bitmap QRbitmap;

    private ImageButton close_bt;
    private ImageView QRphoto;
    public OverView_Dialog(Activity context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.overview_dialog);

        close_bt = (ImageButton)findViewById(R.id.close_bt);

        final Window dialogWindow = this.getWindow();

        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); //获取对话框的宽、高
        //获取对话框的参数值

        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        p.height = (int)(d.getHeight()*0.6);
        p.width = (int)(d.getWidth()*0.6);
        dialogWindow.setAttributes(p);

        this.setCancelable(false);
        close_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }


}
