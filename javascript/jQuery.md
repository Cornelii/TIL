# jQuery
javascript library!

**Remarks**: You'd better add <sciprt> tag for javascript or jQuery before the </body> tag to prevent affect HTML and CSS load times.


## I. Basic of jQuery

#### 1. Adding jQuery
```html
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
```
this CDN script must be before other script tag using jQuery!

[jQuery](https://code.jquery.com/)

#### 2. .ready()
To make interactivity with web page, web page must be rendered first.
Make sure jQuery is executed later web page load. used `.ready()`

example
```javascript
// This is kinds of wrapper!
$(document).ready(()=>{

// here all the javascript code.
});

```
#### 3. Targetting by Class
`$()`  syntax to create jQuery objects for getting elements on a web page.

parametered with string of id, class, tag.
class : '.class'
id : '#id'

#### 4. jQuery Objects
* Naming Convention
When assigning `$()` to the variable, add `$` in front of the variable name as well! It emphasize the variable is a jQuery object

example
```javascript
const $navDropdown = $('#nav-dropdown')
$navDropdown.hide();
```

#### 5. Event Handlers
`.on()`  : `.on('event_name', callback function)`

example
```javascript
const $menuButton = $('.menu-button');
const $navDropdown = $('#nav-dropdown');

$menuButton.on('click',()=>{
    navDropdown.show();
})
```

## II. Learn JQuery: Effects

#### 1. .show(), .hide(), and .toggle()
make the object appear. & hidden.

toggle make object function both .show, and .hide at the one.

#### 2. .fadeIn(), .fadeOut(), and .fadeToggle()
`.fadeIn(millisecond)`

example
```javascript
$('.fade-out-button').on('click', () => {
    $('.fade-image').fadeOut(500);
  });
  
$('.fade-in-button').on('click', () => {
  $('.fade-image').fadeIn(4000);
});
```

`.fadeToggle()` is a combination of `.fadeIn()` and `.fadeOut()`

example
```javascript
$('.fade-toggle-button').on('click', () => {
    $('.fade-image').fadeToggle('fast'); //integer is also available
});

```

#### 3. .slideDown(), .slideUp(), and .slideToggle()
example
```javascript
$('.up-button').on('click', () => {
		$('.slide-image').slideUp(100);
  });
  
  $('.down-button').on('click', () => {
    $('.slide-image').slideDown('slow');
  });
  
  $('.slide-toggle-button').on('click', () => {
    $('.slide-image').slideToggle(400);
  });

```


[jQuery-effects](http://api.jquery.com/category/effects/)

## III. Mouse Events

#### 1. Representative several mouse events

1. click
2. mouseenter (hover, mouseover)
3. mouseleave
4. dblclick
5. mousemove

```javascript
$('a').on('click', callback_fcn)
$('a').on('mouseenter', callback_fcn)
$('a').on('mouseleave', callback_fcn)
```

#### 2. Event Chaining
example
```javascript
$('.example-class').on('mouseenter', () => {
  $('.example-class-one').show();
}).on('mouseleave', () => {
  $('.example-class-one').hide();
});
```
**Tips**
1. .addClass
2. removeClass

#### 3. event.currentTarget
`$(event.currentTarget)` 
It gives not total class, but element that is just selected.

#### 4. etc event handler
1. keydown
2. keypress
3. keyup


## IV. CSS & jQuery

#### 1. css()
{jquery object}.css({css property}, {value})

example
```javascript
$('.nav-menu').on('mouseleave', () => {
    $('.nav-menu').hide();
    $('.menu-button').css('color','#EFEFEF');
  })
```

**Many properties also can be set using object**
```javascript
$('.a').on('event',()=>{
  $('.nav-menu').hide();
  $('.menu-button').css({
    color:'#EFEFEF',
    backgroundColor:'#303030',
  });
})
```

#### 2. animate()
`.animate()` is almost identical to `.css()`.
It can also get obejct. Furthermore, acting time can be set as a second parameter. 
`number, 'fast', 'slow'`

#### 3. addClass() & removeClass()
`$('.menu-button').addClass('class_name')`
**Notice!** : without `.` in front of class_name

#### 4. toggleClass()
The .toggleClass() method adds a class if an element does not already have it, and removes it if an element does already have it. Its syntax looks like:

`$('.menu-button').toggleClass('button-active');`

## V. Traversing DOM

#### 1. children(), parent(), and siblings()
method to get child, parent, and sibling elements correspondingly.


#### 2. closest()
`${jQuery object}.closest({class_name})`
It travel up from the {jQuery object} to find {class_name} and returns the closest {class_name} element.


#### 3. next() & .prev()
to get next or prevoius element of a selected element in sibling level.


#### 4. find()
find() looks for all the descendent elements coinciding filter parameter(id,tag, class, etc)

example)
```javascript
$('.more-details-button').on('click', event => {
    $(event.currentTarget).closest('.product-details').next().toggle()
    $(event.currentTarget).find('img').toggleClass('rotate')
  });  
```
