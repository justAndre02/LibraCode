package com.paipbook.app.modules.perfil.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityPerfilBinding
import com.paipbook.app.modules.perfil.`data`.viewmodel.PerfilVM
import com.paipbook.app.modules.pginainicial.ui.PGinaInicialActivity
import kotlin.String
import kotlin.Unit

class PerfilActivity : BaseActivity<ActivityPerfilBinding>(R.layout.activity_perfil) {
  private val viewModel: PerfilVM by viewModels<PerfilVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.perfilVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSalvarAlteraes.setOnClickListener {
      val destIntent = PGinaInicialActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PERFIL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PerfilActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
