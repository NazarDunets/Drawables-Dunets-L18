package com.example.drawables_dunets_l18

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUMBER_OF_TABS = 3

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = NUMBER_OF_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BasicDrawablesFragment.newInstance()
            1 -> BitmapFragment.newInstance()
            2 -> GlideTestFragment.newInstance()
            else -> Fragment()
        }
    }
}