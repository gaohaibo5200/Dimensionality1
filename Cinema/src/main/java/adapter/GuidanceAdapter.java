package adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.cinema.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author：Y
 * @E-mail： 2447892835@qq.com
 * @Date：2019.5.10 11:54
 * @Description：YangXinYu
 */
public class GuidanceAdapter extends PagerAdapter {



    public String name [] = {"荡漾你的心灵","看遍人生百态","净化你的灵魂","带您开启一段美好的电影之旅"};
    public String names [] = {"一场电影","一场电影","一场电影","八维移动通信学院作品"};
    @BindView(R.id.guidance_image)
    ImageView guidanceImage;
    @BindView(R.id.guidance_name1)
    TextView guidanceName1;
    @BindView(R.id.guidance_name2)
    TextView guidanceName2;
    int[] image;
    public GuidanceAdapter(int[] image) {
        this.image = image;
    }


    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container,position,object); 这一句要删除，否则报错
        //111111111111111111111111111111111111111111111111111111111111111111111
        //医学影像实打实大萨达所大所大所安达市大所大所大所大所大萨达所大所多 阿迪达斯多
		//dasddasdasdasdasdsd十大奥所大所大a
		//有需要协议是吗
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.guidance, null);
        ButterKnife.bind(this,view);
        guidanceImage.setImageResource(image[position]);
        guidanceName1.setText(names[position]);
        guidanceName2.setText(name[position]);
        container.addView(view);
        return view;
    }
}
