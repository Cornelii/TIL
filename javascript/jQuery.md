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
When assigning `$()` to the variable, add `$` right in front of the variable name as well! It emphasize the variable is a jQuery object

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



## IV.

## V.

## VI.

## VII.

## VIII.

## IX.

## X. 