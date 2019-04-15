package com.marcellelek.minesweepertutorial;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.marcellelek.minesweepertutorial.util.SharedPreferencesHelper;
import com.marcellelek.minesweepertutorial.view.Congratulation;
import com.marcellelek.minesweepertutorial.view.PromptDialog;
import com.marcellelek.minesweepertutorial.views.grid.Cell;
import com.marcellelek.minesweepertutorial.views.grid.Grid;

public class MainActivity extends Activity implements Cell.goldChange,GameEngine.GameStatesInterface,View.OnClickListener{
    TextView gold ;
    TextView level;
    ProgressBar levelprogess;
    Grid gameview;
    ImageView menu;
    DrawerLayout drawerLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gameview=findViewById(R.id.minesweeperGridView);
        gold=findViewById(R.id.tv_gold);
        level=findViewById(R.id.tv_levelnum);
        levelprogess=findViewById(R.id.progressbar1);
        menu = findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        gameview.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
               setDrawerView();
            }
        });
        setView();

    }

    private void setDrawerView() {

        int screen_width=gameview.getWidth();
//        int screen_height=metrics.heightPixels*13/14;
        int screen_height=gameview.getHeight();
        TextView x=findViewById(R.id.x);
        TextView x2=findViewById(R.id.x2);
        TextView x3=findViewById(R.id.x3);
        TextView x4=findViewById(R.id.x4);
        TextView x5=findViewById(R.id.x5);
        TextView x6=findViewById(R.id.x6);
        TextView x7=findViewById(R.id.x7);
        TextView x8=findViewById(R.id.x8);
        TextView x9=findViewById(R.id.x9);
        TextView x10=findViewById(R.id.x10);
        ImageView l=findViewById(R.id.iv_lock);
        ImageView l2=findViewById(R.id.iv_lock2);
        ImageView l3=findViewById(R.id.iv_lock3);
        ImageView l4=findViewById(R.id.iv_lock4);
        ImageView l5=findViewById(R.id.iv_lock5);
        ImageView l6=findViewById(R.id.iv_lock6);
        ImageView l7=findViewById(R.id.iv_lock7);
        ImageView l8=findViewById(R.id.iv_lock8);
        ImageView l9=findViewById(R.id.iv_lock9);
        ImageView l10=findViewById(R.id.iv_lock10);
        RelativeLayout r=findViewById(R.id.rl_lv1);
        RelativeLayout r2=findViewById(R.id.rl_lv2);
        RelativeLayout r3=findViewById(R.id.rl_lv3);
        RelativeLayout r4=findViewById(R.id.rl_lv4);
        RelativeLayout r5=findViewById(R.id.rl_lv5);
        RelativeLayout r6=findViewById(R.id.rl_lv6);
        RelativeLayout r7=findViewById(R.id.rl_lv7);
        RelativeLayout r8=findViewById(R.id.rl_lv8);
        RelativeLayout r9=findViewById(R.id.rl_lv9);
        RelativeLayout r10=findViewById(R.id.rl_lv10);
        r.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        r5.setOnClickListener(this);
        r6.setOnClickListener(this);
        r7.setOnClickListener(this);
        r8.setOnClickListener(this);
        r9.setOnClickListener(this);
        r10.setOnClickListener(this);

        x.setText(6+" X "+(int) (6*((float)screen_height/(float) screen_width)));
        x2.setText(7+" X "+(int) (7*((float)screen_height/(float) screen_width)));
        x3.setText(8+" X "+(int) (8*((float)screen_height/(float) screen_width)));
        x4.setText(9+" X "+(int) (9*((float)screen_height/(float) screen_width)));
        x5.setText(10+" X "+(int) (10*((float)screen_height/(float) screen_width)));
        x6.setText(11+" X "+(int) (11*((float)screen_height/(float) screen_width)));
        x7.setText(12+" X "+(int) (12*((float)screen_height/(float) screen_width)));
        x8.setText(13+" X "+(int) (13*((float)screen_height/(float) screen_width)));
        x9.setText(14+" X "+(int) (14*((float)screen_height/(float) screen_width)));
        x10.setText(15+" X "+(int) (15*((float)screen_height/(float) screen_width)));

//        if(!SharedPreferencesHelper.getLock(this,"lock"+1)){
            l.setVisibility(View.INVISIBLE);
//        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+2)){
            l2.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+3)){
            l3.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+4)){
            l4.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+5)){
            l5.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+6)){
            l6.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+7)){
            l7.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+8)){
            l8.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+9)){
            l9.setVisibility(View.INVISIBLE);
        }
        if(!SharedPreferencesHelper.getLock(this,"lock"+10)){
            l10.setVisibility(View.INVISIBLE);
        }

    }

    private void setView(){
        gold.setText(SharedPreferencesHelper.getGold(this)+"");
        level.setText(SharedPreferencesHelper.getLevel(this)+"");
        levelprogess.setMax(SharedPreferencesHelper.getLevel(this)*(5+SharedPreferencesHelper.getLevel(this)*2));
        levelprogess.setProgress(SharedPreferencesHelper.getEXP(this));
    }

    @Override
    public void onGoldChange()
    {
        Toast.makeText(this, "asd", Toast.LENGTH_SHORT).show();
        gold.setText(SharedPreferencesHelper.getGold(this)+"");
    }

    @Override
    public void OnWin() {
        int exp=SharedPreferencesHelper.getEXP(this);
        int leve=SharedPreferencesHelper.getLevel(this);
        if(exp>=levelprogess.getMax()){
            SharedPreferencesHelper.setLevel(this);
            SharedPreferencesHelper.setEXP(this,exp-levelprogess.getMax());
            setView();
            SharedPreferencesHelper.setLock(this,"lock"+SharedPreferencesHelper.getLevel(this));
            setDrawerView();
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
                    });
            promptDialog.setCancelable(false);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    GameEngine.isEnd=1;
                }
            });
            promptDialog.show();

        }else {
            SharedPreferencesHelper.setEXP(this,SharedPreferencesHelper.getEXP(this)+1*GameEngine.LEVEL);
            int xp=SharedPreferencesHelper.getEXP(this);

            if(xp>=levelprogess.getMax()){
                SharedPreferencesHelper.setLevel(this);
                SharedPreferencesHelper.setEXP(this,xp-levelprogess.getMax());
                setView();
                SharedPreferencesHelper.setLock(this,"lock"+SharedPreferencesHelper.getLevel(this));
                setDrawerView();
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
                        });
                promptDialog.setCancelable(false);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        GameEngine.isEnd=1;
                    }
                });
                promptDialog.show();
            }else {
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
                            });
                    promptDialog.setCancelable(false);
                    promptDialog.setCanceledOnTouchOutside(false);
                    promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            GameEngine.isEnd=1;
                        }
                    });
                    promptDialog.show();
                }
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
                });
        promptDialog.setCancelable(false);
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                GameEngine.isEnd=1;
            }
        });
        promptDialog.show();
    }
    public void UnLockDialog(final int level){
        PromptDialog promptDialog = new PromptDialog(this);
        promptDialog.setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                .setAnimationEnable(true)
                .setTitleText("You need to reach level "+level+" to unlock this or you can unlock with "+level*5+" gold")
                .setContentText(getString(R.string.lose))
                .setPositiveListener("Cancel", new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog) {
                       dialog.dismiss();
                    }
                });

        if(SharedPreferencesHelper.getGold(this)>=level*5){
            promptDialog.setNeListener("Oke", new PromptDialog.OnNeListener() {
                @Override
                public void onClick(PromptDialog dialog) {
                    dialog.dismiss();
                    SharedPreferencesHelper.setLock(MainActivity.this,"lock"+level);
                    SharedPreferencesHelper.setGold(MainActivity.this,(SharedPreferencesHelper.getGold(MainActivity.this)-(level*5)));
                    onGoldChange();
                    setDrawerView();
                }
            });
        }
        promptDialog.setCancelable(false);
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                GameEngine.isEnd=1;
            }
        });
        promptDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_lv1:{
                GameEngine.WIDTH=6;
                GameEngine.LEVEL=1;
                gameview.redraw(this);
                break;
            }
            case R.id.rl_lv2:{
                if(!SharedPreferencesHelper.getLock(this,"lock2")){
                    GameEngine.WIDTH=7;
                    GameEngine.LEVEL=2;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(2);
                }
                break;
            }
            case R.id.rl_lv3:{
                if(!SharedPreferencesHelper.getLock(this,"lock3")){
                    GameEngine.WIDTH=8;
                    GameEngine.LEVEL=3;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(3);
                }

                break;
            }
            case R.id.rl_lv4:{
                if(!SharedPreferencesHelper.getLock(this,"lock4")){
                    GameEngine.WIDTH=9;
                    GameEngine.LEVEL=4;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(4);
                }

                break;
            }
            case R.id.rl_lv5:{
                if(!SharedPreferencesHelper.getLock(this,"lock5")){
                    GameEngine.WIDTH=10;
                    GameEngine.LEVEL=5;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(5);
                }

                break;
            }
            case R.id.rl_lv6:{
                if(!SharedPreferencesHelper.getLock(this,"lock6")){
                    GameEngine.WIDTH=11;
                    GameEngine.LEVEL=6;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(6);
                }

                break;
            }
            case R.id.rl_lv7:{
                if(!SharedPreferencesHelper.getLock(this,"lock7")){
                    GameEngine.WIDTH=12;
                    GameEngine.LEVEL=7;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(7);
                }

                break;
            }
            case R.id.rl_lv8:{
                if(!SharedPreferencesHelper.getLock(this,"lock8")){
                    GameEngine.WIDTH=13;
                    GameEngine.LEVEL=8;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(8);
                }

                break;
            }
            case R.id.rl_lv9:{
                if(!SharedPreferencesHelper.getLock(this,"lock9")){
                    GameEngine.WIDTH=14;
                    GameEngine.LEVEL=9;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(9);
                }

                break;
            }
            case R.id.rl_lv10:{
                if(!SharedPreferencesHelper.getLock(this,"lock10")){
                    GameEngine.WIDTH=15;
                    GameEngine.LEVEL=10;
                    gameview.redraw(this);
                }else {
                    UnLockDialog(10);
                }

                break;
            }


        }
    }
}
