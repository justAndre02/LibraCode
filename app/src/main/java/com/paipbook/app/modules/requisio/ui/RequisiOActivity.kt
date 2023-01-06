package com.paipbook.app.modules.requisio.ui

import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityRequisiOBinding
import com.paipbook.app.modules.requisio.`data`.viewmodel.RequisiOVM
import com.paipbook.app.modules.reserva1.ui.Reserva1Activity
import kotlin.String
import kotlin.Unit

class RequisiOActivity : BaseActivity<ActivityRequisiOBinding>(R.layout.activity_requisi_o) {
  private val viewModel: RequisiOVM by viewModels<RequisiOVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.requisiOVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = Reserva1Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
      finish()
    }
  }

  companion object {
    const val TAG: String = "REQUISI_O_ACTIVITY"

  }
}
