package ayds.lisboa1.lastfm

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
    override val logoUrl: String
): ArtistBiography {}

object EmptyArtistBiography : ArtistBiography {
    override val artist: String = ""
    override val biography: String = ""
    override val articleUrl: String = ""
    override val logoUrl: String = ""
}
