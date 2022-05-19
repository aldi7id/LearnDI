package com.ajgroup.learndi.di

import com.ajgroup.learndi.data.Repository
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

val repositoryModule = module {
    singleOf(::Repository)
}