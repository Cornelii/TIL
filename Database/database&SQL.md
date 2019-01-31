# Database
Systematic group of data

**CRUD Operation**
* Create
* Retrieve
* Update
* Delete

## SQL_Basic (Structured Query Language)
SQL is widely used. embedded system, google android, etc.

SQL is a programming language designed to manipulate and manage data stored in relational databases.
AWS (redshift)

#### RDBMS (Realtional Database Mangement system)
MySQL, SQLite, PostgreSQL, Oracle, MS SQL
(R come from relational algebra?!)

RDBMS is almost same as the excel of microsoft.

#### Terminology

**Scheme**: structure of that express relationship, data structure, expressive way, datatype, etc.

**Table**: It's like a sheet in excel.
    * A DB can possess many table.
**Primary Key**: Primary value of each row. ex) id
    * a column contains the same type of data.
    * a row is a *record*

#### SQL grammar
||concept|example|
|---|---|---|
|DDL (Data definition language|define data, table, scheme|CREATE,DROP,ALTER|
|DML (Data manipulation language|save, revise, delete, access data|INSERT,UPDATE,DELETE,SELECT|
|DCL (Data Control language|about access authority|GRANT,REVOKE,COMMIT,ROLLBACK|


example
> {at console} sqlite3
> 
> .exit
> .mode csv
> .import hellodb.csv hellodb
> .tables
> SELECT * FROM hellodb;
> .mode column
> SELECT last_name, first_name, age FROM hellodb;
> .headers on
> {at console} sqlite3 tutorial.sqlite3
> .databases
> CREATE TABLE tablename(
>   column1 datatype PRIMARY KEY,
>   column2 datatype ~,
> );
> DROP TABLE tablename;
> .read [filename].sql
> 


sql datatype: 
* INTEGER(TINYINT, SMALLINT, MEDIUMINT,INT,BIGINT,UNSIGNED BIG INT) 
* TEXT(CHARACTER, VARCHAR,TEXT)
* REAL(REAL, DOUBLE, FLOAT)
* NUMERIC
* BLOB

#### SQL Commnads
```sql

-- Create Table
CREATE TABLE {table_name} (
    {col_1} {data_type} {etc},
    {col_1} {data_type},
    {col_1} {data_type}
);
-- INSERT data
INSERT INTO {table_name} (col_1,col_2,col_3)
VALUES (values_corresponding_to_column);

-- SELECT
SELECT col_1 FROM {table_name};
SELECT * FROM {table_name};

-- ALter :adds a new column to table
ALTER TABLE {table_name}
ADD COLUMN {col_name} {data_type};

-- UPDATE : edit records
UPDATE {table_name}
SET {col_name} = {new_value}
WHERE id = {PRIMARY_KEY_value};

-- DELETE : delete records
DELETE FROM {table_name}
WHERE {condition} ex) twitter_handle IS NULL;

-- CONSTRAINTS
CREATE TABLE {table_name}(
    id INEGER PRIMARY KEY,
    name TEXT UNIQUE,
    data_of_birth TEXT NOT NULL,
    date_of_death TEXT DEFAULT 'Not Applicable'
);
-- PRIMARY KEY: means allowing only one identified value among column. table has only one PRIMARY KEY.
-- UNIQUE: Similar to PRIMARY KEY but, table can have many number of UNIQUE column
-- NOT NULL: must have value, now allow null.
-- DEFAULT: Default value for unspecified value.


-- AS
SELECT {col_name} AS '{alias_name}' FROM {table_name};
-- AS is used to rename a column using an alias


-- DISTINCT
SELECT DISTINCT {col_name} FROM {table_name};
-- DISTINCT is useful to get kinds in data without repetition.
-- This is good to check how many or what kinds of records exists in Table


-- WHERE: condition.
SELECT * FROM {table_name} WHERE {condition};  ex){col_name} > 8
-- =, !=, >, <, >=, <=

-- LIKE
SELECT * FROM {table_name} WHERE {col_name} LIKE 'bla_bla';
--  _ is an wildcard character to substitute any letter
--  % is an wildcard character to express zero or more missing letters
SELECT * FROM {table_name} WHERE {col_name} LIKE '%A%B%';
-- @@@ LIKE! is not case sensitive. It recognize cases regardless of upper of lower


-- IS NULL & IS NOT NULL
-- Null is missing value. = and != are not working for this NULL
SELECT {col_name} FROM {table_name} WHERE {col_name} IS NOT NULL;



-- BETWEEN
SELECT * FROM {table_name} WHERE {col_name} BETWEEN 'A' AND 'J';
-- query to get records in {col_name} that begin with 'A' to very one before 'J', 'I' not including 'J'!! tricky point

SELECT * FROM {table_name} WHERE {col_name} BETWEEM 1990 AND 1999;
-- In this case. from 1990 to 1999 including second one!!!
-- remember this tricky behavior. for the letters, neglect second one.
-- but not to neglect the one in case of numbers


-- AND: To combine multiple conditions. Cross section
SELECT * FROM {table_name} WHERE {Conditoin 1} AND {Condition 2}..
-- Tip: For the text records! only single quotation mark is allowed to express text.


-- OR: To combine muliple conditions Union
SELECT * FROM {table_name} WHERE {Condition 10} OR {Condition 2}..


-- ORDER BY : sorting along with specified column
SELECT * FROM {table_name} ORDER BY {col_name}
-- Ascending order
SELECT * FROM {table_name} WHERE {condition1} ORDER BY {col_name} DESC;
-- Descending order


-- LIMIT
SELECT * FROM {table_name} LIMIT {limit_number}
-- LIMIT is caluse to set maximum rows to show.

-- OFFSET
SELECT * FROM {table_name} LIMIT {limit_number} OFFSET {offset_number};
-- LIMIT and OFFSET are appropriate to make bulletin board. (pagination)

-- CASE : this statement is to create another output
SELECT name,
    CASE
        WHEN imdb_rating > 8 THEN 'Fantastic'
        WHEN imdb_rating > 6 THEN 'Poorly Received'
        ELSE 'Avoid at All Costs'
    END AS 'REVIEW'
FROM movies;
-- WHEN : conducting condition to test. If it is true, give value
-- ELSE : If all the above conditions are false.
-- CASE must end with 'END'
-- AS, which is behind END, assign new column name.

```

#### SQL Calculation

```sql
-- COUNT
SELECT COUNT({col_name}) FROM {table_name};


-- SUM
SELECT SUM({col_name}) FROM {table_name};


-- MIN/MAX
SELECT MAX({col_name}) FROM {table_name};

-- AVG
SELECT AVG({col_name}) FROM {table_name};

-- ROUND
SELECT ROUND({col_name},int_value) FROM {table_name};


-- GROUP BY : to aggregate data (merging)
SELECT {col_1},AVG({col_name}) FROM movies
GROUP BY {col_1}
ORDER BY {col_1};


-- GROUP BY II : 
SELECT ROUND(imdb_rating), COUNT(name)
FROM moives
GROUP BY 1
ORDER BY 1;
-- 1 : first column selected, 2: second column selected...


-- HAVING
SELECT {col1}, {col2},COUNT({col3})
FROM {table_name}
GROUP BY 1,2
HAVING COUNT({col3}) > 10;
-- HAVING is very similar to WHERE but, HAVING is for data after group-aggregation and WHERE is for pristin rows
-- Remarks: HAVING Ccomes after GROUP BY, but must be before ORDER BY and LIMIT


```

#### SQL Joining table operations

```sql

-- Combining Table
-- JOIN
SELECT * FROM {table1} JOIN {table2} ON {table1}.{col} = {table2}.{col}
-- Remarks: The simple JOIN neglect not corresponding data



-- LEFT JOIN
SELECT * FROM {table1} LEFT JOIN {table2} ON {table1}.{col} = {table2}.{col};
-- If records in col1 does not coincide, delete other property on {table2} joining to {table1}


-- PRIMARY KEY and FOREIGN KEY
-- If A table contains column, which is a primary key in other table, it is called FOREIGN KEY. FOREIGN KEY have an important role in joining


-- CROSS JOIN


```
**Remarks**
Rule of Primary key
    1. None of the values can be `NULL`
    2. Each value must be unique
    3. A table can not have more than one primary key column.



## MongoDB
It seems like key-value pair database.


## Redis
Ram caching.

## ElasticSearch