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
private const val SERVICE_LOGO_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"

internal class JsonToArtistBiographyResolver(): LastFMToArtistBiographyResolver {

    override fun getArtistBiographyFromExternalData(serviceData: String?): LastFMArtistBiography? =
        try {
            serviceData?.getItem()?.let { item ->
                LastFMArtistBiography(
                    item.getArtist(), item.getBiography(),  item.getArticleUrl(), getLogoUrl()
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
        return this[ARTIST_NAME].asString
    }

    private fun JsonObject.getBiography(): String {
        val bio = this[ARTIST_BIOGRAPHY].asJsonObject
        return bio[ARTIST_BIOGRAPHY_EXTRACT].asString
    }

    private fun JsonObject.getArticleUrl(): String {
        return this[ARTIST_BIOGRAPHY_URL].asString
    }

    private fun getLogoUrl(): String {
        return SERVICE_LOGO_URL
    }

}

