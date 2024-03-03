ALTER TABLE BOOKS ADD COLUMN BESTSELLER BOOLEAN DEFAULT FALSE;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE b_book_id INT;
    DECLARE cur_books CURSOR FOR SELECT DISTINCT BOOK_ID FROM RENTS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur_books;

    READ_LOOP: WHILE done = 0 DO
            FETCH cur_books INTO b_book_id;

            IF done THEN
                LEAVE READ_LOOP;
            END IF;

            UPDATE BOOKS b
            SET BESTSELLER = (
                SELECT COUNT(*) >= 2
                FROM RENTS r
                WHERE r.BOOK_ID = b.BOOK_ID
                  AND r.RENT_DATE > CURRENT_DATE - INTERVAL 1 MONTH
            )
            WHERE b.BOOK_ID = b_book_id;

        END WHILE READ_LOOP;

    CLOSE cur_books;

    COMMIT;
END $$

DELIMITER ;

CALL UpdateBestsellers();