package comulez.github.animatorlibrary;

import java.util.ArrayList;

/**
 * Created by Ulez on 2017/8/24.
 * Email：1104128773@qq.com
 */

public class AnimatorPath {

    private ArrayList<PathPoint> points = new ArrayList<>();

    public void add(PathPoint pathPoint) {
        points.add(pathPoint);
    }

    public Object[] getPoints() {
        return points.toArray();
    }

    public static class Builder {

        private AnimatorPath animatorPath = new AnimatorPath();

        public Builder moveTo(float x, float y) {
            animatorPath.add(PathPoint.moveTo(x, y));
            return this;
        }


        /**
         * 直线平移
         *
         * @param endX
         * @param endY
         */
        public Builder lineTo(float endX, float endY) {
            animatorPath.add(PathPoint.lineTo(endX, endY));
            return this;
        }

        /**
         * 二阶贝塞尔曲线
         * (x1,y1) 为控制点，(x2,y2)为结束点。
         *
         * @param x1
         * @param y1
         * @param x2
         * @param y2
         */
        public Builder quadTo(float x1, float y1, float x2, float y2) {
            animatorPath.add(PathPoint.quadTo(x1, y1, x2, y2));
            return this;
        }

        /**
         * 三阶贝塞尔曲线
         * (x1,y1) 为控制点，(x2,y2)为控制点，(x3,y3) 为结束点。
         *
         * @param x1
         * @param y1
         * @param x2
         * @param y2
         * @param x3
         * @param y3
         */
        public Builder cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
            animatorPath.add(PathPoint.cubicTo(x1, y1, x2, y2, x3, y3));
            return this;
        }


        public AnimatorPath build() {
            return animatorPath;
        }
    }
}
