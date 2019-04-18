# Django templates





## I. Template Grammar

#### 1. forloop.counter
```html
{% for post in user.posts %}

    {{forloop.counter}}
{% endfor %}
<!-- forloop counter is like index in enumerate -->
```

#### 2. csrf-token for POST method
```html
<form method="POST">
{% csrf_token %}
</form>
```