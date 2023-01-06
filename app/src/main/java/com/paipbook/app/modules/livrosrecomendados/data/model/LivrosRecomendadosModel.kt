package com.paipbook.app.modules.livrosrecomendados.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class LivrosRecomendadosModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPDM: String? = MyApp.getInstance().resources.getString(R.string.lbl_pdm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTopThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_top_3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_nome_android)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_nome_kotlin_in)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_nome_head_firs)

)
