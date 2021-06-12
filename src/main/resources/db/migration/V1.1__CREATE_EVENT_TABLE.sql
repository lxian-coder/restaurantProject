DROP TABLE IF EXISTS "event";
CREATE TABLE "event"(
                       "id" BIGINT PRIMARY KEY,
                       "image"  bytea,
                       "description" VARCHAR NOT NULL
);