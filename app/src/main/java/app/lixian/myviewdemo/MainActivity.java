package app.lixian.myviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent= new Intent();
        intiAction();
       /* Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setAntiAlias(true);
        //防抖动
        paint.setDither(true);

        //用于封装x，y坐标
        PointF pointF = new PointF(100, 200);*/


    }

    private void intiAction() {
        findViewById(R.id.pie).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pie:
                loadPie();
                break;
        }
    }

    //饼状图
    private void loadPie() {
        mIntent.setClass(this,PieActivity.class);
        startActivity(mIntent);
    }

}
