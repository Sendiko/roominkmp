package id.my.sendiko.roominkmp.roominkmp.core.di

import id.my.sendiko.roominkmp.roominkmp.person.data.core.PeopleDao
import id.my.sendiko.roominkmp.roominkmp.person.data.getPeopleDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<PeopleDao> { getPeopleDatabase().peopleDao() }
    }