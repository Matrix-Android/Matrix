package cn.matrix.ui;
/*
 * 包名：untitled
 * 文件名： TodoFragment
 * 创建者：wushiqian
 * 创建时间 2018/11/8 12:16 AM
 * 描述： TODO//
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.matrix.R;

public class TodoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todofragment, container, false);
        return view;
    }

}
