package com.paipbook.app.modules.reserva2.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class Reserva2Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtReserva: String? = MyApp.getInstance().resources.getString(R.string.lbl_reserva)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_nome_uma_avemt)

)
