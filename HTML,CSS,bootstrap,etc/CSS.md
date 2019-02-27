# CSS basic


## I. Basic use of CSS
`h1 {color:blue; font-size:15px;}`
(selector) { (property): (value);}

#### 1. Linkage between HTML and CSS
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
**Remarks**: each property should be separated by semicolon ; not comma ,

## II. Selector
Tag can be used. but, Further, Grouping is also available to apply styles. 
* id     #
* class  .
* tag name, etc

**selector example**

```css
* {
    margin: 0;
    padding: 0;
}

section, ul {
    margin: 10px 0px;
}

section > ul > li {
    font-size: 20px;
    font-weight: bold;
}


a + ul {
    background-color:yellowgreen;
}
/* ul next a in same level */
a ~ ul {
    border: 1px solid darkgray;
}
/* all <ul>s next a in same level */
/* +,~ are not about relationship between parent and child */

a[target="_self"] {
    border: 1px solid darkgray;
    border-radius: 5px;
    background-color: white;
    padding: 5px;
}
/* [] => properties Remarks use of "="  */

.me {
    background-color:black;
    color:white;
    font-size:50px
}

img[alt=""] {
    box-shadow: -1px -1px 5px goldenrod;
}

img[alt|="TYPE"] {
    box-shadow: -1px -1px 5px cyan;
    opacity:0.7;
}
/*   |=  means all the things following "word" and the "word plus - something"  */

a[target^="_b"] {
    background-color:blueviolet;
    padding:10px;
    margin: 20px;
    color:whitesmoke;
    display:inline-block;
}
/*   ^=  means all the things start with following word  */

a[href$="istj"] {
    background-color:rosybrown;

}
/*  $= means element property that end with following word*/

ul[class*="type"] {
    text-align: center;
    padding: 35px 0;
}
/* *= means element all the things including following word */


ul[class~="type"] {
    border: 1px dashed purple;
}
/* ~= means element all the things including following word but independently without link like -,_, other word etc */

a:not([href]):not([tabindex]) {

}
/* not property of href and tabindex */



```

## III. Box model
margin-border-padding-content

retangular world~!

**width, and height include padding!!**


## IV. Cascading order
#### 1. CSS specificity
1. !important
2. inline tag
3. #id
Pseudo-classes
Attributes selector [href], [target], etc
4. .class
5. tag name
6. global  (`*`, `body *`)
                       excluding virtual class, etc.
#### order in declaration
Latter style declared.

## V. frequently used properties and attributes


[choosing color_tip]("https://htmlcolorcodes.com/")


#### 1. Regarding size
1. em
2. %
3. rem (based on root)
4. Viewport unit

#### 2.visibility
visible
hidden
collapse (only for table )
inherit

#### 3.display
block
inline
inline-block
none

```css
a {
    display: block;
}
```
##### 1. block elements
div, h, p, ol, ul, hr, table, form

##### 2. inline elements
span, a, strong, img, br, input, select, textarea, button


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
```css
h {
    position: relative;

}
```
position are controlled by properties of `top, bottom, left, and right`

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
* It is based on non-static tag (relative, absolute, and fixed)
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

