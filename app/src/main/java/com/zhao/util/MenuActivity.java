package com.zhao.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.zhao.util.util.PopupWindowUtil;

import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends Activity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void menuClick(View view) {
        final List<PopupWindowEntity> items = new ArrayList<PopupWindowEntity>();

        PopupWindowEntity item1 = new PopupWindowEntity();
        PopupWindowEntity item2 = new PopupWindowEntity();
        PopupWindowEntity item3 = new PopupWindowEntity();
        PopupWindowEntity item4 = new PopupWindowEntity();
        PopupWindowEntity item5 = new PopupWindowEntity();
        PopupWindowEntity item6 = new PopupWindowEntity();

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        item1.setText("呼叫110");
        item1.setData("110");
        item1.setResId(R.mipmap.popwindow_icon_110);

        item2.setText("紧急联系人");
        item2.setData("911");
        item2.setResId(R.mipmap.popwindow_icon_contact);

        item3.setText("昆凌");
        item3.setData("18664932222");

        item4.setText("周杰伦");
        item4.setData("18664933333");

        item5.setText("闫妮");
        item5.setData("18664123456");

        item6.setText("呼叫客服");
        item6.setData("9191");
        item6.setResId(R.mipmap.popwindow_icon_service);

        final PopupWindowUtil popupWindow = new PopupWindowUtil(context, items);
        popupWindow.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindow.dismiss();
                PopupWindowEntity entity = items.get(position);
                Toast.makeText(context, "电话" + entity.getData(), Toast.LENGTH_SHORT).show();
            }
        });
        //根据后面的数据调节窗口的宽度

        popupWindow.setOff(0, getResources().getDimensionPixelOffset(R.dimen.popwindow_margin));
        popupWindow.show(view, 5);
    }
}
