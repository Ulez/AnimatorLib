package comulez.github.animatorlibrary;

import android.animation.TypeEvaluator;

/**
 * Created by Ulez on 2017/8/24.
 * Email：1104128773@qq.com
 */

public class PathEvaluator implements TypeEvaluator<PathPoint> {

    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x, y;
        float T = 1 - t;
        if (endValue.mOperation == PathPoint.CUBIC) {
            x = T * T * T * startValue.x + 3 * t * T * T * endValue.mControlX1 + 3 * t * t * T * endValue.mControlX2 + t * t * t * endValue.x;
            y = T * T * T * startValue.y + 3 * t * T * T * endValue.mControlY1 + 3 * t * t * T * endValue.mControlY2 + t * t * t * endValue.y;
        } else if (endValue.mOperation == PathPoint.QUAD) {
            x = T * T * startValue.x + 2 * T * t * endValue.mControlX1 + t * t * endValue.x;
            y = T * T * startValue.y + 2 * T * t * endValue.mControlY1 + t * t * endValue.y;
        } else if (endValue.mOperation == PathPoint.LINE) {
            x = T * startValue.x + t * endValue.x;
            y = T * startValue.y + t * endValue.y;
        } else {
            x = endValue.x;
            y = endValue.y;
        }
        return PathPoint.moveTo(x, y);
    }
}
