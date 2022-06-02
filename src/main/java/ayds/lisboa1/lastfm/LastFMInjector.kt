package ayds.lisboa1.lastfm

object LastFMInjector {

    private const val LASTFM_URL = "https://ws.audioscrobbler.com/2.0/"
    private val lastFMAPIRetrofit = Retrofit.Builder()
        .baseUrl(LASTFM_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val lastFMArtistAPI = lastFMAPIRetrofit.create(LastFMAPI::class.java)
    private val lastFMToArtistBiographyResolver: LastFMToArtistBiographyResolver = JsonToArtistBiographyResolver()

    val lastFMService: LastFMService = LastFMServiceImpl(
        lastFMToArtistBiographyResolver,
        lastFMArtistAPI,
    )
}