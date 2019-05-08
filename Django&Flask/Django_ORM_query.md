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

## II. Making queries

#### 1. Create
```python
from .models import Blog
# i
b = Blog(name='My blog', tagline='First blog')
b.save()

## ii
Blog.objects.create(name='My blog', tagline='First blog')


```
#### 2. Retrieve
```python
blogs = Blog.objects.all() # return all
blog = Blog.objects.get(name="My blog") # return only one (please use primary key. otherwise, MultipleObjectsReturned Error)
blogs = Blog.objects.filter(name="My blog") # return Query Set
# .exclude() opposite to .filter()
## .filter() and .exclude() can be chained even one another or itself.
## multiple query condition is also available in .filter() by separated comma
## However, exclude() works differently

#exclude() to be applied with multiple query condition example
Blog.objects.exclude(
    entry__in=Entry.objects.filter(
        headline__contains='Lennon',
        pub_date__year=2008,
    ),
)

# Limiting by Slicing
blogs = Blog.objects.all()[:4]


# ordering   .order_by('columns name')
blogs = Blog.objects.order_by('created_at')[0]
```

##### i. Field Lookups
Basic lookups keyword: `field__lookuptype=value`
double underscore
example
```python
Entry.objects.filter(pub_date__lte='2006-01-01')
```

##### ii. lookup types
* exact : exact match
* iexact : case-insensitive match (no matter what case, lower or upper)
* contains : case_sensitive containment test
* icontains : case-insensitive contains
* startswith, endwith, istartwith, iendwith,
* lte: larger than or equal >=
* in

##### iii. Lookups that span relationships
example
```python
Comment.objects.filter(blog__name="My blog")

Comment.objects.filter(blog__name__contains="My")

# multiple relationships can be refered by using `__` double underscore sequentially.
```

##### iv. F expressions
`F` is used to compare a value of a model field with a value of another model field, not with a constant.
example
```python
Blog.objects.filter(num_comments__gt=F('fieldname1')*2)

Blog.objects.filter(comments=F('fieldname2'))

# Bitwise operations are also provided.
```

##### v. LIKE statements
example

(iexact, i/contains, i/startwidth, i/endwidth) can be used with
two wildcard
one is a multi-character wild card: `%`
the other is a one-character wild card: `_`
```python
Blog.objects.filter(name__contains='_%')

```

#### 3. Update 
```python
b = Blog.objects.get(id=2)
b.name = 'new name'
b.save()
```

* update non-relational fields and ForeignKey for **all the objects!(be carefull)**
```python
Blog.objects.filter(~~).update(name="Renamed")
### !! .update() is a method of queryset!
```


#### 4. Delete
```python
b.delete()

```
#### 5. QuerySets & Cache
* bad case#1
```python
print([e.headline for e in Entry.objects.all()])
print([e.pub_date for e in Entry.objects.all()])
```
=> modified
```python
queryset = Entry.objects.all()
print([p.headline for p in queryset]) # Evaluate the query set.
print([p.pub_date for p in queryset]) # Re-use the cache from the evaluation.
```

* bad case#2
```python
queryset = Entry.objects.all()
print(queryset[5]) # Queries the database
print(queryset[5]) # Queries the database again
```
=> modified
```python
queryset = Entry.objects.all()
[entry for entry in queryset] # Queries the database
print(queryset[5]) # Uses cache
print(queryset[5]) # Uses cache
```

#### 6. ForeignKey and ManyToManyField Assigning
```python
# ForeignKey
b = Blog.objects.get(id=6)
comment = Comment.objects.get(id=4)
comment.blog = b


# ManyToManyField
.add(obj1, obj2,..), .create(**kwargs), .remove(obj1, obj2),
.clear(), .set(objs) # set is for replacement
```

#### 7. Complex Lookups with Q objects!!!!
For more complex queries! use Q (django.db.models.Q)

Q(conditional query)
Qs can be combined with `&`,`|`, and `~` (not query)

example
```python
~Q(question__startswith='Who') | Q(question__startswith='What')
```
Furthermore,
similar to use of filter case,
Q can be mixed with keyword arguements like as follows

```python
Poll.objects.get(
    Q(pub_date=date(2005, 5, 2)) | Q(pub_date=date(2005, 5, 6)),
    question__startswith='Who',
)
```
In this case, Q() statements must come first


#### 8. Copying model instances
overlap pk, then save() again!
```python
blog = Blog(name='My blog', tagline='Blogging is easy')
blog.save() # blog.pk == 1

blog.pk = None
blog.save() # blog.pk == 2
```

For inheritence case! overlap both id and pk
```python
django_blog.pk = None
django_blog.id = None
django_blog.save() # django_blog.pk == 4
```

For ManyToMany case, to copy relation as well.
```python
entry = Entry.objects.all()[0] # some previous entry
old_authors = entry.authors.all()
entry.pk = None
entry.save()
entry.authors.set(old_authors)
```

For OneToONe, not to violate unique constraint.
```python
detail = EntryDetail.objects.all()[0]
detail.pk = None
detail.entry = entry
detail.save()
```

## III. QuerySet APIs

* filter()
* exclude()
* order_by()
* reverse()

#### 1. annotate() and aggregation function





#### 2. distinct()





#### 3. values()
This returns QuerySet eliminating duplicated row.

example
`Entry.objects.order_by('blog').distinct('blog')`





