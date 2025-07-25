-- Jednostavan upit

SELECT r.NAZRAC, COUNT(t.IDTR) AS broj_transakcija, SUM(t.IZNOV) AS ukupno
FROM Racun r
JOIN Transakcija t ON r.IDRAC = t.Racun_IDRAC
GROUP BY r.NAZRAC;

-- Kompleksan upit 1

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


-- Kompleksan upit 2

SELECT
    r.IDRAC,
    k.NAZKAT,
    AVG(t.IZNTR) AS prosecni_iznos
FROM
    RACUN r
CROSS JOIN
    Kategorija k
LEFT JOIN
    Transakcija t ON t.RACUN_IDRAC = r.IDRAC AND t.KATEGORIJA_IDKAT = k.IDKAT
WHERE t.IZNTR > 0
GROUP BY
    r.IDRAC,
    k.IDKAT,
    k.NAZKAT
ORDER BY
  prosecni_iznos DESC;
