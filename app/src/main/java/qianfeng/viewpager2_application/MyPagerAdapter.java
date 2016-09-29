package qianfeng.viewpager2_application;

import android.content.Context;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> list;

    public MyPagerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override // destroyItem方法不一定总比instantiateItem先执行
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object); // 移除掉 instantiateItem里面的 object
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view  = inflater.inflate(R.layout.item, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv); // 每次都加载布局文件，相当于每一次的ImageView都是新的，都是新new出来的，而不像上一个项目那样，是清理掉原来container里面填充好的图片，再加载一张新图片
        Picasso.with(context).load(list.get(position % list.size())).into(iv);

        container.addView(view); // 往ViewPager里面添加图片



        return view;

        // 也可以使用以下这种方式来做， ImageView imageView = new ImageView(context);




    }



    // 下面代码是递归删除
    private void deleteFile(String filePath)
    {
        String externalStorageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(externalStorageState)) // 如果SD卡挂载了
        {
            File filepath = new File(filePath);
            if(filepath.isDirectory())
            {
                // 如果是目录的话，先删除目录里面的文件和文件夹，最后退出for循环之后，里面的文件和文件夹都被删除了，退出for之后，要删除filepath这个目录
                File[] files = filepath.listFiles();
                for(File f : files)
                {
                    f.delete();
                }
                filepath.delete(); // 如果是目录的话，经历过for循环之后，最后删除剩空文件夹了，这个空文件夹也要删除，否则会影响下一级的删除。
            }else
            {
                filepath.delete(); // 如果不是目录就当是普通文件一样删除
            }



        }
    }

}
