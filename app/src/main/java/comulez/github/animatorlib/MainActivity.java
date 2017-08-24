package comulez.github.animatorlib;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import comulez.github.animatorlibrary.AnimatorPath;
import comulez.github.animatorlibrary.PathEvaluator;
import comulez.github.animatorlibrary.PathPoint;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        textView.setOnClickListener(this);
    }


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
        Log.i(TAG, p.x + ":" + p.y);
        textView.setTranslationX(p.x);
        textView.setTranslationY(p.y);
    }
}
