# Jinja

















## template inheritance (extension?!)

**This is like string interpolation**

```html
<!-- layout.html (super template)-->
{% block content %}
<!-- This position -->
{% endblock %}
```


```html
<!-- target.html (sub template)-->
{%extends "layout.html"%}
{% block content %}
<!-- Contents -->
{% endblock %}
```


{% include "footer.html" %}
**This is just including!! at C or C++**