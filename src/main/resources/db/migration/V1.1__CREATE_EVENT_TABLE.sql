DROP TABLE IF EXISTS "event";
CREATE TABLE "event"(
                       "id" SERIAL PRIMARY KEY,
                       "title" VARCHAR,
                       "description" VARCHAR NOT NULL
);