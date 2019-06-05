# Django: restframework
djangorestframework & django-rest-swagger

`pip install djangorestframework`
`pip install django-rest-swagger`

## djangorestframework
settings.py
```python
#...
INSTALLED_APPS = [
     'rest_framework',
     
]


#...

```




#### 1. User of Serializer

serializers.py @ app directory
```python
from rest_framework import serializers
from .models import Movie, Score, Genre


class GenreSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = Genre
        fields = ['id','name']


class MovieSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = Movie
        fields = ['id', 'title', 'audience', 'poster_url', 'description','genre_id']
        

class ScoreSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = Score
        fields = ['id', 'content', 'score', 'movie']
        # fields = '__all__'
```

This is pretty similar to declaration of forms

#### 2. views.py

Frequently used modules @ views.py
```python
from django.shortcuts import render, get_object_or_404
from rest_framework.decorators import api_view
from rest_framework.response import Response
```

for the following code snippets
```python
from .models import Genre, Score, Movie
from .serializers import GenreSerializer, MovieSerializer, ScoreSerializer
```

#### 3. GET

```python
@api_view(['GET'])
def genre_list(request):
    genres = Genre.objects.all()
    serializer = GenreSerializer(genres, many=True)
    return Response(serializer.data)

@api_view(['GET'])
def genre_detail(request, genre_id):
    genre = get_object_or_404(Genre, id=genre_id)
    movies = genre.movies.all()
    serializer = MovieSerializer(movies, many=True)
    return Response(serializer.data)
```
`serializer = UserDefindSerializer(a/instances ,many=True/False)`
`return Response(serializer.data)`

##### i. serializer 선언 중 옵션 many=True의 경우
**serializer:** ListSerializer
**serializer.data:** ReturnList
**serializer.data[0]:** collections.OrderedDict
**Response(serializer.data):** Response object
Response.data == ReturnList (serializer.data)

##### ii. serializer 선언 중 옵션 many=False의 경우
**serializer:** 선언한 Serializer that inherits serializers.ModelSerializer
**serializer.data:** ReturnDict
**Response(serializer.data):** Response object
Response.data == ReturnDict (serializer.data)


Response Object는 json내용이 들어있는 HTML을 렌더링 해줌.

#### 4. POST
```python
@api_view(['POST'])
def post_score(request, movie_id):
    movie = get_object_or_404(Movie,id=movie_id)
    if request.method == 'POST':
        serializer = ScoreSerializer(data=request.data)
        if serializer.is_valid(raise_exception=True): #appropriate exception. especially 405 bad request
            serializer.save()
            return Response({"message":"작성되었습니다."})
```

* `form 대신 serializer 선언 (data에 request.data)`
* `.is_valid()`, `.save()`, `raise_exception=True`=> 잘못된 양식일 경우 405 bad request처리 해줌.
`Response에 json파일처럼 dict가 들어올 수 있음.`


#### 5. PUT, DELETE
```python
@api_view(['GET','PUT','DELETE'])
def score_detail(request, score_id):
    score = get_object_or_404(Score, id=score_id)
    if request.method == 'GET':
        serializer = ScoreSerializer(score, many=False)
        return Response(serializer.data)
    elif request.method == 'PUT':
        serializer = ScoreSerializer(score, data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save()
            return Response({"message":"수정되었습니다."})
    elif request.method == 'DELETE':
        score.delete()
        return Response({"message":"삭제되었습니다."})
```

수정을 위한 put의 경우 form과 비슷하게 해당 인스턴스를 먼저 serializer에 먼저 넣어주고, `data=request.data`


`@api_view 데코레이터는 들어오는 Http메소드를 제한해줌.`

## II. Use of django-rest-swagger

자동으로 api관련 doc을 생성해줌.

urls.py
```python
#...
from rest_framework_swagger.views import get_swagger_view
#...

urlpatterns = [
    #...
    path('docs/', get_swagger_view(title="API_docs")),
    ]
```