--
-- PostgreSQL database cluster dump
--

-- Started on 2014-09-30 11:44:04

\connect postgres

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE easypharma;
ALTER ROLE easypharma WITH SUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN REPLICATION PASSWORD 'md5284506a6bfcbc0b7f22b19f9a99d3135' VALID UNTIL 'infinity';
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION PASSWORD 'md59f39b02c2d82c084795bf69ffd9e906a';






--
-- Database creation
--

CREATE DATABASE eashpharma WITH TEMPLATE = template0 OWNER = easypharma;
REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect eashpharma

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.1
-- Dumped by pg_dump version 9.1.1
-- Started on 2014-09-30 11:44:04

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 168 (class 3079 OID 11638)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1897 (class 0 OID 0)
-- Dependencies: 168
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 164 (class 1259 OID 16425)
-- Dependencies: 5
-- Name: address; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE address (
    id integer NOT NULL,
    city character varying(50),
    country character varying(50),
    postal_code integer,
    address text,
    id_client integer
);


ALTER TABLE public.address OWNER TO easypharma;

--
-- TOC entry 167 (class 1259 OID 16448)
-- Dependencies: 5
-- Name: assurance; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE assurance (
    id integer NOT NULL,
    name character varying(50),
    agence character varying(50),
    ofas character varying(50),
    ean character varying(50),
    cover_card character varying(5),
    npa character varying(50),
    phone character varying(50)
);


ALTER TABLE public.assurance OWNER TO easypharma;

--
-- TOC entry 163 (class 1259 OID 16417)
-- Dependencies: 5
-- Name: client; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE client (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    reference character varying(255),
    birth_date date,
    age integer,
    sexe boolean,
    phone character varying(50),
    email character varying(255)
);


ALTER TABLE public.client OWNER TO easypharma;

--
-- TOC entry 1898 (class 0 OID 0)
-- Dependencies: 163
-- Name: COLUMN client.birth_date; Type: COMMENT; Schema: public; Owner: easypharma
--

COMMENT ON COLUMN client.birth_date IS '
';


--
-- TOC entry 166 (class 1259 OID 16443)
-- Dependencies: 5
-- Name: medecin; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE medecin (
    id integer NOT NULL,
    first_name character varying(50),
    last_name character varying(50),
    speciality character varying(50),
    reference character varying(50),
    phone character varying(50),
    fax character varying(50),
    nrcc character varying(50),
    nc character varying(50)
);


ALTER TABLE public.medecin OWNER TO easypharma;

--
-- TOC entry 165 (class 1259 OID 16438)
-- Dependencies: 5
-- Name: ordonnance; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE ordonnance (
    id integer NOT NULL,
    start_date date,
    end_date date,
    id_client integer,
    id_assurance integer,
    id_medecin integer
);


ALTER TABLE public.ordonnance OWNER TO easypharma;

--
-- TOC entry 161 (class 1259 OID 16404)
-- Dependencies: 5
-- Name: product; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE product (
    id integer NOT NULL,
    designation character varying(255),
    pu double precision,
    quantity integer,
    reference character varying(255),
    thresholdalert integer,
    id_ordonnance integer
);


ALTER TABLE public.product OWNER TO easypharma;

--
-- TOC entry 162 (class 1259 OID 16412)
-- Dependencies: 5
-- Name: sequence; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE public.sequence OWNER TO easypharma;

--
-- TOC entry 1888 (class 0 OID 16425)
-- Dependencies: 164
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY address (id, city, country, postal_code, address, id_client) FROM stdin;
\.


--
-- TOC entry 1891 (class 0 OID 16448)
-- Dependencies: 167
-- Data for Name: assurance; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY assurance (id, name, agence, ofas, ean, cover_card, npa, phone) FROM stdin;
\.


--
-- TOC entry 1887 (class 0 OID 16417)
-- Dependencies: 163
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY client (id, first_name, last_name, reference, birth_date, age, sexe, phone, email) FROM stdin;
1	Hayani	Mehdi	CD12345	1987-06-13	27	\N	+212664582312	hayani.mehdi149@gmail.com
2	El Jai	Mohammed	CD54321	1987-10-20	27	\N	+212661233444	eljai.mohammed@gmail.com
\.


--
-- TOC entry 1890 (class 0 OID 16443)
-- Dependencies: 166
-- Data for Name: medecin; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY medecin (id, first_name, last_name, speciality, reference, phone, fax, nrcc, nc) FROM stdin;
\.


--
-- TOC entry 1889 (class 0 OID 16438)
-- Dependencies: 165
-- Data for Name: ordonnance; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY ordonnance (id, start_date, end_date, id_client, id_assurance, id_medecin) FROM stdin;
\.


--
-- TOC entry 1885 (class 0 OID 16404)
-- Dependencies: 161
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY product (id, designation, pu, quantity, reference, thresholdalert, id_ordonnance) FROM stdin;
1	DRFRF2332	30	10	DOLIPRANE 30ML	3	\N
2	DRF43FD	56	23	SAGRUN TOUT PARTIE GENRIC	5	\N
3	D3FRDF	21	21	OPHARLO POUR ADULTE	2	\N
\.


--
-- TOC entry 1886 (class 0 OID 16412)
-- Dependencies: 162
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: easypharma
--

COPY sequence (seq_name, seq_count) FROM stdin;
SEQ_GEN	0
\.


--
-- TOC entry 1873 (class 2606 OID 16432)
-- Dependencies: 164 164
-- Name: address_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 1879 (class 2606 OID 16452)
-- Dependencies: 167 167
-- Name: assurance_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY assurance
    ADD CONSTRAINT assurance_pkey PRIMARY KEY (id);


--
-- TOC entry 1871 (class 2606 OID 16424)
-- Dependencies: 163 163
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 1877 (class 2606 OID 16447)
-- Dependencies: 166 166
-- Name: medecin_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY medecin
    ADD CONSTRAINT medecin_pkey PRIMARY KEY (id);


--
-- TOC entry 1875 (class 2606 OID 16442)
-- Dependencies: 165 165
-- Name: ordonnance_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY ordonnance
    ADD CONSTRAINT ordonnance_pkey PRIMARY KEY (id);


--
-- TOC entry 1867 (class 2606 OID 16411)
-- Dependencies: 161 161
-- Name: product_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 1869 (class 2606 OID 16416)
-- Dependencies: 162 162
-- Name: sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- TOC entry 1881 (class 2606 OID 16433)
-- Dependencies: 164 163 1870
-- Name: address_idClient_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY address
    ADD CONSTRAINT "address_idClient_fkey" FOREIGN KEY (id_client) REFERENCES client(id);


--
-- TOC entry 1883 (class 2606 OID 16458)
-- Dependencies: 165 1878 167
-- Name: ordonnance_id_assurance_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY ordonnance
    ADD CONSTRAINT ordonnance_id_assurance_fkey FOREIGN KEY (id_assurance) REFERENCES assurance(id);


--
-- TOC entry 1882 (class 2606 OID 16453)
-- Dependencies: 163 1870 165
-- Name: ordonnance_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY ordonnance
    ADD CONSTRAINT ordonnance_id_client_fkey FOREIGN KEY (id_client) REFERENCES client(id);


--
-- TOC entry 1884 (class 2606 OID 16463)
-- Dependencies: 166 1876 165
-- Name: ordonnance_id_medecin_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY ordonnance
    ADD CONSTRAINT ordonnance_id_medecin_fkey FOREIGN KEY (id_medecin) REFERENCES medecin(id);


--
-- TOC entry 1880 (class 2606 OID 16468)
-- Dependencies: 165 1874 161
-- Name: product_id_ordonnance_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_id_ordonnance_fkey FOREIGN KEY (id_ordonnance) REFERENCES ordonnance(id);


--
-- TOC entry 1896 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-09-30 11:44:04

--
-- PostgreSQL database dump complete
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.1
-- Dumped by pg_dump version 9.1.1
-- Started on 2014-09-30 11:44:04

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1846 (class 1262 OID 11912)
-- Dependencies: 1845
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 162 (class 3079 OID 11638)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1849 (class 0 OID 0)
-- Dependencies: 162
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 161 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 1850 (class 0 OID 0)
-- Dependencies: 161
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- TOC entry 1848 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-09-30 11:44:06

--
-- PostgreSQL database dump complete
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.1
-- Dumped by pg_dump version 9.1.1
-- Started on 2014-09-30 11:44:06

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1845 (class 1262 OID 1)
-- Dependencies: 1844
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 161 (class 3079 OID 11638)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1848 (class 0 OID 0)
-- Dependencies: 161
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1847 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-09-30 11:44:08

--
-- PostgreSQL database dump complete
--

-- Completed on 2014-09-30 11:44:08

--
-- PostgreSQL database cluster dump complete
--

