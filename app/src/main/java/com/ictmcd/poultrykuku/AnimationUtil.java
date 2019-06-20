package com.ictmcd.poultrykuku;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationSet;

public class AnimationUtil {


    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown){

        AnimatorSet animationSet = new AnimatorSet();

        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true ? 200 : -200, 0);
        animatorTranslateY.setDuration(1000);

        animationSet.playTogether(animatorTranslateY);
        animationSet.start();

    }

}
