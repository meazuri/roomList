package com.seintbo.roomlisting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter


/**
 * Created by Seint San Thandar Bo on 1/7/20.
 */
class CarouselPagerAdapter constructor(context: Context) : PagerAdapter() {

    private var listingImages : List<ListingImage> = mutableListOf()
    private val mContext: Context = context

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return  view == `object`
    }

    override fun getCount(): Int {
        return  listingImages.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val adv = listingImages.get(position)
        val inflater = LayoutInflater.from(mContext)
        val layout =
            inflater.inflate( R.layout.carousel_view, container, false) as ViewGroup

        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(mContext.resources.getDrawable(adv.image) )
        container.addView(layout)

        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    fun setListingImages(listingImages: List<ListingImage>){
        this.listingImages = listingImages
        notifyDataSetChanged()
    }
}