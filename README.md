# Lisboa1-LastFM-Data

## Descripcion del servicio: 

getArtistBio(artist: String)

Dado el nombre de un artista devolverá la información consultada a la API de LastFM.
Esto devuelve una clase LastFMArtistBiography con las siguientes propiedades :

* Artist: String - representa el nombre de un artista

* Biography: String - representa la biografia del artista obtenida al consultar el servicio de LastFM

* Url: String - enlace de la biografia obtenida mediante el servicio de LastFM

En caso de resultado no encontrado, falta de conexión o excepción devuelve null.

## Referencia al servicio:

Agregar el submodulo al proyecto:

> git submodule add https://github.com/yaninaerivera/Lisboa1-LastFM-Data libs/LastFMData

Agregar al archivo settings.gradle del proyecto las siguientes lineas:

> include ':lastfmdata'
> project(':lastfmdata').projectDir = new File('libs/LastFMData')

Sincronizar gradle en el proyecto

Agregar al archivo build.gradle del proyecto la siguiente dependencia:

> implementation project(":lastfmdata")

Sincronizar gradle en el proyecto
