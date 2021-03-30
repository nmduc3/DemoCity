package com.example.democity.listcity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.democity.base.BaseFragment
import com.example.democity.common.EventObserver
import com.example.democity.databinding.FragmentListCityBinding
import com.example.democity.extension.fragmentInflate
import com.example.democity.extension.showIf
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCityFragment : BaseFragment<FragmentListCityBinding, ListCityViewModel>() {
    override val inflater = fragmentInflate(FragmentListCityBinding::inflate)

    override val viewModel by viewModel<ListCityViewModel>()

    private val adapter by lazy {
        ListCityAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            rvLocation.run {
                layoutManager = LinearLayoutManager(context)
                adapter = this@ListCityFragment.adapter
            }
        }
        viewModel.apply {
            resultObserver.observe(viewLifecycleOwner, EventObserver {
                binding?.tvEmpty?.showIf(it.isNullOrEmpty())
                adapter.submitList(it)
            })
        }
    }
}
