package com.bin.david.smarttable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bin.david.form.data.ArrayColumn;
import com.bin.david.smarttable.adapter.ItemAdapter;
import com.bin.david.smarttable.bean.MainItem;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MainItem> items = new ArrayList<>();
        items.add(new MainItem(ParseModeActivity.class,"解析模式"));
        items.add(new MainItem(AnnotationModeActivity.class,"注解模式"));
        items.add(new MainItem(RefreshActivity.class,"刷新加载加载更多"));
        items.add(new MainItem(NetHttpActivity.class,"网络模式(1秒自动添加网络数据)"));
        items.add(new MainItem(ArrayModeActivity.class,"数组模式1(日程表)"));
        items.add(new MainItem(SeatModeActivity.class,"数组模式2(选座)"));
        items.add(new MainItem(PagerModeActivity.class,"分页模式"));
        items.add(new MainItem(ArrayColumnModeActivity.class,"List column"));
        items.add(new MainItem(MultParseModeActivity.class,"多行解析模式"));
        items.add(new MainItem(ExcelModeActivity.class,"JXL Excel模式"));
        items.add(new MainItem(POIExcelModeActivity.class,"POI Excel模式"));
        items.add(new MainItem(MergeModeActivity.class,"自动合并模式"));
        items.add(new MainItem(AlignActivity.class,"文字Align测试"));
        items.add(new MainItem(ManyActivity.class,"测试大量列"));
        items.add(new MainItem(MinModeActivity.class,"设置表格最小宽度"));
        items.add(new MainItem(TableListActivity.class,"测试手势冲突"));
        items.add(new MainItem(TanTanActivity.class,"探探效果"));


        itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.openLoadAnimation();
        itemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
               MainItem mainItem = (MainItem) adapter.getData().get(position);
                Intent i = new Intent(MainActivity.this,mainItem.clazz);
                startActivity(i);
            }
        });
    }



}
