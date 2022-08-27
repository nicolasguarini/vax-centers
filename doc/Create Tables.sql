CREATE TABLE IF NOT EXISTS CentriVaccinali(
    idCentroVaccinale VARCHAR(5) PRIMARY KEY NOT NULL,
    nomeCentroVaccinale VARCHAR(50) NOT NULL,
    tipologia VARCHAR(20) NOT NULL,
    indirizzo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Vaccinazioni(
    idVaccinazione VARCHAR(16) PRIMARY KEY NOT NULL,
    nomeVaccinato VARCHAR(50) NOT NULL,
    cognomeVaccinato VARCHAR(50)NOT NULL,
    cfVaccinato VARCHAR(16) UNIQUE NOT NULL,
    dataVaccinazione DATE NOT NULL,
    idCentroVaccinale VARCHAR(5) NOT NULL,
    nomeVaccino VARCHAR(50) NOT NULL,
    registrato BOOLEAN NOT NULL,
    username VARCHAR(100) NULL,
    email VARCHAR(100) NULL,
    password VARCHAR(64) NULL,
    CONSTRAINT fk_centrivaccinali
    FOREIGN KEY (idCentroVaccinale)
    REFERENCES CentriVaccinali(idCentroVaccinale)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS EventiAvversi(
    nomeEventoAvverso VARCHAR(100) NOT NULL,
    severita SMALLINT NOT NULL,
    noteAggiuntive VARCHAR(5000) NULL,
    idVaccinazione VARCHAR(16) NOT NULL,
    PRIMARY KEY (nomeEventoAvverso, idVaccinazione),
    CONSTRAINT fk_vaccinazione
    FOREIGN KEY (idVaccinazione)
    REFERENCES Vaccinazioni(idVaccinazione)
    ON DELETE CASCADE ON UPDATE CASCADE
);
