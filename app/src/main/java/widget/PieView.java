package widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import bean.PieBean;

/**
 * 饼状图
 *   //实现步骤......
 *   1.内侧扇形
 *   2.中间线段分割
 *   3.外侧文本提示
 *
 */

public class PieView extends View {

    private ArrayList<PieBean> mPieList;
    private int mWidth;
    private int mHeight;
    private int mRadius;

    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inti(context);
    }

    private float mTotalValue;
    public void setData(ArrayList<PieBean> mPieList){
        this.mPieList = mPieList;
        for (PieBean pieBean:mPieList
                ) {
            mTotalValue = mTotalValue+pieBean.getPercent();
        }
    }

    private void inti(Context context) {
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        this.mWidth = displayMetrics.widthPixels/2;
        this.mHeight = displayMetrics.heightPixels/2;*/
        mRectf = new RectF();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPath = new Path();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true); //防抖动
    }

    //扇形外接矩形坐标
    private RectF mRectf ;

    //尺寸决定好完成后调用
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //match parent
        this.mWidth = w;
        this.mHeight = h;
        mRadius = (int) (Math.min(mWidth, mHeight) * 0.7f / 2);
        mRectf.left = -mRadius;
        mRectf.top = -mRadius;
        mRectf.right = mRadius;
        mRectf.bottom = mRadius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //做一个居中的扇形，需处理的坐标
        canvas.save();
        canvas.translate(mWidth,mHeight);
        drawPie(canvas);
        canvas.restore();

    }

    private Path mPath;
    private Paint mPaint;
    /**
     * 绘制扇形
     * @param canvas
     */
    private void drawPie(Canvas canvas) {
        if (mPieList == null){return;}
        float startAngle = 0;
        for (PieBean pieBean:mPieList
             ) {
            //相对画布path的坐标
            mPath.moveTo(0,0);
            float swipeAngle = pieBean.getPercent()/mTotalValue*360;//扇形角度
            mPaint.setColor(pieBean.getColor());
            mPath.arcTo(mRectf,startAngle,swipeAngle);
            canvas.drawPath(mPath,mPaint);
            startAngle = swipeAngle+1;//扇形间隔
            //清楚path记录
            mPath.reset();
        }
    }
}
