package com.bogomolov.findfilm.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
/*
Класс-адаптер для ViewPager
 */
class MoviePagerAdapter(
    fragment: Fragment,
    private val fragmentList: List<Pair<Fragment, String>>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position].first
    }
}