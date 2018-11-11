package cn.matrix.ui;
/*
 * 包名：untitled
 * 文件名： RightFragment
 * 创建者：wushiqian
 * 创建时间 2018/11/7 10:54 PM
 * 描述： TODO//
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.matrix.R;
import cn.matrix.adapter.AreaAdapter;
import cn.matrix.entity.Area;

public class RightFragment extends Fragment {

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.right_fragment, container, false);
        GridView grid_photo = view.findViewById(R.id.gridView);
        ArrayList<Area> data = new ArrayList<>();
        data.add(new Area(0, "下岸村"));
        data.add(new Area(1, "大石村"));
        data.add(new Area(2, "久留村"));

        BaseAdapter adapter = new AreaAdapter<Area>(data, R.layout.item) {
            @Override
            public void bindView(final ViewHolder holder, Area obj) {
                holder.setText(R.id.area_name, obj.getName());
                holder.setOnClickListener(R.id.start_button, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, holder.getItemPosition() + "~~~~~~~~~~~start~~~~~~~~~~~", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(),ModelingActivity.class);
                        startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.message_button, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, holder.getItemPosition() + "~~~~~~~~~~~message~~~~~~~~~~~", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        grid_photo.setAdapter(adapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
