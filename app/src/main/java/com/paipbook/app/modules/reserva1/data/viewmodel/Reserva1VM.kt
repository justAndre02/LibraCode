package com.paipbook.app.modules.reserva1.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.reserva1.`data`.model.Reserva1Model
import org.koin.core.KoinComponent

class Reserva1VM : ViewModel(), KoinComponent {
  val reserva1Model: MutableLiveData<Reserva1Model> = MutableLiveData(Reserva1Model())

  var navArguments: Bundle? = null
}
