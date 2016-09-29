package qianfeng.viewpager2_application;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp2;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVp1();
        initVp2();

    }

    private void initVp1()
    {

    }

    private void initVp2()
    {
        vp2 = ((ViewPager) findViewById(R.id.vp2));
        list = new ArrayList<>();
        list.add("http://n.sinaimg.cn/tech/transform/20160912/KJG5-fxvukhz1637041.png");
        list.add("http://img.firefoxchina.cn/2016/09/8/201609131034470.jpg");
        list.add("http://cms-bucket.nosdn.127.net/catchpic/f/fa/faa3de33cfa207cf4be09198562a11e3.jpg");
        list.add("http://article.fd.zol-img.com.cn/t_s640x2000/g5/M00/04/07/ChMkJ1fWFCSIZclYAAIM4EBQLGMAAVO0wEyO1IAAgz4003.jpg");
        list.add("http://a4.peoplecdn.cn/542fa0bb1ecce403130db74135dc958d.jpg");
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, list);
        vp2.setAdapter(myPagerAdapter);
    }

}
