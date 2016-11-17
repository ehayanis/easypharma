--
-- TOC entry 165 (class 1259 OID 16438)
-- Dependencies: 5
-- Name: prescriptionproduct; Type: TABLE; Schema: public; Owner: easypharma; Tablespace: 
--

CREATE TABLE prescriptionproduct (
    id integer NOT NULL,
    product_id integer,
    prescription_id integer,
    qte integer,
    creation_Date date,
    version date
);


ALTER TABLE public.prescriptionproduct OWNER TO postgres;

--
-- TOC entry 1875 (class 2606 OID 16442)
-- Dependencies: 165 165
-- Name: prescriptionproduct_pkey; Type: CONSTRAINT; Schema: public; Owner: easypharma; Tablespace: 
--

ALTER TABLE ONLY prescriptionproduct
    ADD CONSTRAINT prescriptionproduct_pkey PRIMARY KEY (id);
    
--
-- TOC entry 1882 (class 2606 OID 16453)
-- Dependencies: 163 1870 165
-- Name: prescriptionproduct_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY prescriptionproduct
    ADD CONSTRAINT prescriptionproduct_product_id_fkey FOREIGN KEY (product_id) REFERENCES product(id);

--
-- TOC entry 1884 (class 2606 OID 16463)
-- Dependencies: 166 1876 165
-- Name: prescriptionproduct_prescription_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: easypharma
--

ALTER TABLE ONLY prescriptionproduct
    ADD CONSTRAINT prescriptionproduct_prescription_id_fkey FOREIGN KEY (prescription_id) REFERENCES prescription(id);

    
INSERT INTO prescriptionproduct(id,
    product_id,
    prescription_id,
    qte,
    creation_Date,
    version)
    VALUES ( 111,1,111,1,'2016-11-11','2016-11-11');

