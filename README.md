#1. Android基础动画
 * 透明度动画
 * 缩放动画
 * 旋转动画
 * 位移动画
 ![效果图](https://github.com/linglongxin24/AnimationDemo/blob/master/screenshorts/%E7%A4%BA%E4%BE%8B%E5%9B%BE.jpg?raw=true)
 
 代码：
 
 ```java
 package cn.bluemobi.dylan.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean fromXml = false;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void onClick(View v) {
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
                    Animation animation = new TranslateAnimation(0, 500,0,0);
                    animation.setDuration(1000);
                    iv.startAnimation(animation);
                }
                break;
        }

    }
}

 ```
[GitHub](https://github.com/linglongxin24/AnimationDemo)
