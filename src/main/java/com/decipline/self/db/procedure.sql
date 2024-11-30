-- procedure to check if weight taken has expired within 7 days , means we have to take reading after 7 days

DELIMITER $$

CREATE PROCEDURE CheckWeightReadingsBefore7Days()
BEGIN
    -- Declare a cursor to select all activities with non-null weight and createdDate older than 7 days
    DECLARE done INT DEFAULT 0;
    DECLARE activityId INT;
    DECLARE createdDate DATE;
    DECLARE activityCursor CURSOR FOR
        SELECT id, created_date
        FROM activity
        WHERE weight IS NOT NULL
        AND created_date < CURDATE() - INTERVAL 7 DAY;

    -- Declare CONTINUE HANDLER for when the cursor has no more data
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    -- Open the cursor
    OPEN activityCursor;

    -- Loop through all records
    read_loop: LOOP
        FETCH activityCursor INTO activityId, createdDate;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Print or process the activity details where the createdDate is older than 7 days
        SELECT CONCAT('Activity ID: ', activityId, ' has weight reading taken on: ', createdDate) AS message;

    END LOOP;

    -- Close the cursor
    CLOSE activityCursor;
END $$

DELIMITER ;

