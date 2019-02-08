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
db.init_app(app)

class Article(db.Model):
    __tablename__ = "articles"
    __table_args__ = {'sqlite_autoincrement': True}
    id = db.Column(db.Integer,primary_key = True, autoincrement=True)
    title = db.Column(db.String, nullable = False)
    content = db.Column(db.String, nullable =False)
    author = db.Column(db.String, nullable =False)
    created_at = db.Column(db.String, nullable =False)
    
db.create_all()

```




**ORM is useful for transplanting code between DBMS**
