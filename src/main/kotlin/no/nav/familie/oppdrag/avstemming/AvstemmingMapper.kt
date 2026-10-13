package no.nav.familie.oppdrag.avstemming

import java.nio.ByteBuffer
import java.util.Base64
import java.util.UUID

object AvstemmingMapper {
    fun encodeUUIDBase64(uuid: UUID): String {
        val bb = ByteBuffer.wrap(ByteArray(16))
        bb.putLong(uuid.mostSignificantBits)
        bb.putLong(uuid.leastSignificantBits)
        return Base64.getUrlEncoder().encodeToString(bb.array()).substring(0, 22)
    }

    fun fagområdeTilAvleverendeKomponentKode(fagområde: String): String =
        // TODO Hva er vår koder og fagområder for oss?
        when (fagområde) {
            "GH" -> "GH"
            else -> throw Error("$fagområde støttes ikke ennå")
        }
}

enum class SystemKode(
    val kode: String,
) {
    OPPDRAGSSYSTEMET("OS"),
}
