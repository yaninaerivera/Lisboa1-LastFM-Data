package ayds.lisboa1.lastfm

private const val LASTFM_LOGO_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"

interface ArtistBiography{
    val artist: String
    val biography: String
    val articleUrl: String
    val logoUrl: String
}

data class LastFMArtistBiography(
    override val artist: String,
    override val biography: String,
    override val articleUrl: String,
    override val logoUrl: String = LASTFM_LOGO_URL
): ArtistBiography {}

object EmptyArtistBiography : ArtistBiography {
    override val artist: String = ""
    override val biography: String = ""
    override val articleUrl: String = ""
    override val logoUrl: String = ""
}
