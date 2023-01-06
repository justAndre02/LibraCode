package com.paipbook.app.modules.salasdeestudo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.salasdeestudo.`data`.model.SalasDeEstudoModel
import org.koin.core.KoinComponent

class SalasDeEstudoVM : ViewModel(), KoinComponent {
  val salasDeEstudoModel: MutableLiveData<SalasDeEstudoModel> =
      MutableLiveData(SalasDeEstudoModel())

  var navArguments: Bundle? = null
}
