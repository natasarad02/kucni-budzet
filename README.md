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
<img width="215" height="80" alt="image" src="https://github.com/user-attachments/assets/72873bf4-e1f1-436b-bdf5-69c767355ea2" />
</div>

### ✅ Kompleksan upit 1  
**Statistika transakcija po tipu i po računu**
- Za svaki račun izdvajaju se transakcije
- Grupisanje po tipu transakcije
- Prikaz ukupnog iznosa u osnovnoj valuti i broja transakcija po tipu
- Iznosi su sortirani u rastućem redosledu

<div align="center">
<img width="598" height="73" alt="image" src="https://github.com/user-attachments/assets/4a5db19f-fa33-43fd-b204-9a55b805167e" />
</div>

### ✅ Kompleksan upit 2  
**Prosečan iznos transakcija po kategoriji i po računu**
- Spoljno spajanje računa i kategorija sa transakcijama
- Prosečan iznos se računa po kategoriji za svaki račun
- Kategorije bez transakcija se ne prikazuju
- Iznosi su sortirani u opadajućem redosledu
  
<div align="center">
<img width="655" height="108" alt="image" src="https://github.com/user-attachments/assets/f94204f6-a80d-47db-b040-b61134cc4652" />
</div>


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
