# Jinja


## Recieve variables from render_template in app.py
{{var_name in render_template}}


## jinja loop
```html
<!-- var_name comes from render_template -->
{% for val in var_name%} 

    {{val}}_blablabla

{% endfor %}
```

## jinja contiional statement









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


`{% include "footer.html" %}`
**This is just including!! like at C or C++**



## At c9, file access.
`href="{{ url_for('static', filename='style.css') }}"`
