package com.paipbook.app.modules.perfil.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class PerfilModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDiana: String? = MyApp.getInstance().resources.getString(R.string.lbl_diana)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLEGI3ano: String? = MyApp.getInstance().resources.getString(R.string.lbl_legi_3_ano)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupOneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etComponentValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etComponentOneValue: String? = null
)
