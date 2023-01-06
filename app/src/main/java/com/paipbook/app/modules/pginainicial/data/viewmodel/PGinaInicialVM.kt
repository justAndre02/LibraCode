package com.paipbook.app.modules.pginainicial.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.pginainicial.`data`.model.PGinaInicialModel
import org.koin.core.KoinComponent

class PGinaInicialVM : ViewModel(), KoinComponent {
  val pGinaInicialModel: MutableLiveData<PGinaInicialModel> = MutableLiveData(PGinaInicialModel())

  var navArguments: Bundle? = null
}
