# CSS basic


## I. Basic use of CSS
       (property)
   `h1 {color:blue; font-size:15px;}`
  (selector)   (value)

### 1. Linkage between HTML and CSS
* inline   
* internal
* external


```html

<h2 style="color:red;">inline</h2> 

<head>
    <style>
        h1{
            color:blue;
            font-size:50px;
        }

    </style>
</head>
<body>
    <h1>internel</h1>
</body>

<!-- External -->

<head>
    <link href="style.css" rel="stylesheet"/>
</head>

<!-- or -->
<style>
    @import "style.css"

</style>


```
#### Remarks! each property should be separated by semicolon ; not comma ,

### 2. Selector
Tag can be used. but, Further, Grouping is also available to apply styles. 
* id     #
* class  .
* 



### 3. Box model
margin-border-padding-content

retangular world~!

### 4. Cascading order
#### CSS specificity
1. !important
2. inline tag
3. #id
4. .class
5. tag name
6. global
                       excluding virtual class, etc.
#### order in declaration
Latter style declared.

### 5. frequently used properties and attributes


[choosing color_tip]("https://htmlcolorcodes.com/")


#### Regarding size
1. em
2. %
3. rem (based on root)
4. Viewport unit

#### visibility, display


#### background-image , color, repeat, size, etc
ex)
```html

<div style="background-color:{color}"></div>
<div style="background-image: url({image_url})"></div>
<div style="background-repeat: no-repeat;"></div>
```

#### font-size, font-family, text-align
[Google Font](https://fonts.google.com/)


#### positioning
```html
h {
    position: relative;

}

```

##### 1. static
Default

* margin merging has only meaning in marin-top, bottom.

##### 2. relative
move based on parent class
```html
h {
    position: relative;
    top: 100px;
    left: 100px;
}

```

* However, it still takes tag order(original position)

##### 3. absolute
* It escape from origin tag position. Of course, Other following tag negelect its abolute-positioned tag in position.
* It is based on non-static tag
* Using absolute, the order of tag could be kind of neglected

##### 4. fixed
It is fixed regardless of scroll!
* It also escape from original position. It works like absolute in this manner.

**View-port based positioning!**

### transition
It makes property transition soft.

example HTML
```html
<head>
<!-- bla bla bla -->
<style>
    a {
        font-size: 3rem;
        display: inline-block;
        transition-property: font-size transform;
        transition-duration: 0.5s;
    }
    a {
        transition: font-size 1s, transform 0.5s;
    }
    a {
        transition-timing-function: cubic-bezier();
    }


    a:active {
        transform:translate(20px, 20px);
        font-size:2rem;
    }
</style>
</head>
<body>
    <a href="#">Click</a>
</body>


```

### code minification
ex)
[code](http://adam.id.au/clean-css-online/)


### A shortcut to remove cache in chrome
ctrl + sheet + R