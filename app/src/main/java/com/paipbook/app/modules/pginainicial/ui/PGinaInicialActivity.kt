package com.paipbook.app.modules.pginainicial.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityPGinaInicialBinding
import com.paipbook.app.modules.perfil.ui.PerfilActivity
import com.paipbook.app.modules.pginainicial.`data`.viewmodel.PGinaInicialVM
import com.paipbook.app.modules.reserva1.ui.Reserva1Activity
import com.paipbook.app.modules.salasdeestudo.ui.SalasDeEstudoActivity
import kotlin.String
import kotlin.Unit

class PGinaInicialActivity :
    BaseActivity<ActivityPGinaInicialBinding>(R.layout.activity_p_gina_inicial) {
  private val viewModel: PGinaInicialVM by viewModels<PGinaInicialVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.pGinaInicialVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearButton.setOnClickListener {
      val destIntent = PerfilActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearButton1.setOnClickListener {
      val destIntent = SalasDeEstudoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearButton2.setOnClickListener {
      val destIntent = Reserva1Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "P_GINA_INICIAL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PGinaInicialActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
