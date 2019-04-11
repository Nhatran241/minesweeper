package com.marcellelek.minesweepertutorial.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.marcellelek.minesweepertutorial.GameEngine;

/**
 * Created by Marcell on 2016. 04. 14..
 */
public class Grid extends GridView{

    public Grid(Context context , AttributeSet attrs){
        super(context,attrs);
        initRation(context);
        GameEngine.getInstance().createGrid(context);
        setNumColumns(GameEngine.WIDTH);
        setAdapter(new GridAdapter());
    }

    private void initRation(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int screen_width=metrics.widthPixels;
        int screen_height=metrics.heightPixels*13/14;
        if(screen_width < screen_height)
        {
            GameEngine.WIDTH=6;
            GameEngine.HEIGHT= (int) (GameEngine.WIDTH*((float)screen_height/(float) screen_width));
        }
        else
        {
            GameEngine.HEIGHT=6;
            GameEngine.WIDTH= (int) (GameEngine.HEIGHT*((float)screen_width/(float)screen_height));
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private class GridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return GameEngine.getInstance().WIDTH * GameEngine.getInstance().HEIGHT;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameEngine.getInstance().getCellAt(position);
        }
    }
}
