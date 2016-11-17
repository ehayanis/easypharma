--
-- TOC entry 165 (class 1259 OID 16438)
-- Dependencies: 5
-- Name: prescription; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE prescription (
    id integer NOT NULL,
    ref character varying(50),
    client_id integer,
    medecin_id integer,
    start_date date,
    end_date date,
    creation_Date date,
    version date
);


ALTER TABLE public.prescription OWNER TO postgres;

--
-- TOC entry 1875 (class 2606 OID 16442)
-- Dependencies: 165 165
-- Name: prescription_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY prescription
    ADD CONSTRAINT prescription_pkey PRIMARY KEY (id);
    
--
-- TOC entry 1882 (class 2606 OID 16453)
-- Dependencies: 163 1870 165
-- Name: prescription_client_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY prescription
    ADD CONSTRAINT prescription_client_id_fkey FOREIGN KEY (client_id) REFERENCES client(id);

--
-- TOC entry 1884 (class 2606 OID 16463)
-- Dependencies: 166 1876 165
-- Name: prescription_medecin_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY prescription
    ADD CONSTRAINT prescription_medecin_id_fkey FOREIGN KEY (medecin_id) REFERENCES medecin(id);

    
INSERT INTO prescription(id,
    client_id,
    medecin_id,
    start_date,
    end_date,
    creation_Date,
    version)
    VALUES ( 111,111,2503,'2016-11-11','2016-11-11','2016-11-11','2016-11-11');

