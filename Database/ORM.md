# Object Relational Mapping (ORM)

ORM: RDB => Object-type

SQLAlchemy (python)
flask-sqlalchemy (flask)

Base python code for ORM
```python

from flask import Flask, render_template, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///blog2.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)

```


**ORM is useful for transplanting code between DBMS**
