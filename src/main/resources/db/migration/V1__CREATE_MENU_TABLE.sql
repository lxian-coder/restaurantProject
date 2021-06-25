CREATE SCHEMA if not exists "restaurant";

DROP TABLE IF EXISTS "menu";
CREATE TABLE "menu" (
    "id" SERIAL PRIMARY KEY,
    "description" VARCHAR ,
    "price" VARCHAR(255) NOT NULL,
    "price2" VARCHAR (255),
    "category" VARCHAR (255) NOT NUll
);
