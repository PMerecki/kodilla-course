-- Tworzenie tabeli STATS
CREATE TABLE STATS (
                       STAT_ID INT(11) AUTO_INCREMENT PRIMARY KEY,
                       STAT_DATE DATETIME NOT NULL,
                       STAT VARCHAR(20) NOT NULL,
                       VALUE INT(11) NOT NULL
);

-- Tworzenie widoku BESTSELLERS_COUNT
CREATE VIEW BESTSELLERS_COUNT AS
SELECT COUNT(*) AS BESTSELLERS_COUNT
FROM BOOKS
WHERE BESTSELLER = TRUE;

-- Tworzenie zdarzenia wywołującego procedurę UpdateBestSellers() i zapisującego wyniki do tabeli STATS
CREATE EVENT IF NOT EXISTS update_bestsellers_event
    ON SCHEDULE EVERY 1 MINUTE
    DO
    BEGIN
        DECLARE count_best_sellers INT;

        CALL UpdateBestSellers();

        SELECT BESTSELLERS_COUNT INTO count_best_sellers FROM BESTSELLERS_COUNT;

        INSERT INTO STATS (STAT_DATE, STAT, VALUE) VALUES (NOW(), 'BESTSELLERS', count_best_sellers);
    END;


-- Usunięcie zdarzenia po wykonaniu zadania
DROP EVENT IF EXISTS update_bestsellers_event;