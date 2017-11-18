package com.google.android.cameraview;

import android.view.MotionEvent;

public interface MocaOnScrollListener{
    boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);
}
