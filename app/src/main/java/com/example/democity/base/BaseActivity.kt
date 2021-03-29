package com.example.democity.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.democity.R

abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {
    abstract val inflater: (LayoutInflater) -> V?

    protected var binding: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    protected fun replaceFragment(
        fragment: Fragment,
        isAddToBackStack: Boolean = true,
        isEnableAnim: Boolean = true,
        tagNameBackStack: String? = null
    ) {
        supportFragmentManager.beginTransaction().apply {
            if (isEnableAnim) {
                setCustomAnimations(
                    R.anim.slide_in_right, R.anim.slide_out_left,
                    R.anim.slide_in_left, R.anim.slide_out_right
                )
            }
            replace(R.id.container, fragment, fragment.javaClass.name)
            if (isAddToBackStack) {
                addToBackStack(tagNameBackStack)
            }
            commit()
        }
    }
}
