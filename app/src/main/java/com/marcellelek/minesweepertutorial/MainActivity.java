package com.marcellelek.minesweepertutorial;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.marcellelek.minesweepertutorial.util.SharedPreferencesHelper;
import com.marcellelek.minesweepertutorial.view.Congratulation;
import com.marcellelek.minesweepertutorial.view.PromptDialog;
import com.marcellelek.minesweepertutorial.views.grid.Cell;
import com.marcellelek.minesweepertutorial.views.grid.Grid;

public class MainActivity extends Activity implements Cell.goldChange,GameEngine.GameStatesInterface{
    TextView gold ;
    TextView level;
    ProgressBar levelprogess;
    Grid gameview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameview=findViewById(R.id.minesweeperGridView);
        gold=findViewById(R.id.tv_gold);
        level=findViewById(R.id.tv_levelnum);
        levelprogess=findViewById(R.id.progressbar1);
        setView();

    }
    private void setView(){
        gold.setText(SharedPreferencesHelper.getGold(this)+"");
        level.setText(SharedPreferencesHelper.getLevel(this)+"");
        levelprogess.setMax(5*SharedPreferencesHelper.getLevel(this));
        levelprogess.setProgress(SharedPreferencesHelper.getEXP(this));
    }

    @Override
    public void onGoldChange() {
        gold.setText(SharedPreferencesHelper.getGold(this)+"");
    }

    @Override
    public void OnWin() {
        int exp=SharedPreferencesHelper.getEXP(this);
        int leve=SharedPreferencesHelper.getLevel(this);
        if(exp==leve*5){
            SharedPreferencesHelper.setLevel(this);
            SharedPreferencesHelper.setEXP(this,0);
            setView();

            PromptDialog promptDialog = new PromptDialog(this);
            promptDialog.setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                    .setAnimationEnable(true)
                    .setTitleText("Congratulation")
                    .setContentText(getString(R.string.level))
                    .setPositiveListener("OKE", new PromptDialog.OnPositiveListener() {
                        @Override
                        public void onClick(PromptDialog dialog) {
                            dialog.dismiss();
                            gameview.redraw(MainActivity.this);
                        }
                    }).show();
        }else {
            SharedPreferencesHelper.setEXP(this);
            setView();
            if (gameview != null) {
                PromptDialog promptDialog = new PromptDialog(this);
                promptDialog.setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                        .setAnimationEnable(true)
                        .setTitleText("Congratulation")
                        .setContentText(getString(R.string.win))
                        .setPositiveListener("OKE", new PromptDialog.OnPositiveListener() {
                            @Override
                            public void onClick(PromptDialog dialog) {
                                dialog.dismiss();
                                gameview.redraw(MainActivity.this);
                            }
                        }).show();
            }
        }
    }

    @Override
    public void OnLose() {
        PromptDialog promptDialog = new PromptDialog(this);
        promptDialog.setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                .setAnimationEnable(true)
                .setTitleText("Game Over")
                .setContentText(getString(R.string.lose))
                .setPositiveListener("OKE", new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog) {
                        dialog.dismiss();
                        gameview.redraw(MainActivity.this);
                    }
                }).show();
    }
}
