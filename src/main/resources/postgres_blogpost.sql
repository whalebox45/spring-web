/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  hsean
 * Created: 2022年8月25日
 */

-- Table: public.blogpost

-- DROP TABLE IF EXISTS public.blogpost;

CREATE TABLE IF NOT EXISTS public.blogpost
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    context character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    create_date timestamp without time zone,
    CONSTRAINT blogpost_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.blogpost
    OWNER to blog_control;