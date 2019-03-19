package com.mercado.a.domicilio.config.bar_main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;
// CustomViewPager es la configuracion del ViewPager que esta en 'app_bar_main'
public class CustomViewPager extends ViewPager {
    // habilitamos los desplazamientos
    private boolean enabled = true;

    public CustomViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.enabled && super.onTouchEvent(event) && performClick();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.enabled && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean performClick() {

        return this.enabled && super.performClick();
    }

    @Override
    public void setEnabled(boolean enabled) {

        this.enabled = enabled;
    }

    @Override
    public void setClipToPadding(boolean clipToPadding) {
        super.setClipToPadding(clipToPadding);
    }
}