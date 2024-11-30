

use decipline;
DELIMITER $$
drop procedure if EXISTS CalculateActivityTotals;
CREATE PROCEDURE CalculateActivityTotals(
    OUT totalWalkingSteps INT,
    OUT totalPushUps INT
)
BEGIN
    SELECT
        SUM(walking_steps)

    INTO totalWalkingSteps
    FROM activity;

    select
     SUM(push_ups)
     into totalPushUps
     from activity;

END $$

DELIMITER ;


CALL CalculateActivityTotals(@totalWalkingSteps, @totalPushUps);

SELECT @totalWalkingSteps AS TotalWalkingSteps,
       @totalPushUps AS TotalPushUps