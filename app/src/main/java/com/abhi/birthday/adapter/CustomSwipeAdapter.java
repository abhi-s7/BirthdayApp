package com.abhi.birthday.adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.abhi.birthday.R;
import com.abhi.birthday.model.Wishes;

import java.util.List;

public class CustomSwipeAdapter extends PagerAdapter {

    private List<Wishes> wishes;
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(List<Wishes> wishes, Context ctx) {
        this.wishes = wishes;
        this.ctx = ctx;
    }

    public List<Wishes> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wishes> cards) {
        this.wishes = wishes;
    }

    public Context getCtx() {
        return ctx;
    }
    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o);
    }

    @Override
    public int getCount() {
        return wishes.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.swipe_layout,container,false);

        ImageView imageView;

        imageView  = view.findViewById(R.id.image_main);

        imageView.setImageResource(wishes.get(position).getCardImage());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
