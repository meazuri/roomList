package com.seintbo.roomlisting

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        //val recyclerView = findViewById(R.id.recyclerViewCities) as RecyclerView
        val rdoGroup = findViewById<RadioGroup>(R.id.radioLayout)
        val byRoomLayout = findViewById<ConstraintLayout>(R.id.byRoom)
        val byRateLayout =findViewById<ConstraintLayout>(R.id.byRate)
        rdoGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.byRoomBtn -> {
                    byRoomLayout.visibility = View.VISIBLE
                    byRateLayout.visibility = View.GONE

                }
                R.id.byRateBtn -> {
                    byRoomLayout.visibility = View.GONE
                    byRateLayout.visibility = View.VISIBLE
                }
            }
        })



        val mcarouselAdapter = CarouselPagerAdapter(context = this)
        mcarouselAdapter.setListingImages(createDemoData())
        viewPager.adapter = mcarouselAdapter




    }
    fun  createDemoData():List<ListingImage>{
        val listingImages = ArrayList<ListingImage>()
        listingImages.add(ListingImage("1", R.drawable.carousel_1))
        listingImages.add((ListingImage("2", R.drawable.carousel_2)))
        listingImages.add((ListingImage("3", R.drawable.carousel_3)))
        return listingImages;

    }
}