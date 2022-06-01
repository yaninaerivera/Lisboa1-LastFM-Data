# Lisboa1-LastFM-Data

getArtistBio(artist: String)

Dado el nombre de un artista devolverá la información consultada a la API de LastFM.
Esto devuelve una clase LastFMArtistBiography con las siguientes propiedades :

-Artist: String - representa el nombre de un artista

-Biography: String - representa la biografia del artista obtenida al consultar el servicio de LastFM

-Url: String - enlace de la biografia obtenida mediante el servicio de LastFM

En caso de resultado no encontrado, falta de conexión o excepción devuelve null.