package com.marcellelek.minesweepertutorial;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marcellelek.minesweepertutorial.util.SharedPreferencesHelper;
import com.marcellelek.minesweepertutorial.views.grid.Cell;
import com.marcellelek.minesweepertutorial.views.grid.Grid;

public class MainActivity extends Activity implements Cell.goldChange {
    TextView gold ;
    TextView level;
    ProgressBar levelprogess;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gold=findViewById(R.id.tv_gold);
        gold.setText(SharedPreferencesHelper.getGold(this)+"");

        level=findViewById(R.id.tv_levelnum);
        level.setText(SharedPreferencesHelper.getLevel(this)+"");
        levelprogess=findViewById(R.id.progressbar1);
        levelprogess.setMax(5*SharedPreferencesHelper.getLevel(this));
        levelprogess.setProgress(SharedPreferencesHelper.getEXP(this));

    }

    @Override
    public void onGoldChange() {
        gold.setText(SharedPreferencesHelper.getGold(this)+"");
    }
}
