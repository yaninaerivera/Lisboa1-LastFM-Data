package ayds.lisboa1.lastfm

import com.google.gson.JsonObject
import com.google.gson.Gson

interface LastFMToArtistBiographyResolver {
    fun getArtistBiographyFromExternalData(serviceData:String?): LastFMArtistBiography?
}

private const val ARTIST = "artist"
private const val ARTIST_NAME = "name"
private const val ARTIST_BIOGRAPHY = "bio"
private const val ARTIST_BIOGRAPHY_EXTRACT = "content"
private const val ARTIST_BIOGRAPHY_URL = "url"

internal class JsonToArtistBiographyResolver(): LastFMToArtistBiographyResolver {

    override fun getArtistBiographyFromExternalData(serviceData: String?): LastFMArtistBiography? =
        try {
            serviceData?.getItem()?.let { item ->
                LastFMArtistBiography(
                    item.getArtist(), item.getBiography(),  item.getUrl()
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getItem(): JsonObject {
        val jobj = Gson().fromJson(this, JsonObject::class.java)
        return jobj[ARTIST].asJsonObject
    }


    private fun JsonObject.getArtist(): String {
        return this[ayds.lisboa1.lastfm.ARTIST_NAME].asString
    }

    private fun JsonObject.getBiography(): String {
        val bio = this[ayds.lisboa1.lastfm.ARTIST_BIOGRAPHY].asJsonObject
        return bio[ayds.lisboa1.lastfm.ARTIST_BIOGRAPHY_EXTRACT].asString
    }

    private fun JsonObject.getUrl(): String {
        return this[ayds.lisboa1.lastfm.ARTIST_BIOGRAPHY_URL].asString
    }

}

