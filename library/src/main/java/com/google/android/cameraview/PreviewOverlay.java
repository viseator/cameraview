/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.cameraview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class PreviewOverlay extends View {

    private static final String TAG = "@vir PreviewOverlay";
    private GestureDetector mGestureDetector = null;
    private ScaleGestureDetector mScaleGestureDetector = null;

    public PreviewOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (mScaleGestureDetector != null) {
            mScaleGestureDetector.onTouchEvent(m);
        }
        Log.d(TAG, String.valueOf(mScaleGestureDetector.isInProgress()));
        if (mGestureDetector != null && !mScaleGestureDetector.isInProgress()) {
            if (mGestureDetector != null) {
                mGestureDetector.onTouchEvent(m);
            }
        }
        return true;
    }

    public void setGestureListener(GestureDetector.OnGestureListener gestureListener) {
        if (gestureListener != null) {
            mGestureDetector = new GestureDetector(getContext(), gestureListener);
        } else {
            mGestureDetector = null;
        }
    }

    public boolean hasGestureDetector() {
        return mGestureDetector != null;
    }

    public void setScaleGestureListener(ScaleGestureDetector.OnScaleGestureListener
                                                gestureListener) {
        if (gestureListener != null) {
            mScaleGestureDetector = new ScaleGestureDetector(getContext(), gestureListener);
        } else {
            mScaleGestureDetector = null;
        }
    }

    public boolean hasScaleGestureDetector() {
        return mScaleGestureDetector != null;
    }
}
