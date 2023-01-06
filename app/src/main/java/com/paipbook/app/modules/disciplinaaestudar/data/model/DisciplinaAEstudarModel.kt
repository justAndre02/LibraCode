package com.paipbook.app.modules.disciplinaaestudar.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class DisciplinaAEstudarModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSelecioneadis: String? =
      MyApp.getInstance().resources.getString(R.string.msg_selecione_a_dis)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUmaAventura: String? = MyApp.getInstance().resources.getString(R.string.lbl_pro)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUmaAventuraem: String? =
      MyApp.getInstance().resources.getString(R.string.msg_programa_o_ori)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupElevenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFiveValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSevenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupNineValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirteenValue: String? = null
)
