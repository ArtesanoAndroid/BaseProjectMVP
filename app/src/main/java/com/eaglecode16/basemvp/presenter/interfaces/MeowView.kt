package com.eaglecode16.basemvp.presenter.interfaces

interface MeowView {

    fun showLoading()
    fun hideLoading()
    fun onSuccess(url: String)
    fun onFailure(msg: String)
}