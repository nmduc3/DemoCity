package com.example.democity.listcity

import android.os.Bundle
import android.view.View
import com.example.democity.base.BaseFragment
import com.example.democity.databinding.FragmentListCityBinding
import com.example.democity.extension.fragmentInflate

class ListCityFragment : BaseFragment<FragmentListCityBinding>() {
    override val inflater = fragmentInflate(FragmentListCityBinding::inflate)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            
        }
    }
}
