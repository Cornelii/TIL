# JAVASCRIPT and HTML
HTML: Skeleton
CSS: Appearance
Javascript: Dynamic, Move, Interactive

javascipt is encapsulated in HTML with tag `<script>`

## I. Javascript Interactive Website

#### 1. Bring Script From Other File!
use of `src` attribute

`<script src="script.js"></script>`

**Remarks** The way HTML parser work with javascript
1. HTML parser does not proceed until it executes `<script>` when meet this.
2. sciprts are loaded sequentially

#### 2. defer Attribute
The defer attribute in script tag `<script>`

example
```html
<script src="test.js" defer></script>
```
defer tag specifies what javascript should be executed and postpones execution of the javascript untial paser has done its work over the HTML document.


#### 3. async Attribute
**async** attribute of `<script>` is similar the **defer**.
When HTML parser meet async in script, it goes on.
And, regardless of the progress of HTML parser. javascript is loaded as soon as it is downloaded.

#### 4. keyword document

`document` is like class html itself.
If you want to access to `<head>`
document.head is allowed to point the `<head>`

> document keyword is like this or self in programming languages as it assumes document is instance of html class.

#### 5. .innerHTML 
example
```javascript
document.body.innerHTML = "Context"

```
It replaces text between the assigned tag (body in this case)  with context ("Context" in this case.) that could be considered as html text.

#### 6. Select and Modify Elements
CSS selector is also available to access the element we want in javascript!

* `.querySelector({tag})` This returns first element that matches the selector.

example
```javascript
document.querySelector('p');
```

* `.getElementById()` reference by id 

example
```javascript
document.getElementById('id1').innterHTML = "other description";

```

#### 7. Style an element

`.style` property make us be able to access inline property in DOM.

example
```javascript
let A = document.querySelector('.red');

A.style.backgroundColor = 'yellow';
```
**Remarks**: Javascript use camel case notation.

#### 8. Create and Insert Elements

`.createElement({tagName})` This creates a new element based on tag name.

`.appendChild({generated_element})` is necessary to make it shown.

example
```javascript
let add1 = document.createElement("div");
add1.innerHTML = "Yes, it is.";
add1.id = "add1_hahaha";
document.getElementBy("somewhere_id").appendChild(add1);
```

#### 9. Remove an Element
`.removeChild()`

example
```javascript
remove_target = document.getElementById('target_id');
parent_target = document.getElementById('parent_id');
parent_target.removeChild(remove_target)
```
`.hidden = true (false);`
is also available. However, this is not for removal and does not have somthing to do with CSS visibility property.

#### 10. Interactivity wieh onclick

Assigning a function based on an **event**

`.onclick`

example
```javascript
let element = document.getElementById('target');
element.onclick = function(){
    element.style.backgroundColor = 'yellow'
};

let element = document.querySelector("button");

function turnButtonRed (){
	element.style.backgroundColor = "red";
  element.style.color = "white";
  element.innerHTML = "Red Button"; 
}

element.onclick = turnButtonRed;

```

#### 11. Traversing the DOM
properties
`.firstChild ` => first child.
`.parentNode` => parent node.


#### 12. Proj#1

##### 1. style.css cursor property as pointer;
This make tag object that can be clikced.

```css
#id1 {
  cursor:pointer;
}
```


## II. DOM Events with javascript

#### 1. Firing Events