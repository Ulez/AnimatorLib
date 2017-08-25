# AnimatorLib
贝塞尔曲线属性动画的封装。

## Usage in activity

```java
@Override
    public void onClick(View view) {
        AnimatorPath path = new AnimatorPath.Builder()
                .moveTo(0, 0)
                .quadTo(-300, 800, -600, 0)
                .lineTo(0, 0)
                .cubicTo(-200, 200, -400, 100, -600, 0)
                .lineTo(0, 0)
                .build();
        ObjectAnimator animator = ObjectAnimator
                .ofObject(this, "location", new PathEvaluator(), path.getPoints())
                .setDuration(4000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    public void setLocation(PathPoint p) {
        textView.setTranslationX(p.x);
        textView.setTranslationY(p.y);
    }
```

