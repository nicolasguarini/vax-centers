<br />
<div align="center">
    <a href="https://github.com/nicolasguarini/benztrack">
    <img src="./clientCV/src/main/resources/images/logo.png" alt="Logo" width="120" height="120">
  </a>

<h3 align="center">CentriVaccinali</h3>

  <p align="center">
    "CentriVaccinali" è un’applicazione gestionale per la campagna vaccinale contro
il Covid-19, che permette agli operatori sanitari di registrare le vaccinazioni
effettuate, e ai cittadini di accedere a una propria area personale con anche
la possibilità di segnalare degli eventuali eventi avversi che si sono verificati
a seguito della somministrazione del vaccino.
    <br />
    <a href="https://github.com/nicolasguarini/vax-centers"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/nicolasguarini/benztrack">Releases</a>
    ·
    <a href="https://github.com/nicolasguarini/benztrack/issues">Report Bug</a>
    ·
    <a href="https://github.com/nicolasguarini/benztrack/issues">Request Feature</a>
  </p>
</div>

## Tecnologie utilizzate
_CentriVaccinali_ è un'applicazione Java sviluppata con Maven e alcune altre tecnologie:
* [Java 8](https://www.java.com/it/download/)
* [Maven](https://maven.apache.org/)
* [Intellij IDEA](https://www.jetbrains.com/idea/)
* [Java Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
* [PostgreSQL](https://www.postgresql.org/)
* [RMI](https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/)
* [JDBC](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)

## Prerequisiti
I requisiti necessari per poter compilare ed eseguire le applicazioni sono i seguenti:
* Java 8
* Un'installazione di PostgreSQL attiva di cui si conoscono indirizzo e credenziali (solo per applicazione server)
* Maven (per compilare da sorgente) (consigilata v3.8.6 o successive)
* Una connessione Internet

## Compilare da sorgente
La maggior parte degli IDE specializzati in progetti Java, come per esempio IntelliJ IDEA,
riconosce automaticamente un progetto Maven, e mette a disposizione un
menù dedicato per gestire tutti i processi di build (lifecycle) da interfaccia
grafica.

Se invece si vuole compilare da CLI, i comandi da eseguire sono i seguenti, in ordine:
* ```mvn clean```
* ```mvn validate```
* ```mvn compile```
* ```mvn package```

Una volta eseguiti, nei moduli sarà stata generata una cartella target/
che conterrà, oltre ai file .class compilati, anche l’eseguibile di quel modulo,
nominato in questo modo: ```clientCV-2.0.jar``` e ```serverCV-2.0.jar```.

### Javadoc
Anche la documentazione javadoc è generabile tramite un plugin Maven. Il comando da eseguire è il seguente:

```sh
mvn javadoc:javadoc
```

La javadoc verrà generata all'interno della cartella ```target/site/apidocs/```

## Eseguire le applicazioni
Essendo entrambe le applicazioni stand alone e senza dipendenze esterne, non è necessaria l'installazione. E’ quindi possibile eseguire direttamente il file .jar con
i comandi
```sh
java -jar clientCV/target/clientCV-2.0.jar
```

```sh
java -jar serverCV/target/serverCV-2.0.jar
```
oppure facendo doppio click sull’icona del file desiderato.


## Contribuire al progetto

Le contribuzioni sono ciò che rende la comunità open source un posto così straordinario per imparare, ispirare e creare.

Se hai un suggerimento che renderebbe migliore il progetto, esegui il fork del repository e crea una pull request. Puoi anche aprire semplicemente un problema con il tag "miglioramento".
Non dimenticare di dare una stella al progetto! 
1. Eseguire il fork del progetto
2. Crea il branch relativo alla funzionalità 
<br>```git checkout -b feature/AmazingFeature```

3. Fai il commit delle modifiche
<br>```git commit -m 'Add some AmazingFeature'```

4. Effettua il push sul branch creato
<br> ```git push origin feature/AmazingFeature```

5. Apri una pull request

## Autori

- GUARINI NICOLAS 745508 VA - [nicolasguarini.it](https://nicolasguarini.it) - [nguarini@studenti.uninsubria.it](mailto:nguarini@studenti.uninsubria.it)
- RIZZO DOMENICO 745304 VA