package com.paipbook.app.modules.livrosrecomendados.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.livrosrecomendados.`data`.model.LivrosRecomendadosModel
import org.koin.core.KoinComponent

class LivrosRecomendadosVM : ViewModel(), KoinComponent {
  val livrosRecomendadosModel: MutableLiveData<LivrosRecomendadosModel> =
      MutableLiveData(LivrosRecomendadosModel())

  var navArguments: Bundle? = null
}
