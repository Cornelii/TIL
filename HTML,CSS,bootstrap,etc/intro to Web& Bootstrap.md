# Web service, Bootstrap
get away from bonobono.

## I. Web service
Service => request & response
**SAAS: Software as a Service**
* Web service: software about request & response on the Web
Client <=> Server
* Web: World Wide Web invented by Tim bernerse Lee

* http: hyper text transfer protocol

* Making a web service is almost the same as making a server computer where program is working to deal with request and response.

* kind of Request
    1. Get
    2. Post
    3. etc
* Static Web. Unidirectional?! limited from point of view of client.

#### 1. IP, Domain, and URL
* IP (Internet Protocol)
ex) 172.217.27.78 
* Domain
google.com
* URL(Uniform Resource Locator)
https://www.google.co.kr/esarch?q=구글

* W3C: World Wide Web Consortium
 
* HTML+CSS+JavaScript(ES6 - ecmascript)

## II. REST API (Representational State Transfer)
This is kind of convention?!



## III. BootStrap
put bootstrap CDN code HTML'head

**Tip**: **contents delivery network, or contents distribution network (CDN)**

Many styles are predefined at the source css file.
you can easily use the styles by assigning corresponding classes.

You'd better work with opening up the bootstrap website.

#### 1. colors in bootstrap
    1. primary
    2. secondary
    3. success
    4. danger
    5. light
    6. dark
    7. warning
    8. success
These names are used with specific prefix like btn-primary as class type in HTML doc

#### 2. Text in bootstrap
* .text-justify
* .text-left
* .text-center
* .text-right
* .text-lowercase
* .text-uppercase
* .text-capitalize
* .d-inline-block .text-truncate

* .font-weight-bold
* .font-weight-light
* .font-weight-nomral
* .font-italic

#### 3. Spacing in bootstrap
##### 1. main space type
m: margin
p: padding

##### 2. specific position of the space
t: top
b: bottom
l: left
r: right
x: l & r
y: t & b

##### 3. amount
0, 1, 2, 3, 4, 5, auto
n0, n1, n2, n3, n4, n5

example

`mt-0 mb-n1 px-5`

**Tip** Look around bootstrap css source file

#### 4. flex in bootstrap
with `.d-flex`
* .flex-row
* .flex-row-reverse
* .flex-column
* .flex-column-reverse

* .justify-content-start
* .justify-content-end
* .justify-content-center
* .justify-content-between
* .justify-content-around

* .align-items-start
* .align-items-end
* .align-items-center
* .align-items-baseline
* .align-items-stretch

* .flex-nowrap
* .flex-wrap
* .flex-wrap-reverse

* .order-{n}  {n}: integer


with `.flex-wrap`
* .align-content-start
* .align-content-end
* .align-content-center
* .align-content-baseline
* .align-content-stretch

#### 5. Grid System

`.container` manifest 12 columns-divided grid system.
(`.container-fluid` for 100% width w.r.t viewport )

class of `.row` has initially `d-flex` property?!!!


```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Grid Practice</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <div class="row">
                
            
        </div>
    </div>
    
</body>
</html>
```

#### 6. other class-based methods
* .float-left
* .float-right
* .float-none

* .position-static
* .position-relative
* .position-fixed
* .position-absolute
* .position-sticky (available in a few webbrowsers)

* .w-{n}
* .h-{n}
* .mh-{n}
* .mw-{n}


#### 7. display
* .d-flex
* .d-block
* .d-none
* .d-inline
* .d-inline-block

#### 8. vertical alginments within an element
* .align-baseline
* .align-top
* .align-middle
* .align-bottom
* .align-text-top
* .align-text-bottom


#### 9. reactive web
|size|Extra small|Small|medium|Large|Extra Large|
|---|---|---|---|---|---|
||<576px|>=576px|>=768px|>=992px|>=1200px|
||`.col-`|`.col-sm-`|`.col-md-`|`.col-lg-`|`.col-xl-`|
|Maximum container size|None|540px|720px|960px|1140px|

## ETC
* Web Developer Chrome Extension
* AWS route 53
* AWS certificate Manager
* Rset api
* use of Sass with CSS

