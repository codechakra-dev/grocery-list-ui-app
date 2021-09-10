package com.codechakra.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.request.RequestOptions;
import com.codechakra.grocerylist.adapters.ParentRecyclerAdapter;
import com.codechakra.grocerylist.models.exclusiveItem;
import com.codechakra.grocerylist.models.parentItem;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.animations.DescriptionAnimation;
import com.glide.slider.library.slidertypes.BaseSliderView;
import com.glide.slider.library.slidertypes.TextSliderView;
import com.glide.slider.library.tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView parent_reyclerview;
    ParentRecyclerAdapter mParentAdapter;
    List<exclusiveItem> exclusiveofferlist;
    List<exclusiveItem> grocerylist;
    List<exclusiveItem> bestselling;
    private SliderLayout mDemoSlider;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.white));
        parent_reyclerview = findViewById(R.id.parent_recyclerview);
        imageSet();
        List<parentItem> parentItemsList = new ArrayList<>();
        setLists();
        parentItem item1 = new parentItem("Exclusive offers",exclusiveofferlist);
        parentItem item2 = new parentItem("Groceries",grocerylist);
        parentItem item3 = new parentItem("Best selling",bestselling);
        parentItemsList.add(item1);
        parentItemsList.add(item2);
        parentItemsList.add(item3);
        mParentAdapter = new ParentRecyclerAdapter(parentItemsList);
        parent_reyclerview.setAdapter(mParentAdapter);
        parent_reyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setLists() {
        //Drawable drawable, String itemName, String item_piece, String item_price, int item_counter
        exclusiveofferlist = new ArrayList<>();
        Drawable bananadraw = AppCompatResources.getDrawable(this, R.drawable.apple);
        Drawable orangedraw = AppCompatResources.getDrawable(this, R.drawable.oranger);
        Drawable appledraw = AppCompatResources.getDrawable(this, R.drawable.apple);
        //grocery
        Drawable masurdal = AppCompatResources.getDrawable(this, R.drawable.masurdal);
        Drawable rice = AppCompatResources.getDrawable(this, R.drawable.ricebag);

        exclusiveofferlist.add(new exclusiveItem(bananadraw, "Apple", "7pcs,price", "$4.99", 0));
        exclusiveofferlist.add(new exclusiveItem(orangedraw, "Orange", "7pcs,price", "$4.99", 0));
        exclusiveofferlist.add(new exclusiveItem(appledraw, "Apple", "7pcs,price", "$4.99", 0));
//grocerylist
        grocerylist = new ArrayList<>();
        grocerylist.add(new exclusiveItem(masurdal, "Pulses", "1kg,price", "$4.99", 0));
        grocerylist.add(new exclusiveItem(rice, "Rice", "1kg,price", "$4.99", 0));
        grocerylist.add(new exclusiveItem(masurdal, "Pulses", "1kg,price", "$4.99", 0));

        bestselling=new ArrayList<>();

        bestselling.add(new exclusiveItem(bananadraw, "Apple", "7pcs,price", "$4.99", 0));
        bestselling.add(new exclusiveItem(orangedraw, "Orange", "7pcs,price", "$4.99", 0));
        bestselling.add(new exclusiveItem(appledraw, "Apple", "7pcs,price", "$4.99", 0));
//grocerylist
    }
//
    public void imageSet(){
        mDemoSlider = findViewById(R.id.slider);

        ArrayList<String> listUrl = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();

        listUrl.add(String.valueOf(R.drawable.firstoffer));
        listName.add("JPG - Github");

        listUrl.add(String.valueOf(R.drawable.secondoffer));
        listName.add("PNG - Android Studio");

        listUrl.add(String.valueOf(R.drawable.thirdoffer));
        listName.add("GIF - Disney");



        RequestOptions requestOptions = new RequestOptions();
       //requestOptions.centerCrop();
        //.diskCacheStrategy(DiskCacheStrategy.NONE)
        //.placeholder(R.drawable.placeholder)
        //.error(R.drawable.placeholder);

        for (int i = 0; i < listUrl.size(); i++) {
            TextSliderView sliderView = new TextSliderView(this);
            // if you want show image only / without description text use DefaultSliderView instead

            // initialize SliderLayout

            sliderView
                    .image(Integer.parseInt(listUrl.get(i)))

                    .setRequestOption(requestOptions.centerCrop())
                    .setProgressBarVisible(true)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                        }
                    });

            //add your extra information
            sliderView.bundle(new Bundle());
            sliderView.getBundle().putString("extra", listName.get(i));
            mDemoSlider.addSlider(sliderView);
        }

        // set Slider Transition Animation
        // mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);

        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mDemoSlider.stopCyclingWhenTouch(false);
    }
}