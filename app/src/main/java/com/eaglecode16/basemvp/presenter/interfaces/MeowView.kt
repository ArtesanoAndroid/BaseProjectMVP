package com.eaglecode16.basemvp.presenter.interfaces

import com.eaglecode16.basemvp.presenter.interfaces.base.BaseView

interface MeowView: BaseView {

    fun onSuccess(url: String)
    fun onFailure(msg: String)
}