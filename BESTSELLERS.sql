ALTER TABLE BOOKS ADD COLUMN BESTSELLER BOOLEAN DEFAULT FALSE;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    UPDATE BOOKS b
    SET BESTSELLER = (
        SELECT COUNT(*) >= 2
        FROM RENTS r
        WHERE r.BOOK_ID = b.BOOK_ID
          AND r.RENT_DATE > CURRENT_DATE - INTERVAL 1 MONTH
    );
END $$

DELIMITER ;


CALL UpdateBestsellers();