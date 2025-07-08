-- VALUTA

INSERT INTO Valuta (IDVAL, NAZVAL, DRZ, KOD) VALUES (1, 'EUR', 'Eurozona', 'EUR');
INSERT INTO Valuta (IDVAL, NAZVAL, DRZ, KOD) VALUES (2, 'USD', 'SAD', 'USD');
INSERT INTO Valuta (IDVAL, NAZVAL, DRZ, KOD) VALUES (3, 'RSD', 'Srbija', 'RSD');


-- TIP_RACUNA
INSERT INTO Tip_racuna (IDTIP, NAZTIP, OPISTIP, MINIZN, LIMIT) 
VALUES (1, 'Tekuci', 'Osnovni tekuci racun', 0, 5000);

INSERT INTO Tip_racuna (IDTIP, NAZTIP, OPISTIP, MINIZN, LIMIT) 
VALUES (2, 'Stedni', 'Racun za stednju', 1000, 10000);


-- RACUN
INSERT INTO Racun (IDRAC, NAZRAC, STANJE, DATOTV, DATZATV, STATUSRAC, Tip_racuna_IDTIP, Valuta_IDVAL)
VALUES (101, 'Racun 1', 15000, TO_DATE('2021-01-01', 'YYYY-MM-DD'), NULL, 'aktivan', 1, 1);

INSERT INTO Racun (IDRAC, NAZRAC, STANJE, DATOTV, DATZATV, STATUSRAC, Tip_racuna_IDTIP, Valuta_IDVAL)
VALUES (102, 'Racun 2', 2500, TO_DATE('2022-05-10', 'YYYY-MM-DD'), NULL, 'aktivan', 1, 2);

INSERT INTO Racun (IDRAC, NAZRAC, STANJE, DATOTV, DATZATV, STATUSRAC, Tip_racuna_IDTIP, Valuta_IDVAL)
VALUES (103, 'Racun 3', 78000, TO_DATE('2023-03-15', 'YYYY-MM-DD'), NULL, 'blokiran', 2, 3);


-- KATEGORIJA
INSERT INTO Kategorija (IDKAT, NAZKAT, TIPKAT, Kategorija_IDKAT, Budzetski_plan_IDPL, Stednja_IDST)
VALUES (1, 'Plata', 'prihod', 1, NULL, NULL);

INSERT INTO Kategorija (IDKAT, NAZKAT, TIPKAT, Kategorija_IDKAT, Budzetski_plan_IDPL, Stednja_IDST)
VALUES (2, 'Kupovina', 'rashod', 1, NULL, NULL);

INSERT INTO Kategorija (IDKAT, NAZKAT, TIPKAT, Kategorija_IDKAT, Budzetski_plan_IDPL, Stednja_IDST)
VALUES (3, 'Stednja', 'rashod', 1, NULL, NULL);



-- PROVIZIJA
INSERT INTO Provizija (IDPR, IZNPR, DATPR, TIPPR)
VALUES (1, 150, TO_DATE('2024-01-01', 'YYYY-MM-DD'), 'Online');

INSERT INTO Provizija (IDPR, IZNPR, DATPR, TIPPR)
VALUES (2, 100, TO_DATE('2024-02-15', 'YYYY-MM-DD'), 'POS');

INSERT INTO Provizija (IDPR, IZNPR, DATPR, TIPPR)
VALUES (3, 200, TO_DATE('2024-03-20', 'YYYY-MM-DD'), 'Bankomat');



-- TRANSAKCIJA
INSERT INTO Transakcija (IDTR, OPISTR, IZNOV, DATTR, IZNTR, TIPTR, Racun_IDRAC, Racun_Tip_racuna_IDTIP, Racun_Valuta_IDVAL, Kategorija_IDKAT)
VALUES (1001, 'Primanje plate', 120000, TO_DATE('2024-01-25', 'YYYY-MM-DD'), 120000, 'Dv_trans', 101, 1, 1, 1);

INSERT INTO Transakcija (IDTR, OPISTR, IZNOV, DATTR, IZNTR, TIPTR, Racun_IDRAC, Racun_Tip_racuna_IDTIP, Racun_Valuta_IDVAL, Kategorija_IDKAT)
VALUES (1002, 'Placanje racuna', 8000, TO_DATE('2024-02-10', 'YYYY-MM-DD'), 8000, 'Dv_trans', 102, 1, 2, 2);

INSERT INTO Transakcija (IDTR, OPISTR, IZNOV, DATTR, IZNTR, TIPTR, Racun_IDRAC, Racun_Tip_racuna_IDTIP, Racun_Valuta_IDVAL, Kategorija_IDKAT)
VALUES (1003, 'Prebacivanje sredstava', 20000, TO_DATE('2024-03-05', 'YYYY-MM-DD'), 20000, 'Dv_trans', 103, 2, 3, 3);


-- DVOJNA TRANSAKCIJA
INSERT INTO Dv_trans (IDTR, IDDV, VRSTADV, STATUSDV, Provizija_IDPR)
VALUES (1001, 5001, 'debitna', 'uspesna', 1);

INSERT INTO Dv_trans (IDTR, IDDV, VRSTADV, STATUSDV, Provizija_IDPR)
VALUES (1002, 5002, 'kreditna', 'uspesna', 2);

INSERT INTO Dv_trans (IDTR, IDDV, VRSTADV, STATUSDV, Provizija_IDPR)
VALUES (1003, 5003, 'debitna', 'neuspesna', 3);




