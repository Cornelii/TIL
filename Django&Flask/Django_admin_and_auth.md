# Django admin and auth

```python
from django.contrib import admin

from .models import Question


# this is customizing your admin page
class QuestionAdmin(admin.ModelAdmin):
    fields = ['pub_date', 'question_text']


admin.site.register(Question, QuestionAdmin)
```

#### 1. more structured admin page
```python
from django.contrib import admin

from .models import Question


class QuestionAdmin(admin.ModelAdmin):
    fieldsets = [
        (None,               {'fields': ['question_text']}),
        ('Date information', {'fields': ['pub_date']}),
    ]

admin.site.register(Question, QuestionAdmin)
```

#### 2. 1:N ForeignKey_considered admin page
```python
#...

class ChoiceInline(admin.StackedInline): # or inherit  admin.TabularInline
    model = Choice
    extra = 3


class QuestionAdmin(admin.ModelAdmin):
    #...

    inlines = [ChoiceInline]

admin.site.register(Question, QuestionAdmin)
```

#### 3. make fields show on admin list page
```python
#...
class QuestionAdmin(admin.ModelAdmin):
    list_display = ('question_text', 'pub_date')
    #...
#...
```

#### 4. append Search Capability
```python
#...
class QuestionAdmin(admin.ModelAdmin):
    search_fields = ['question_text']
    #...
#...
```


#### advanced
sort of method things in model class at adminpage

models.py
```python
class Question(models.Model):
    # ...
    def was_published_recently(self):
        now = timezone.now()
        return now - datetime.timedelta(days=1) <= self.pub_date <= now
    was_published_recently.admin_order_field = 'pub_date'
    was_published_recently.boolean = True
    was_published_recently.short_description = 'Published recently?'
```

admin.py
```python
#...
class QuestionAdmin(admin.ModelAdmin):
    #...
    list_filter = ['pub_date']
#...
```
