package com.paipbook.app.modules.salasdeestudo.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class SalasDeEstudoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLogin: String? = MyApp.getInstance().resources.getString(R.string.lbl_salas_de_estudo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSala116luga: String? = MyApp.getInstance().resources.getString(R.string.msg_sala_1_16_luga)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSala116lugaOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_sala_2_4_lugar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSala116lugaTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_sala_3_4_lugar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSala116lugaThree: String? =
      MyApp.getInstance().resources.getString(R.string.msg_sala_4_4_lugar)

)
