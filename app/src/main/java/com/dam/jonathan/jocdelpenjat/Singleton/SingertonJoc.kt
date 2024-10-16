import com.dam.jonathan.jocdelpenjat.Partida

class SingertonJoc private constructor() {
    companion object {
     public lateinit var partida : Partida

        @Volatile
        private var instance: SingertonJoc? = null
        fun getInstance(): SingertonJoc {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = SingertonJoc()
                    }
                }
            }
            return instance!!
        }
    }




}