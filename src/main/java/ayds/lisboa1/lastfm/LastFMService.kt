package ayds.lisboa1.lastfm

interface LastFMService {
    fun getArtistBio(artist : String) : LastFMArtistBiography?
}