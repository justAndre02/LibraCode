package com.paipbook.app.modules.reserva2.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.reserva2.`data`.model.Reserva2Model
import org.koin.core.KoinComponent

class Reserva2VM : ViewModel(), KoinComponent {
  val reserva2Model: MutableLiveData<Reserva2Model> = MutableLiveData(Reserva2Model())

  var navArguments: Bundle? = null
}
