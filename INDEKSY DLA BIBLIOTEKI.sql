-- Wyświetlanie planu zapytania przed dodaniem indeksów
EXPLAIN SELECT * FROM READERS WHERE FIRSTNAME = 'John';

-- Dodawanie indeksów do tabel BOOKS i READERS
CREATE INDEX BOOKTITLES ON BOOKS (TITLE);
CREATE INDEX FIRSTNAME_LASTNAME ON READERS (FIRSTNAME, LASTNAME);

-- Wyświetlanie planu zapytania po dodaniu indeksów
EXPLAIN SELECT * FROM READERS WHERE FIRSTNAME = 'John';