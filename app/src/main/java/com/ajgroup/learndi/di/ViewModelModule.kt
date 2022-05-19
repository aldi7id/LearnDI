package com.ajgroup.learndi.di

import com.ajgroup.learndi.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainActivityViewModel)
}
