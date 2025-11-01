package id.my.sendiko.roominkmp.roominkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform