package comulez.github.animatorlibrary;

/**
 * Created by Ulez on 2017/8/24.
 * Email：1104128773@qq.com
 */

public class PathPoint {

    public static final int MOVE = 1;
    public static final int LINE = 2;//直线平移，2个点确定直线；0个控制点
    public static final int QUAD = 3;//二阶贝塞尔曲线,3个点确定曲线；1个控制点
    public static final int CUBIC = 4;//三阶贝塞尔曲线，4个点确定曲线；2个控制点

    public float x;
    public float y;

    public int mOperation;

    public float mControlX1;
    public float mControlY1;

    public float mControlX2;
    public float mControlY2;

    private PathPoint(int mOperation, float x, float y) {
        this.mOperation = mOperation;
        this.x = x;
        this.y = y;
    }

    private PathPoint(int mOperation, float x1, float y1, float x2, float y2) {
        this.mOperation = mOperation;
        this.mControlX1 = x1;
        this.mControlY1 = y1;
        this.x = x2;
        this.y = y2;
    }

    private PathPoint(int mOperation, float x1, float y1, float x2, float y2, float endX, float endY) {
        this.mOperation = mOperation;
        mControlX1 = x1;
        mControlY1 = y1;
        mControlX2 = x2;
        mControlY2 = y2;
        this.x = endX;
        this.y = endY;
    }

    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }

    public static PathPoint lineTo(float endX, float endY) {
        return new PathPoint(LINE, endX, endY);
    }

    public static PathPoint quadTo(float x1, float y1, float x2, float y2) {
        return new PathPoint(QUAD, x1, y1, x2, y2);
    }

    public static PathPoint cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        return new PathPoint(CUBIC, x1, y1, x2, y2, x3, y3);
    }
}
