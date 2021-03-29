package com.example.democity

import android.os.Bundle
import androidx.core.view.ViewCompat
import com.example.democity.base.BaseActivity
import com.example.democity.databinding.ActivityMainBinding
import com.example.democity.extension.activityInflate
import com.example.democity.extension.disableMultipleClick
import com.example.democity.extension.toPx
import com.example.democity.listcity.ListCityFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override var inflater = activityInflate(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.run {
            ViewCompat.setTranslationZ(container, 4.toPx())
            btnListCity.disableMultipleClick {
                replaceFragment(ListCityFragment())
            }
        }
    }
}
