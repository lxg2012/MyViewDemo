package bean;

/**
 * Created by Administrator on 2017-3-20.
 */

public class PieBean {
    private float mPercent;
    private int color;

    public PieBean(float percent, int color) {
        mPercent = percent;
        this.color = color;
    }

    public float getPercent() {
        return mPercent;
    }

    public void setPercent(float percent) {
        mPercent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
