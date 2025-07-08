SELECT r.NAZRAC, COUNT(t.IDTR) AS broj_transakcija, SUM(t.IZNOV) AS ukupno
FROM Racun r
JOIN Transakcija t ON r.IDRAC = t.Racun_IDRAC
GROUP BY r.NAZRAC;
