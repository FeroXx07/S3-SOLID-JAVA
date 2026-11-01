# Anàlisis del InstrumentPlayer

Per cada instrument nou que s'ha d'afegir al programa, és necessari modificar la classe Instrument Player.
A més d'això, exposa la lògica interna de cada instrument.

La solució és aplicar el principi ``O`` de ``SOLID``. ``Open/Closed Principle (OCP)``.
És a dir, obert a noves extensions i tancat a modificacions.

Una interfici ``Instrument`` amb un contracte, i una altra classe que rep el contracte ``InstrumentPlayer`` i en fa us.