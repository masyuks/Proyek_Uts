package com.Avdhio.proyek_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;

import com.Avdhio.proyek_uts.Adapter.GameAdapter;
import com.Avdhio.proyek_uts.Model.GameLogo;

import java.util.ArrayList;

public class PcActivity extends AppCompatActivity implements GameAdapter.OnitemListener{
    private RecyclerView rvPc;
    private ArrayList<GameLogo>list = new ArrayList<>();
    private GameAdapter.OnitemListener context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc);
        rvPc = findViewById(R.id.rv_pc);
        list.addAll(DataDummy.GetListData());
        rvPc.setLayoutManager(new LinearLayoutManager(this));
        GameAdapter gameAdapter = new GameAdapter(list,context);
        rvPc.setAdapter(gameAdapter);
    }

    @Override
    public void onListClicked(int index, GameLogo item) {
        String detail = item.getDetail();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Data Detail",detail);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
