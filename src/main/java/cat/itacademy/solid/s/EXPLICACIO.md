# Anàlisis del programa "InvoiceApp"

## Identificació de les responsabilitats del `saveToFile()`
En el programa existeix una __estructura de dades__ en forma de Record: _InvoiceLine_.

Un __coordinador principal__ que inicialitza i crides les diferents funcionalitats per complir un objectiu: _InvoiceApp_. 

I finalment la classe per guardar l'estructura de dades: InvoiceService.

Però aquesta a més de desar, en aquest cas a un arxiu, també conte i fa altres responsabilitats:
- Calcular el total del _Invoice_.
  - ````java
      BigDecimal total = new BigDecimal("0.00");
          for (InvoiceLine line : invoice.lines()) {
              BigDecimal lineTotal = line.unitPrice()
                      .multiply(BigDecimal.valueOf(line.quantity()));
              total = total.add(lineTotal);
              [...]
- Serialitzar els continguts del _Invoice_ en un format determinat.
  - ````java
    String lineSeparator = System.lineSeparator();
        StringBuilder text = new StringBuilder();
        text.append("INVOICE").append(lineSeparator);
        text.append("Number: ").append(invoice.number()).append(lineSeparator);
        text.append("Customer: ").append(invoice.customerName()).append(lineSeparator);
        text.append(lineSeparator);

       [...]

        text.append(lineSeparator).append("TOTAL: ").append(total);
- Desar la serialització en arxiu.
  - ````java
      try {
            Files.writeString(destination, text.toString());
        } catch (IOException exception) {
            throw new UncheckedIOException(
                    "Could not save invoice: " + invoice.number(),
                    exception
            );
        }


## Proposta de refactoració
Perquè el mètode saveFile() sigui més llegible i compleixi el `Single Responsibility Principle`.
Cal delegar les responsabilitats:
- Una classe que tingui com a objectiu calcular els totals de l'Invoice Lines i el total final de Invoice.
  - Segons l'arquitectura de disseny que es vol, es pot, o no, incloure la regla de negoci del calculament a la mateixa entitat del domini.
- Una classe que tingui com a objectiu passar el contingut de l'objecte a un format serializable.
- Una classe que tingui com a objectiu desar el contingut a un arxiu.

## La qüestió del SRP en `InvoiceService`
_"Justifica si tenir un únic mètode públic implica tenir una única responsabilitat en aquesta classe."_

Tenir només un mètode públic no implica tenir una única responsabilitat, aquest cas és l'exemple perfecte,
com s'ha analitzat fins ara, té diverses responsabilitats, però el mès crític és el següent: 
__diversos motius per canviar si cal fer un canvi en el format, regles de negoci, etc.__

## Anàlisis Post-refactoració

- S'han afegit tots els punts de la proposta:
  - `Invoice` i `InvoiceLine` gestionen el calculament del total.
    - `UserTest` conte dos unit tests per aquesta feature.
  - `InvoiceSerializer` gestiona la conversió de les dades a un string.
    - `UserTest` conte dos unit tests per aquesta feature.
  - `InvoiceService` amb el `saveToFile()` gestiona el desament del string a un arxiu en el sistema.
    - No s'han afegit nous tests per aquesta feature perquè els que ja existeixen són prou robust i suficients.
- La majoria de refactoring de classes s'ha fet sense utilitzar cap eina del IDE, excepte en els casos d'alguns mètodes, s'ha utilitzat "Extract Method" del IntelliJ IDEA.