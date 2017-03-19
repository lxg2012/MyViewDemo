package app.lixian.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import bean.PieBean;
import widget.PieView;

public class PieActivity extends AppCompatActivity {

    private final int[] colors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000,
            0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private PieView mPieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        mPieView = (PieView)findViewById(R.id.pieview);
        init();
    }

    private void init() {
        ArrayList<PieBean> pieBeen = new ArrayList<>();
        for (int i = 0;i<9;i++){
            pieBeen.add(new PieBean(i+1,colors[i]));
        }
        mPieView.setData(pieBeen);
    }
}
