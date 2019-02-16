# HTML tags

## I. tag
#### 1. Block level tags
This takes an entire row (horizontal place) on given page!

* div, h1~6,p,ol,ul,hr,table,form

They can inlcude inline level tags in them.

#### 2. Inline level tags
Inline tags fill a line one by one successively.
These only takes the width of content in them.

It can not set width,height, margin-top, maring-bottom.
However, margin-top and marin-bottom are available.

* a

We cand change the block propensity to inline by
**style tag => display: inline; **
vice versa
**style tag => display: block; **

#### 3. Inline-blcok level tags
inline but, it can be set all the properties like margin-top.

#### 4. None
Nothing.
This is frequently used with Javascript

**block, inline, inline-block, none are in property of display **

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



