package cn.bluemobi.dylan.animationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bluemobi.dylan.animationdemo.adapter.CommonAdapter;
import cn.bluemobi.dylan.animationdemo.adapter.CommonViewHolder;

public class MainActivity extends AppCompatActivity {
    private boolean fromXml = true;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void onClick(View v) {
        iv.setImageResource(R.mipmap.ic_launcher);
        switch (v.getId()) {
            case R.id.animation_alpha://透明度渐变动画
                if (fromXml) {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                    iv.startAnimation(animation);
                } else {
                    /**
                     * 第一个参数fromAlpha为 动画开始时候透明度
                     *第二个参数toAlpha为 动画结束时候透明度
                     */
                    Animation animation = new AlphaAnimation(0, 1);
                    animation.setDuration(1000);
                    iv.startAnimation(animation);
                }
                break;
            case R.id.animation_scale://缩放动画
                if (fromXml) {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                    iv.startAnimation(animation);
                } else {
                    /**
                     * 第一个参数fromX为动画起始时 X坐标上的伸缩尺寸
                     * 第二个参数toX为动画结束时 X坐标上的伸缩尺寸
                     * 第三个参数fromY为动画起始时Y坐标上的伸缩尺寸
                     * 第四个参数toY为动画结束时Y坐标上的伸缩尺寸
                     * 说明: 0.0表示收缩到没有;1.0表示正常无伸缩;值小于1.0表示收缩;值大于1.0表示放大

                     * 第五个参数pivotXType为动画在X轴相对于物件位置类型
                     * 第六个参数pivotXValue为动画相对于物件的X坐标的开始位置
                     * 第七个参数pivotXType为动画在Y轴相对于物件位置类型
                     * 第八个参数pivotYValue为动画相对于物件的Y坐标的开始位置
                     */
                    Animation animation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(1000);
                    iv.startAnimation(animation);
                }
                break;
            case R.id.animation_rotate://旋转动画
                if (fromXml) {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                    iv.startAnimation(animation);
                } else {
                    /**
                     * 第一个参数fromDegrees为动画起始时角度
                     * 第二个参数toDegrees为动画结束角度
                     * 第三个参数pivotXType为动画在X轴相对于物件位置类型
                     * 第四个参数pivotXValue为动画相对于物件的X坐标的开始位置
                     * 第五个参数pivotXType为动画在Y轴相对于物件位置类型
                     * 第六个参数pivotYValue为动画相对于物件的Y坐标的开始位置
                     */
                    Animation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(1000);
                    iv.startAnimation(animation);
                }
                break;
            case R.id.animation_translate://位移动画
                if (fromXml) {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                    iv.startAnimation(animation);
                } else {
                    /**
                     * 第一个参数fromXDelta为动画起始时的x坐标
                     * 第二个参数toXDelta为动画结束时的x坐标
                     * 第三个参数fromYDelta为动画起始时的y坐标
                     * 第四个参数toYDelta为动画结束时的y坐标
                     */
                    Animation animation = new TranslateAnimation(0, 500, 0, 0);
                    animation.setDuration(2000);
                    /**设置插值器：先加速，后减速**/
                    animation.setInterpolator(new AccelerateDecelerateInterpolator());
                    iv.startAnimation(animation);
                }
                break;
            case R.id.animation_group1://先播放缩放动画，完成后播放旋转动画
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                iv.startAnimation(animation);
                final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        iv.startAnimation(animation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.animation_group2://先播放旋转动画，完成后播放位移动画，在xml中设置第二个动画执行的等待时间
                Animation animationGroup = AnimationUtils.loadAnimation(this, R.anim.group2);
                iv.startAnimation(animationGroup);
                break;
            case R.id.animation_group3://重复的透明度动画
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setRepeatCount(10);
                /**倒序重复REVERSE  正序重复RESTART**/
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(alphaAnimation);
                break;
            case R.id.animation_group4://重复的位移动画
                Animation translateAnimation = new TranslateAnimation(-10, 10, 0, 0);
                translateAnimation.setDuration(100);
                translateAnimation.setRepeatCount(10);
                /**倒序重复REVERSE  正序重复RESTART**/
                translateAnimation.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(translateAnimation);
                break;
            case R.id.animation_frame://帧动画
                iv.setImageResource(R.drawable.ring_animation);
                AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
                animationDrawable.start();
                break;
            case R.id.animation_layout://布局动画
                commonAdapterTest();
                break;
            case R.id.animation_activity://activity跳转动画
                startActivity(new Intent(this,SecondActivity.class));
                overridePendingTransition(R.anim.zoom_out,R.anim.zoom_in);
                break;
        }

    }

    /**
     * 布局动画
     */
    private void commonAdapterTest() {
        ListView listView = (ListView) findViewById(R.id.listview);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            datas.add("万能适配器测试" + i);
        }
        LayoutAnimationController layoutAnimationController= new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        listView.setLayoutAnimation(layoutAnimationController);
        listView.setAdapter(new CommonAdapter<String>(this, datas, R.layout.item) {

            @Override
            protected void convertView(View item, String s) {
                TextView textView = CommonViewHolder.get(item, R.id.textView);
                textView.setText(s);
            }
        });
    }
}
