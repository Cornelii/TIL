# SQL by Python

## example code
```python
import sqlite3

conn = sqlite3.connect('test.sqplite3') # connection is needed.

cur = conn.cursor() # cursor must be generated

cur.execute('SELECT * FROM users LIMIT 10') # cursor.execute({sql_statement})

# Remakrs FOR THE CUD operation among CRUD
conn.commit() #commit is needed when database is revised.
# It seems like connectin works as a representative of database

#when bring data.
data = cur.fetchall() # fetchall() or fetchone()


```