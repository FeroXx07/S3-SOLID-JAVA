# Anàlisis del programa "BookingApp"

## Anàlisis Persistence BookingApp  
Les operacions que es necessiten sobre les reserves són de tipus `CRUD` .

Només que `CRU` són majoritàriament simples mentre que la `D` (cancellation) té una regla de negoci/servei per poder-ho processar.
Les `CRU` es troben dins dels repositoris mentre que la `D` (cancellation) és al `ConcreteBookingService`.

Tot i que el mòdul d'alt nivell ``ConcreteBookingService`` rep el repositori per constructor, aquest no és una abstracció, 
per tant, està directament lligada a la implementació del mòdul baix nivell del repositori, en aquest cas H2 (SQL).
Resumidament, tot i contenir quasi les mateixes operacions i mètode, no estan abstractes en un contracte comú, per tant, no hi existeix interoperabilitat.

Al moment d'inicialitzar i construir l'aplicació és quan s'ha de decidir quina implementació concreta utilitzar, utilitzant la injecció de dependència.

## Proposta de refactoració
Per poder aplicar correctament el principi d'inversió de dependències, es necessita estrictament un contracte per al repositori, i un altre menys crític per al servei, si cal.
- Creació Interfície que defineix accessos publics per operacions CREATE, READ, UPDATE
- Creació Servei que defineix accessos amb regles de negoci/servei incrustades dins de Cancellation (Delete)
- Servei rep en el moment de la construcció la interfície que apunta a la implementació concreta i la desa com a variable.
- BookingConsole, per tant, crida les operacions sense saber la lògica interna de la persistència hi ha al darrere.

## Anàlisis Post-refactoració
- S'han afegit tots els punts de la proposta:
  - Interfície ``BookingRepository`` que abstrau les operacions CRU del tipus de persistència.
  - Interfície ``BookingService`` que incorpora contractes publics per operacions amb regles de serveis.
  - Aplicació del DI per a que classes com ``BookingService`` i ```BookingConsole``` reben externament les dependencies.
  - Aplicació del DIP per crear contractes comúns i permetre interoperabilitat amb diferents repositoris i serveis.