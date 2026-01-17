CREATE TABLE organ_table (
entry_id SERIAL PRIMARY KEY, 
manufacturer VARCHAR(20),
geogr_location VARCHAR(20),
constr_year INT,
nr_of_registers INT,
nr_of_manuals INT);

INSERT INTO organ_table (manufacturer, geogr_location, constr_year, nr_of_registers, nr_of_manuals)
VALUES ('Wegenstein', 'Maria Radna', 1905, 25, 2);

INSERT INTO organ_table (manufacturer, geogr_location, constr_year, nr_of_registers, nr_of_manuals)
VALUES ('Dangl', 'Stamora Germana', 1886, 12, 1);

SELECT manufacturer, geogr_location, constr_year FROM organ_table; 

SELECT * FROM organ_table;



CREATE TABLE cantor_table (
entry_id SERIAL PRIMARY KEY, 
full_name VARCHAR(20),
age INT,
organ_id INT references organ_table);

INSERT INTO cantor_table (full_name, age, organ_id) VALUES ('Andreea B.', 40, 1);
INSERT INTO cantor_table (full_name, age, organ_id) VALUES ('Marius K.', 62, 2);

select * from cantor_table;

select * from organ_table inner join cantor_table on cantor_table.organ_id = organ_table.entry_id;
select * from organ_table o inner join cantor_table c on c.organ_id = o.entry_id;
select cantor_table.full_name, organ_table.manufacturer 
FROM organ_table inner join cantor_table on cantor_table.organ_id = organ_table.entry_id;

INSERT INTO cantor_table (full_name, age) VALUES ('Herbert W.', 54);
INSERT INTO organ_table (manufacturer, geogr_location, constr_year, nr_of_registers, nr_of_manuals)
VALUES ('Dangl', 'Neudorf', 1867, 12, 1);

DELETE from cantor_table where entry_id = 6;

-- display all entries from organ_table
select cantor_table.full_name, organ_table.manufacturer, organ_table.geogr_location 
FROM organ_table LEFT join cantor_table on cantor_table.organ_id = organ_table.entry_id;

/* display all entries from 
cantor_table: */
select cantor_table.full_name, organ_table.manufacturer, organ_table.geogr_location 
FROM organ_table RIGHT join cantor_table on cantor_table.organ_id = organ_table.entry_id;

