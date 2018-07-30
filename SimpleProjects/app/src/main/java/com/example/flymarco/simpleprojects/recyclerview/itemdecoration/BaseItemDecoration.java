package com.example.flymarco.simpleprojects.recyclerview.itemdecoration;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseItemDecoration extends RecyclerView.ItemDecoration {

    private final int[] attrs = new int[]{
            android.R.attr.listDivider
    };

    public static final int LAYOUT_VERTAIL = 0;
    public static final int LAYOUT_HORZONTAL = 1;

    private static final int DEFAULT_DECORATION = 10;

    private int mDecroation;
    private Drawable mDivider;

    public BaseItemDecoration(Activity activity, int layoutDecoration) {
        mDecroation = layoutDecoration;
        TypedArray typedArray = activity.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mDecroation == LAYOUT_HORZONTAL) {
            drawHorizonal(c, parent, state);
        } else {
            drawVertical(c, parent, state);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mDecroation == LAYOUT_HORZONTAL) {
            outRect.intersect(0, 0, mDivider.getIntrinsicWidth(), 0);
        } else {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int right = parent.getPaddingRight();
        int left = parent.getWidth() - parent.getPaddingLeft();
        int top;
        int bottom;
        View child;
        RecyclerView.LayoutParams layoutParams;
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            child = parent.getChildAt(i);
            layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            top = child.getBottom() + layoutParams.topMargin;
            bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private void drawHorizonal(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left;
        int top = parent.getPaddingTop();
        int right;
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        View child;
        RecyclerView.LayoutParams layoutParams;
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            child = parent.getChildAt(i);
            layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            left = child.getRight() + layoutParams.leftMargin;
            right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
