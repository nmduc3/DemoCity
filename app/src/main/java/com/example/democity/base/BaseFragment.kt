package com.example.democity.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.democity.R


abstract class BaseFragment<V : ViewBinding, VM : BaseViewModel> : Fragment() {
    abstract val inflater: (LayoutInflater, ViewGroup?, Boolean) -> V?

    abstract val viewModel: VM

    protected var binding: V? = null

    private var callBackWhenBackPress: OnBackPressedCallback = object : OnBackPressedCallback(
        false
        /** true means that the callback is enabled */
    ) {
        override fun handleOnBackPressed() {
            handleBackPressed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callBackWhenBackPress)
        observeLiveData()
    }

    override fun onResume() {
        super.onResume()
        callBackWhenBackPress.isEnabled = true
    }

    override fun onStop() {
        super.onStop()
        callBackWhenBackPress.isEnabled = false
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    open fun observeLiveData() {
        viewModel.run {
            progressLiveData().observe(viewLifecycleOwner) {
                // TODO: 3/30/21
            }
            errorLiveData().observe(viewLifecycleOwner) {
                // TODO: 3/30/21
            }
        }
    }

    protected open fun handleBackPressed() {
        if (parentFragmentManager.backStackEntryCount > 0)
            parentFragmentManager.popBackStack()
        else {
            (parentFragment as? BaseFragment<*, *>)?.handleBackPressed()
        }
    }

    protected fun replaceInParentManager(
        fragment: Fragment, isEnableAnim: Boolean = true,
        isAddBackStack: Boolean = true, tagNameBackStack: String? = null
    ) {
        parentFragmentManager.beginTransaction().apply {
            if (isEnableAnim) {
                setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
            }
            add(R.id.container, fragment, fragment.javaClass.name)
            if (isAddBackStack) {
                addToBackStack(tagNameBackStack)
            }
            commit()
        }
    }
}
