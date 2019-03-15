CREATE TABLE public.checker
(
    id bigint,
    customer_id bigint,
    status character(1) COLLATE pg_catalog."default",
    active character(1) COLLATE pg_catalog."default",
    created_date date,
    created_by text COLLATE pg_catalog."default",
    modified_date date,
    modified_by text COLLATE pg_catalog."default",
    authorized_date date,
    authorized_by text COLLATE pg_catalog."default"
)


CREATE TABLE public.customer
(
    id bigint,
    customer_id bigint,
    customer_name character varying(50) COLLATE pg_catalog."default",
    customer_phone bigint,
    customer_email character varying(50) COLLATE pg_catalog."default",
    loan_type character varying(15) COLLATE pg_catalog."default",
    loan_amount bigint,
    customer_score bigint,
    loan_tenure bigint,
    cutomer_addres text COLLATE pg_catalog."default"
)

CREATE TABLE public.statuscodes
(
    status_names character varying(15) COLLATE pg_catalog."default",
    codes character varying(1) COLLATE pg_catalog."default"
)