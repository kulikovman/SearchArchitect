package com.searcharchitect.one.navigation

import androidx.navigation.NavController
import com.searcharchitect.one.R
import javax.inject.Inject

interface INavigator {

    fun setNavController(navController: NavController)

    fun goBack()

    fun actionSplashToSearch()
    fun actionSplashToError()
    fun actionSplashToLogin()
    fun actionLoginToSearch()
    fun actionSearchToDetail()
    fun actionSearchToIndoDialog()

}

class Navigator @Inject constructor(

) : INavigator {

    private var navController: NavController? = null


    override fun setNavController(navController: NavController) {
        this.navController = navController
    }


    override fun goBack() {
        navController?.navigateUp()
    }

    override fun actionSplashToSearch() {
        navController?.navigate(R.id.action_splashFragment_to_searchFragment)
    }

    override fun actionSplashToError() {
        navController?.navigate(R.id.action_splashFragment_to_errorFragment)
    }

    override fun actionSplashToLogin() {
        navController?.navigate(R.id.action_splashFragment_to_loginFragment)
    }

    override fun actionLoginToSearch() {
        navController?.navigate(R.id.action_loginFragment_to_searchFragment)
    }

    override fun actionSearchToDetail() {
        navController?.navigate(R.id.action_searchFragment_to_detailFragment)
    }

    override fun actionSearchToIndoDialog() {
        navController?.navigate(R.id.action_searchFragment_to_infoDialogFragment)
    }

}