# Django Seeding

app 내에, `fixtures` data 생성하고 아래 양식의 json파일을 넣음.
(json 내에 모델 일치시킴.)

```json
[
    {
        "pk": 1,
        "model": "movies.movie",
        "fields": {
            "title": "캡틴 마블",
            "audience": 3035808,
            //...
        }
    },
    {
        "pk": 2,
        "model": "movies.movie",
        "fields": {
            "title": "항거:유관순 이야기",
            "audience": 1041939,
            //...
        }
    }
]
```

`python manage.py loaddata {}.json`