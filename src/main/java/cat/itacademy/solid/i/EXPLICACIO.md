# Anàlisis del MachineActions

És evident que tracta és un "fat interfície". ``AirConditioner`` i ``WashingMachine`` contentenen mètodes abstracts de la interfície que no fan res.

El que potser no és tan evident és la solució.
1. Solucio: atomitzar-ho només en interfícies petites.
2. Solucio: atomitzar-ho en una classe abstracta machine i les altres funcionalitats en interfícies petites.

En aquest exercici, s'ha pres la segona solució.