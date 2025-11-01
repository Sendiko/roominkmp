package id.my.sendiko.roominkmp.roominkmp.core.di

import id.my.sendiko.roominkmp.roominkmp.person.data.datasource.PersonDataSource
import id.my.sendiko.roominkmp.roominkmp.person.data.datasource.PersonDataSourceImpl
import id.my.sendiko.roominkmp.roominkmp.person.data.repositories.PersonRepositoryImpl
import id.my.sendiko.roominkmp.roominkmp.person.domain.PersonRepository
import id.my.sendiko.roominkmp.roominkmp.person.presentation.PeopleViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModules = module {
    singleOf(::PersonDataSourceImpl).bind<PersonDataSource>()
    singleOf(::PersonRepositoryImpl).bind<PersonRepository>()

    factory { PeopleViewModel(get()) }
}