package com.marcellelek.minesweepertutorial.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Congratulation extends Dialog {
    public Congratulation(Context context, boolean cancelable,int Width,int Height) {
        super(context);
        setCancelable(cancelable);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText("Congratulation you win !!");

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                Width,Height);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        relativeLayout.addView(textView,params);
        setContentView(relativeLayout);
    }
}
