package com.paipbook.app.modules.reserva1.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class Reserva1Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtReserva: String? = MyApp.getInstance().resources.getString(R.string.lbl_reserva)

)
