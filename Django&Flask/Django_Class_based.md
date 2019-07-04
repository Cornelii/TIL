# Django_Class_based View
A view is a callable that takes a request and returns a response.

All views(class-based) inherits the View class.

RedirectView is for a somple HTTP redirection

TemplateView extends the base class to make it also render a template


urls.py
```python
from django.urls import path
from django.views.generic import TemplateView

urlpatterns = [
    path('about/', TemplateView.as_view(template_name="about.html")),
]

# Simplest way to use generic view directly in URLconf
```

other way

views.py
```python
from django.views.generic import TemplateView

class AboutView(TemplateView):
    template_name = "about.html"
```

urls.py
```python
from django.urls import path
from .views import AboutView

urlpatterns = [
    path('about/', AboutView.as_view())
]
```


