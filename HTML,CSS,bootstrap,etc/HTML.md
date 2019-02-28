# HTML tags

Hypertext mark-up language

## I. Basic Structure

```HTML
<!DOCTYPE HTML>
<html>
    <head>
        
    </head>
    
    <body>
        
    </body>
</html>
```

## II. Tag and DOM TREE. (Document Object Model) DOM Tree make search easier.
HTML is composed of Tag and Contents.
### Tag
1. open-closing element ex) `<h1></h1>`
2. self-closing element  ex) `<img src=""/>`
3. Attributes ex) `<a href="{attribute_value}">`
4. Semantic tags
   * header
   * nav
   * aside
   * section
   * article
   * footer
Semantic tag help user feel comfortable.

Inheritance is specified by DOM-TREE strucure.

## III. Fundamental classification of tags
#### 1. Block level tags
This takes an entire row (horizontal place) on given page!

* div, h1~6,p,ol,ul,hr,table,form

They can inlcude inline level tags in them.

#### 2. Inline level tags
Inline tags fill a line one by one successively.
These only takes the width of content in them.

It `can not` set `width, height, margin-top, and marin-bottom.`
However, margin-left and marin-right are available.

* a, span, strong, img, br, input, select, textarea, button

We can change the block propensity to inline by
**style tag => display: inline;**
vice versa
**style tag => display: block;**

#### 3. Inline-blcok level tags
inline but, it can be set all the properties like margin-top.

#### 4. None
Nothing.
This is frequently used with Javascript

**block, inline, inline-block, none are in attribute of display**

#### After flex
When flex is applied, the tags's display become inline!

## II. Hyperlink within a document.
make a tag with id! And, another a tag with href of #the_id.

```html
<body>
<a id="goto"></a>


<a href="#goto">I want to go to `goto`</a>

</body>
```

## III. CSS & HTML

#### -CSS by external .css file

`<link rel="stylesheet" href="   .css">`




#### Tips
[caniuse](https://www.caniuse.com/)