package id.my.sendiko.roominkmp.roominkmp

import android.app.Application
import id.my.sendiko.roominkmp.roominkmp.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class RoomInKmpApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@RoomInKmpApp)
        }
    }
}