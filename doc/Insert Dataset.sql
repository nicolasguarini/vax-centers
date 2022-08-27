DELETE FROM eventiavversi;
DELETE FROM vaccinazioni;
DELETE FROM centrivaccinali;

INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00001', 'Schiranna', 'Hub', 'Piazza Roma 1, Varese, VA, 21100');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00002', 'Ospedale Santa Maria Goretti', 'Ospedaliero', 'Via Lucia Scaravelli 1, Latina, LT, 04100');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00003', 'Policlinico Gemelli', 'Ospedaliero', 'Via della Pineta Sacchetti 217, Roma, RM, 00168');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00004', 'Policlinico Umberto I', 'Ospedaliero', 'Viale Regina Elena 324, Roma, RM, 00161');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00005', 'Humanitas Mirasole', 'Hub', 'Via Alessandro Manzoni 56, Rozzano, MI, 20089');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00006', 'ASST Vimercate', 'Ospedaliero', 'Via Santi Cosma e Damiano 10, Vimercate, MB, 20871');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00007', 'ASST Sette Laghi', 'Ospedaliero', 'Viale Luigi Borri 57, Varese, VA, 21100');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00008', 'Unifarm', 'Hub', 'Via Provina 3, Ravina, TN, 38123');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00009', 'ASL Novara', 'Aziendale', 'Viale Roma 7, Novara, NO, 28100');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00010', 'Consorziale Policlinico', 'Ospedaliero', 'Piazza Giulio Cesare 11, Bari, BA, 70124');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00011', 'AOU di Sassari', 'Aziendale', 'Viale S. Pietro 43, Sassari, SS, 07100');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00012', 'ISMETT Palermo', 'Aziendale', 'Via Ernesto Tricomi 5, Palermo, PA, 90127');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00013', 'Azienda Ospedaliera di Perugia', 'Ospedaliero', 'Piazza Giorgio Meneghini 3, Perugia, PG, 06129');
INSERT INTO centrivaccinali(idcentrovaccinale, nomecentrovaccinale, tipologia, indirizzo) 
    VALUES('00014', 'Ospedale di Vicenza', 'Ospedaliero', 'Via Ferdinando Rodolfi 37, Vicenza, VI, 36100');

INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password) 
    VALUES('0000100000000001', 'Marco', 'Verdi', 'VRDMRC66E01F205F', '2022-08-18', '00001', 'Pfizer', true, 'marcoverdi', 'marcoverdi1997@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0001400000000001', 'Luca', 'Morosi', 'MRSLCU66E01F205G', '2022-08-03', '00014', 'Moderna', true, 'lucamorosi', 'lucamorosi24@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000800000000001', 'Nicola', 'Marconi', 'MRCNLS66E01F839X', '2022-08-20', '00008', 'Astra Zeneca', true, 'nicolamarconi', 'nicolamarconi.py@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000300000000001', 'Emanuele', 'Portese', 'PRTMNL56D05H501G', '2022-08-20', '00003', 'Pfizer', true, 'emanueleportese', 'portesema01@outlook.it', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000300000000002', 'Manuel', 'Guzzanti', 'GZZMNL56H02F839N', '2022-08-19', '00003', 'Moderna', true, 'manuelguzzanti', 'guzzantino69@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000300000000003', 'Pietro', 'Esposito', 'SPSPTR43H03F704W', '2022-08-19', '00003', 'Pfizer', true, 'pietroesposito', 'pietroesposito111@libero.it', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000300000000004', 'Mario', 'Rossi', 'RSSMRA43D43L379E', '2022-07-23', '00003', 'Moderna', true, 'mariorossi', 'rossimarione@hotmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000700000000001', 'Elena', 'Pellegrini', 'PLLLNE92L53D869L', '2022-06-12', '00007', 'Astra Zeneca', true, 'elenapellegrini', 'elenapelle04@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000900000000001', 'Fabio', 'Colombo', 'CLMFBA15S04H648G', '2022-08-20', '00009', 'Moderna', true, 'fabiocolombo', 'colombofabio84@libero.it', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0001000000000001', 'Edoardo', 'De Marco', 'DMRDRD01D12L021S', '2022-08-17', '00010', 'Pfizer', true, 'edoardodemarco', 'edodemarch00@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000900000000002', 'Yassin', 'Muhammad', 'YSSMMM01L07C115F', '2022-08-10', '00009', 'Moderna', true, 'yassinmuhammad', 'muhammadyassin@libero.it', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000100000000002', 'Nicolas', 'Guarini', 'GRNNLS01P04L682K', '2022-08-30', '00001', 'Moderna', true, 'nicolasguarini', 'nikiguarincia@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000100000000003', 'Martina', 'Smeraldi', 'SMRMTN98E44A662S', '2022-08-18', '00001', 'Astra Zeneca', true, 'martinasmeraldi', 'martysmera0@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0001200000000001', 'Paolo', 'Bonolis', 'BNLPLA82L05H501Q', '2022-03-02', '00012', 'Moderna', true, 'paolobonolis', 'info@avantiunaltro.it', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000400000000001', 'Ellie', 'Goulding', 'GLDLLE82D45G395C', '2022-08-11', '00004', 'Astra Zeneca', true, 'elliegoulding', 'ellie999@yahoo.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000500000000001', 'Giuseppe', 'Draghi', 'DRGGPP82D04G479N', '2022-08-08', '00005', 'Moderna', true, 'giuseppedraghi', 'dragonerosso01@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000500000000002', 'Marco', 'Beri', 'BREMRC65R44A345J', '2022-08-09', '00005', 'Moderna', true, 'marcoberi', 'marcoberi123@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000600000000001', 'Fabio', 'Guarini', 'GRNFBA65M06H147I', '2022-08-10', '00006', 'Pfizer', true, 'fabioguarini', 'fabietto09@gmail.com', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');
INSERT INTO vaccinazioni(idvaccinazione, nomevaccinato, cognomevaccinato, cfvaccinato, datavaccinazione, idcentrovaccinale, nomevaccino, registrato, username, email, password)
    VALUES('0000600000000002', 'Emma', 'Rossi', 'RSSMME65H06D242L', '2022-08-14', '00006', 'Pfizer', true, 'emmarossi', 'rossiemma1@libero.it', 'vXkubgP5yrztVQXkHwUlDLMnpYPOYrp6QTyFsXkMy0c=');

INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Male al braccio', 2, 'Dolore ai muscoli nella zona della puntura', '0000100000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 3, '', '0000500000000002');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Spossatezza', 3, '', '0000600000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Male alle ossa', 5, 'Non riesco a stare in piedi', '0000300000000002');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Mal di testa', 4, '', '0000900000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 5, 'Febbre a 40 gradi tutta la notte', '0000300000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Male al braccio', 4, '', '0000800000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Spossatezza', 2, '', '0000500000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 1, '', '0000100000000002');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Male al braccio', 3, '', '0000100000000002');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Mal di testa', 5, '', '0000700000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 3, '', '0001400000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Nausea', 4, '', '0000100000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Nausea', 2, '', '0000300000000004');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Vertigini', 4, '', '0000500000000002');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 5, '', '0001200000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Vomito', 5, '', '0000100000000003');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Svenimenti', 5, '', '0000300000000003');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Mal di testa', 1, '', '0000600000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 3, '', '0000500000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 2, '', '0000900000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Dolore muscolare', 3, '', '0000700000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Nausea', 4, '', '0000500000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Mal di stomaco', 2, '', '0000900000000002');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Vertigini', 4, '', '0000700000000001');
INSERT INTO eventiavversi(nomeeventoavverso, severita, noteaggiuntive, idvaccinazione)
    VALUES('Febbre', 1, '', '0000600000000002');
