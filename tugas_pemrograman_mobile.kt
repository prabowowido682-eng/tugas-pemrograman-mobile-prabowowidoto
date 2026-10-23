class StudentCard(
    val nim: String,
    var nama: String,
    val prodi: String
) {
    var totalSks: Int = 0
        private set

    val status: String
        get() = if (totalSks > 0) "Aktif" else "Baru"

    init {
        require(nim.length >= 7) { "NIM tidak valid" }
    }

    fun ambilSks(jumlah: Int) {
        if (jumlah > 0 && totalSks + jumlah <= 24) {
            totalSks += jumlah
        }
    }

    fun ringkasan() =
        "$nim · $nama · $prodi · $totalSks SKS"
}

fun main() {
    val daftar = listOf(
        StudentCard("2409020073", "Prabowo widoto", "pemrograman mobile"),
        StudentCard("2409020074", "Budi Santoso", "pemrograman mobile"),
        StudentCard("2409020075", "Citra Lestari", "pemrograman mobile"),
        StudentCard("2409020076", "Dimas Pratama", "pemrograman mobile")
    )

    daftar[0].ambilSks(6)
    daftar[1].ambilSks(9)
    daftar[2].ambilSks(0)   // tidak berubah karena jumlahnya 0
    daftar[3].ambilSks(24)
    daftar[3].ambilSks(1)   // ditolak karena melebihi 24

    for (kartu in daftar) {
        println(kartu.ringkasan())
        println("Status: ${kartu.status}")
        println()
    }
}