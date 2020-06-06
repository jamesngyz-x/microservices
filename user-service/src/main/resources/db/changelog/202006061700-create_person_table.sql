--liquibase formatted sql
--changeset jamesngyz:202006061700-1
--comment: create_person_table

CREATE TABLE person (
    id uuid PRIMARY KEY,
    name text NOT NULL
);
