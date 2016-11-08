>Android中常用的动画都在这里了，包含了基本的动画【透明度动画，缩放动画，旋转动画，位移动画】；还有就是这四种动画的组合实现；
还有布局动画，就是在加载布局时的动画；还有Activity跳转的动画。
效果图如下：

![效果图](https://github.com/linglongxin24/AnimationDemo/blob/master/screenshorts/effect.gif?raw=true)

#1. Android基础动画

 * 透明度动画
 
```xml
 <?xml version="1.0" encoding="utf-8"?>
 <set xmlns:android="http://schemas.android.com/apk/res/android">
     <alpha
         android:duration="1000"
         android:fromAlpha="0.0"
         android:toAlpha="1.0"
         />
 </set>
```

```java
   /**
    * 第一个参数fromAlpha为 动画开始时候透明度
    *第二个参数toAlpha为 动画结束时候透明度
     */
     Animation animation = new AlphaAnimation(0, 1);
     animation.setDuration(1000);
    v.startAnimation(animation);
```

 * 缩放动画
 
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <scale
        android:duration="1000"
        android:fromXScale="0"
        android:fromYScale="0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1"
        android:toYScale="1" />
</set>
```

```java
 /**
 * 第一个参数fromX为动画起始时 X坐标上的伸缩尺寸
 * 第二个参数toX为动画结束时 X坐标上的伸缩尺寸
 * 第三个参数fromY为动画起始时Y坐标上的伸缩尺寸
 * 第四个参数toY为动画结束时Y坐标上的伸缩尺寸
 * 说明: 0.0表示收缩到没有;1.0表示正常无伸缩;值小于1.0表示收缩;值大于1.
 * 第五个参数pivotXType为动画在X轴相对于物件位置类型
 * 第六个参数pivotXValue为动画相对于物件的X坐标的开始位置
 * 第七个参数pivotXType为动画在Y轴相对于物件位置类型
 * 第八个参数pivotYValue为动画相对于物件的Y坐标的开始位置
 */
Animation animation = new ScaleAnimation(0, 1
animation.setDuration(1000);
iv.startAnimation(animation);
```
 
 * 旋转动画

```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <rotate
        android:duration="1000"
        android:fromDegrees="0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toDegrees="360" />
</set>
```

```java
    /**
     * 第一个参数fromDegrees为动画起始时角度
     * 第二个参数toDegrees为动画结束角度
     * 第三个参数pivotXType为动画在X轴相对于物件位置类型
     * 第四个参数pivotXValue为动画相对于物件的X坐标的开始位置
     * 第五个参数pivotXType为动画在Y轴相对于物件位置类型
     * 第六个参数pivotYValue为动画相对于物件的Y坐标的开始位置
     */
    Animation animation = new RotateAnima
    animation.setDuration(1000);
    iv.startAnimation(animation);
```

 
 * 位移动画

```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:duration="2000"
        android:fromXDelta="0"
        android:fromYDelta="0"
        android:toXDelta="500"
        android:interpolator="@android:anim/accelerate_interpolator"
        android:toYDelta="0" />
</set>
```

```java
    /**
     * 第一个参数fromDegrees为动画起始时角度
     * 第二个参数toDegrees为动画结束角度
     * 第三个参数pivotXType为动画在X轴相对于物件位置类型
     * 第四个参数pivotXValue为动画相对于物件的X坐标的开始位置
     * 第五个参数pivotXType为动画在Y轴相对于物件位置类型
     * 第六个参数pivotYValue为动画相对于物件的Y坐标的开始位置
     */
     Animation animation = new RotateAnima
     animation.setDuration(1000);
     iv.startAnimation(animation);
     /**
      * 第一个参数fromXDelta为动画起始时的x坐标
      * 第二个参数toXDelta为动画结束时的x坐标
      * 第三个参数fromYDelta为动画起始时的y坐标
      * 第四个参数toYDelta为动画结束时的y坐标
      */
      Animation animation = new Translat
      animation.setDuration(2000);
      /**设置插值器：先加速，后减速**/
      animation.setInterpolator(new Acce
      iv.startAnimation(animation);
```
#2.组合动画

 * 先播放缩放动画，完成后播放旋转动画
 
 ```java
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
 ```

 * 先播放旋转动画，完成后播放位移动画，在xml中设置第二个动画执行的等待时间
 
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">

    <rotate
        android:duration="1000"
        android:fromDegrees="0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toDegrees="360" />
    <translate
        android:duration="1000"
        android:fromXDelta="0"
        android:fromYDelta="0"
        android:toXDelta="500"
        android:startOffset="1000"
        android:interpolator="@android:anim/accelerate_interpolator"
        android:toYDelta="0" />
</set>
```

* 重复的透明度动画-闪烁

```java
AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setRepeatCount(10);
                /**倒序重复REVERSE  正序重复RESTART**/
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(alphaAnimation);
```

 * 重复的位移动画-抖动
 
```java
 Animation translateAnimation = new TranslateAnimation(-10, 10, 0, 0);
                translateAnimation.setDuration(100);
                translateAnimation.setRepeatCount(10);
                /**倒序重复REVERSE  正序重复RESTART**/
                translateAnimation.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(translateAnimation);
```

#3.帧动画

 * 在drawable文件夹下建立文件
 
 ```xml
 <?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
  >
    <item android:drawable="@mipmap/windmill_1"
        android:duration="500">
    </item>
    <item android:drawable="@mipmap/windmill_2"
        android:duration="500">
    </item>
    <item android:drawable="@mipmap/windmill_3"
        android:duration="500">
    </item>
    <item android:drawable="@mipmap/windmill_4"
        android:duration="500">
    </item>
    <item android:drawable="@mipmap/windmill_5"
        android:duration="500">
    </item>
    <item android:drawable="@mipmap/windmill_6"
        android:duration="500">
    </item>
    <item android:drawable="@mipmap/windmill_7"
        android:duration="500">
    </item>

</animation-list>

 ```
 * 在activity中调用
 
 ```java
    iv.setImageResource(R.drawable.ring_animation);
                AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
                animationDrawable.start();
 ```
#4.布局动画
这是一个ListView的加载布局动画

 * 先建立动画文件,从透明到不透明并且大小从0到原大小

```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/decelerate_interpolator" >

    <scale
        android:duration="1000"
        android:fromXScale="0.1"
        android:fromYScale="0.1"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1.0"
        android:toYScale="1.0" />
    <alpha
        android:duration="1000"
        android:fromAlpha="0"
        android:toAlpha="1.0" />
</set>
```

* 在activity中的用法

```java
 ListView listView = (ListView) findViewById(R.id.listview);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            datas.add("万能适配器测试" + i);
        }
        LayoutAnimationController layoutAnimationController= new        LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        listView.setLayoutAnimation(layoutAnimationController);
        listView.setAdapter(new CommonAdapter<String>(this, datas, R.layout.item) {

            @Override
            protected void convertView(View item, String s) {
                TextView textView = CommonViewHolder.get(item, R.id.textView);
                textView.setText(s);
            }
        });
```
#5.Activity跳转动画
 
 * 退出动画：从不透明到透明并且大小从原大小到0
 
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/decelerate_interpolator"
    android:zAdjustment="top" >

    <scale
        android:duration="@android:integer/config_mediumAnimTime"
        android:fromXScale="1.0"
        android:fromYScale="1.0"
        android:pivotX="50%p"
        android:pivotY="50%p"
        android:toXScale="0.1"
        android:toYScale="0.1" />

    <alpha
        android:duration="@android:integer/config_mediumAnimTime"
        android:fromAlpha="1.0"
        android:toAlpha="0" />

</set>
```

 * 进入动画：从透明到不透明并且大小从0到原大小
 
```xml
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@android:anim/decelerate_interpolator" >

    <scale
        android:duration="1000"
        android:fromXScale="0.1"
        android:fromYScale="0.1"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1.0"
        android:toYScale="1.0" />
    <alpha
        android:duration="1000"
        android:fromAlpha="0"
        android:toAlpha="1.0" />
</set>
```

 * 在Activity中的用法
 
```java
  startActivity(new Intent(this,SecondActivity.class));
                overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
```
#6.[GitHub](https://github.com/linglongxin24/AnimationDemo)
