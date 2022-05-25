package ayds.lisboa1.lastfm

import ayds.lisboa.songinfo.otherdetails.model.entities.LastFMArtistBiography

interface LastFMService {
    fun getArtistBio(artist : String) : LastFMArtistBiography?
}