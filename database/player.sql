create table player
(
    id            INT IDENTITY not NULL,
    first_name    VARCHAR(20) default NULL,
    last_name     VARCHAR(20) default NULL,
    age           INT         default NULL,
    acceleration  INT         default NULL,
    endurance     INT         default NULL,
    form          INT         default NULL,
    mental        INT         default NULL,
    speed         INT         default NULL,
    stamina       INT         default NULL,
    start         INT         default NULL,
    lastRacePlace INT         default NULL,
    fastest100m   double      default NULL,
    fastest200m   double      default NULL,
    fastest400m   double      default NULL,
    lastRaceTime  double      default NULL,
    PRIMARY KEY (id)
);