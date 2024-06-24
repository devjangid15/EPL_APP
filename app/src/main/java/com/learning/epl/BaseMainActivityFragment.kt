package com.learning.epl

import androidx.fragment.app.Fragment

abstract class BaseMainActivityFragment(layoutId:Int) :Fragment(layoutId) {
    val mainActivity:MainActivity by lazy {
        (activity as MainActivity)
    }
}