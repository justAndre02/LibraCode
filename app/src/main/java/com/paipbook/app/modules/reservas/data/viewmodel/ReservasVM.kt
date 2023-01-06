package com.paipbook.app.modules.reservas.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.reservas.`data`.model.ReservasModel
import org.koin.core.KoinComponent

class ReservasVM : ViewModel(), KoinComponent {
  val reservasModel: MutableLiveData<ReservasModel> = MutableLiveData(ReservasModel())

  var navArguments: Bundle? = null
}
