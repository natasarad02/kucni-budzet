# 💰 Informacioni sistem – Kućni budžet

**Projekat iz predmeta Baze podataka 2**  
Ovaj projekat predstavlja jednostavan informacioni sistem za vođenje kućnog budžeta. Aplikacija je implementirana kao konzolna aplikacija u Javi, uz korišćenje Oracle baze i JDBC konekcije (HikariCP).

---

## 🛠️ Tehnologije
- Java (JDK 7+)
- JDBC (HikariCP konekcioni pool)
- Oracle baza podataka

---

## 📁 Struktura projekta

- `model` – Java klase koje predstavljaju entitete (Racun, Transakcija, Kategorija itd.)
- `dao` – Data Access sloj, direktna komunikacija sa bazom
- `service` – Poslovna logika i obrada podataka
- `dto` – Data Transfer objekti za složene prikaze podataka
- `main` – Konzolna aplikacija koja pokreće program

---

## 🔍 Funkcionalnosti
### ✅ Početni meni

<div align="center">
<img width="1128" height="201" alt="image" src="https://github.com/user-attachments/assets/544a4a2b-2f55-4d29-a21f-766b2d56b641"/>
</div>

### ✅ Jednostavan upit
- Ispis sume iznosa transakcija po kategorijama

<div align="center">
<img width="213" height="83" alt="image" src="https://github.com/user-attachments/assets/9ba29abe-c177-40ea-8cf4-2d57fed32f9f" />

</div>

> 💡 **SQL upit** u jednom pozivu baze:

```sql
SELECT r.NAZRAC, COUNT(t.IDTR) AS broj_transakcija, SUM(t.IZNOV) AS ukupno
FROM Racun r
JOIN Transakcija t ON r.IDRAC = t.Racun_IDRAC
GROUP BY r.NAZRAC;
```


### ✅ Kompleksan upit 1  
**Statistika transakcija po tipu i po računu**
- Za svaki račun izdvajaju se transakcije
- Grupisanje po tipu transakcije
- Prikaz ukupnog iznosa u osnovnoj valuti i broja transakcija po tipu
- Iznosi su sortirani u rastućem redosledu

<div align="center">
<img width="623" height="109" alt="image" src="https://github.com/user-attachments/assets/361e5d1a-89e4-4a73-a2c0-345c933958d5" />


</div>

> 💡 **Napomena:** U okviru JDBC implementacije, ovaj upit je realizovan kroz **kombinaciju više manjih upita** i obradu u Javi (servis + DAO sloj), kako bi se obezbedila bolja fleksibilnost i čitljivost koda. Ovako bi izgledao **ekvivalentan SQL upit** u jednom pozivu baze:

```sql
SELECT 
    r.IDRAC,
    v.NAZVAL AS valuta,
    t.TIPTR,
    SUM(t.IZNTR) AS ukupno_po_tipu,
    COUNT(*) AS broj_transakcija
FROM 
    TRANSAKCIJA t
    JOIN RACUN r ON t.RACUN_IDRAC = r.IDRAC
    JOIN VALUTA v ON r.VALUTA_IDVAL = v.IDVAL
WHERE 
    t.DATTR >= ADD_MONTHS(SYSDATE, -24)

GROUP BY 
    r.IDRAC, v.NAZVAL, t.TIPTR
HAVING 
    SUM(t.IZNTR) > 0
ORDER BY 
    ukupno_po_tipu;
```

### ✅ Kompleksan upit 2  
**Prosečan iznos transakcija po kategoriji i po računu**
- Spoljno spajanje računa i kategorija sa transakcijama
- Prosečan iznos se računa po kategoriji za svaki račun
- Kategorije bez transakcija se ne prikazuju
- Iznosi su sortirani u opadajućem redosledu
  
<div align="center">
<img width="641" height="108" alt="image" src="https://github.com/user-attachments/assets/c66d16e4-02dc-4847-886c-5e81ebba02cb" />

</div>

```sql
SELECT
    r.IDRAC,
    k.NAZKAT,
    AVG(t.IZNOV) AS prosecni_iznos
FROM
    RACUN r
CROSS JOIN
    Kategorija k
LEFT JOIN
    Transakcija t ON t.RACUN_IDRAC = r.IDRAC AND t.KATEGORIJA_IDKAT = k.IDKAT
WHERE t.IZNOV > 0
GROUP BY
    r.IDRAC,
    k.IDKAT,
    k.NAZKAT
ORDER BY
  prosecni_iznos DESC;
```


### 🔁 Transakcija
- Prilikom dodavanja transakcije, unosi se id kategorije
- Ukoliko ne postoji id, kategorija se automatski unosi sa novim id-jem (i privremenim placeholder nazivom, za sad)
- Ubacivanje transakcije se vrši nakon toga u istoj sesiji
- Radi lakšeg testiranja, ID računa, ID tipa računa i ID valute su fiksirane vrednosti iz baze

<div align="center">
<img width="444" height="155" alt="image" src="https://github.com/user-attachments/assets/dba24d17-d76a-4346-bb08-5aa0d044a647" />
</div>
---


## 📌 Napomena
Frontend nije razvijen – aplikacija funkcioniše kao jednostavna konzolna aplikacija.

---

## 📧 Autor
Natasa Radmilovic RA 20/2021 – Projekat iz predmeta **Baze podataka 2**
