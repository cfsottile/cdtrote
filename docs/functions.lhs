> data Dest = Dest Letter Arc
> type SubTrack = [Dest]
> type Track = [Subtrack]

Suponemos que `Letter` va a terminar siendo un decorator de la imagen de letra.

> runTrack :: Track -> IO ()

* situará al caballo en el medio
* runSubTrack (head track)

> runSubTrack :: SubTrack -> Horse -> IO ()

* dibujará la pista (vemos si es para todos o no)
* onclick en donde sea (para niveles avanzados, sólo en letras)

> onClickLetter :: Dest -> IO ()

* moveHorse(dest, horse)

> moveHorse :: Dest -> Horse -> IO ()

* chequear si el movimiento fue válido (en niveles avanzados); si se equivocó, indicarlo y volver al onclick
* calcula imagen correspondiente al caballo (usando la posición del caballo y el punto de destino)
* mueve al caballo en la pista


En el nivel 1, no importa en dónde haga click, por lo tanto el destino que se le pasa va a ser provisto por el programador

------------------------------------------------------

> nextImage :: Orientation -> Image
> orientationOf :: Point -> Point -> Orientation
> pointAt :: Int -> Point

