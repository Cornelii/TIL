# Django_ORM_query

## I. Basic CRUD Operations
```python
from .models import MyModel

# Create
## 1.
MyModel.objects.create(name='he', nickname='kay')

## 2.
record = MyModel(name='she', nickname='keen')
record.save()

# Retrieve
## 1.
MyModel.objects.all() 
MyModel.objects.first() 
MyModel.objects.last() 
MyModel.objects.get(id=5) # other field can be refered as well.
MyModel.objects.filter(name='sdf')
### MyModel => model class
### MyModel.objects => model manager
### MyModel.objects.methods() => return an object or objects

# Update
## 1.
record = MyModel.objects.get(id=3)
record.name = 'new name'
record.save()

# Delete
record = MyModel.obejcts.get(id=2)
record.delete()
```

## II. Lookups with Q objects
```python
from django.db.models import Q
```

`__startwith`

`__year`

`date(2019,4,1)`



