# Vuejs

CDN
```html
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js" defer></script>
```

## I. Vue Apps

```javascript
//app.js
const app = new Vue({});
// Vue class takes only one argument in the form of object. => options object
```

#### i. `el`
`el` stands for HTML `el`ement

```javascript
const app = new Vue({
    el:'#app_id'
});
```

#### ii. `data` (Decalarative rendering)
It contains sort of dynamic data in the form of object as well.

```javascript
const app = new Vue({
    el:'#app_id',
    data: {
        username:'Jason',
    }
});
```
In above case, username can be refered at html as mustaches in template as follows.

```html
<div id="app_id">
    {{uswername}}
</div>
```


#### iii. Directives (vue's feature)
Directives are custom HTML attributes built into Vue.
`v-if`, `v-for`, `v-model`, etc


##### v-if
example
```html
    <button v-if="userIsLoggedIn">Log Out</button>
    <button v-if="!userIsLoggedIn">Log In</button>
```
In this case, it will check `userIsLoggedIn` in `.data`.


##### v-for
```html
<ul>
    <li v-for="todo in todoList">{{todo}}</li>
</ul>
```
todoList in todo of data


##### v-model
```html
    <input v-model="username" />
```
This input automatically change the username in .data


[Vue directives](https://vuejs.org/v2/api/#Directives)

## II. Components
Vue has added the ability to create custom, reusable HTML elements called Components

component simple example
```javascript
const Tweet = Vue.component('tweet', {
 props: ['message','author'],
 template: '<div class="tweet"><h3>{{author}}</h3><p>{{ message }}</p></div>'
});	
```


```html
<tweet v-for="tweet in tweets" 
             v-bind:message="tweet"
             v-bind:author="username"></tweet>
```
`v-bind` is used to assign new attributes
(`v-bind:message` => `:message`)
The first argument of `Vue.component()` enables us to use custom tag in a Specified Vue element.

**frequently used**
- v-once
- v-on:events = "a method in Vue instance"
(`v-on:click` => `@click`)
- 

## III. Virtual DOM
Behind the scenes, Vue uses a really cool data structure called a virtual DOM to vastly improve speed and responsiveness of Vue apps. 

## IV. From the basics in Vue
1. import Vue CDN on html script tag

2. All Vue apps are instances of the Vue class provided by the imported Vue library
```javascript
const app = new Vue({})  // {}: options object
```

3. Attaching Vue Instances
```javascript
const app = new Vue({
    el:'#appId',
    data:{
        // mustache syntax
    },
    computed:{
        // derived value from values in data. !! caution this.data
    }
});
```

##### i. Computed Property Setters
`get` and `set`

```javascript
const app = new Vue({
    el:'#appId',
    data:{
        //key-value fairs
    },
    computed:{
        fcn1:{
            get:function(){},
            set:function(fcn1){}
        }
    }
})
```

When `fcn1` is called `get`is used, when fcn1 is changed `set` is called.


##### ii. filters
```javascript
const app = new Vue({
    el:'#app',
    data:{
        value:"sfsdf",
    },
    filters:{
        addToDo:function(val){
            //
        }
    }
})
```

at html, use of filter in template
```html
<div id="app"> 
    <h2>{{value | addToDo}}</h2>
</div>
```

##### iii. Watchers
It is watching when data changes.
At the time, it throws some actions.

```javascript
const app = new Vue({
    el:"app",
    data:{},
    watch: {
            todos: { // data안의 키
                handler: function(todoList){ // It must has the name of "handler", it returns what it have watched
                console.log("Todo 추가됬습니다.")
                }
            },
        }    
})

```


## X. Local Storage
웹 브라우저에 저장되는 Storage
> localStroage.setItem(key,val  or object),  getItem(key),  clear()

**브라우저 종료시 내용이 지워지는 sessionStorage도 존재한다.**

## XI. watch의 활용.

#### 1. watch에 정의된 함수들은 기본적으로 2가지 값을 인자로 받을 수 있게 된다.

(현재값, 이전값)

2. Ajax나 비동기 처리시 반환되는 Promise 객체는 Vue-directive에 바로 넘길 수 없으므로, vue data내에 값을 변경시키는 형태로 서비스를 구현하고 있다.

example code
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="main">
        <input type="radio" id="one" v-model="picked" value="Meow">
        <label for="one">고양이</label>
        <br>
        <input type="radio" id="two" v-model="picked" value="Bow!">
        <label for="two">댕댕이</label>
        <br>
        <span>{{picked}}</span>
        <img v-bind:src="image" alt="">
        <input type="text" v-model="test">
    </div>

    <!-- Vuejs -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <!-- Axios -->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
        // 고양이
        const catUrl = "https://api.thecatapi.com/v1/images/search"
        // 강아지
        const dogUrl = "https://dog.ceo/api/breeds/image/random"

        const dogAndCat = new Vue({
            el: '#main',
            data: {
                picked: '',
                image: '',
                test: '',
            },
            watch:{
                picked: function(val){
                    alert(val)
                    if(val ==="Meow"){
                        this.getCatImage();
                    }else{
                        this.getDogImage();
                    }
                },
                test: function(newValue, prevValue){
                    console.log('new', newValue);
                    console.log('previous', prevValue);
                }
            },
            methods:{
                getCatImage: async function(){
                    const response = await axios.get(catUrl);
                    const catImage = response.data[0].url
                    this.image = catImage
                },
                getDogImage: async function(){
                    const response = await axios.get(dogUrl);
                    const dogImage = response.data.message
                    this.image = dogImage
                }
            },
        })
    </script>
</body>
</html>

```


## XI. etc
beforeMount
created
.
.
.


## XII. Vue Form
vue for the select, checkbox, radio, etc.
#### 1. v-on and modifiers

There are many modifieres to modify the triggered events.
like `prevent`, `stop`, and so on.

[vue-modifiers](https://vuejs.org/v2/api/#v-on)

ex)
`v-on:reset.prevent`

#### 2. Input Modifiers
modifieres for `v-model`

1. `.number` automatically converts the value into the number

2. `.trim` removes whitespaces

3. `.lazy` only updated when `change` events are triggered

[more-info](https://vuejs.org/v2/api/#v-model)

ex)

`v-model.number="var1"`

#### 3. Validation using disabled in button
```html
<button type="submit" v-bind:disabled="!formIsValid">Submit</button>
```
```javascript
const app = new Vue({ 
  el: '#app', 
  computed: { 
    formIsValid: function() { ... } 
  }
});
```

## VIII. Manipulating CSS with Vue

#### 1. Inline Style
example
```html
<h2 v-bind:style="{ color: breakingNewsColor, 'font-size': breakingNewsFontSize }">Breaking News</h2>
```
**Remarks** To set hyphenated CSS property like `font-size`. quote is necessary!

```javascript
const app = new Vue({ 
  data: { 
    breakingNewsColor: 'red',
    breakingNewsFontSize: '32px'
  }
});
```

#### 2. Computed Style object
```html
<h2 v-bind:style="breakingNewsStyles">Breaking News</h2>
```

```javascript
const app = new Vue({ 
  data: { 
    breakingNewsStyles: { 
      color: 'red',
      'font-size': '32px'
    }
  }
});
```

#### 3. Multiple Style objects
example
```html
<h2 v-bind:style="[newsHeaderStyles, breakingNewsStyles]">Breaking News</h2>
```

```javascript
const app = new Vue({ 
  data: {
    newsHeaderStyles: { 
      'font-weight': 'bold', 
      color: 'grey'
    },
    breakingNewsStyles: { 
      color: 'red'
    }
  }
});
```

#### 4. Classes
example

```html
<span v-bind:class="{ unread: hasNotifications }">Notifications</span>
```
```css
.unread {
  background-color: blue;
}
```

```javascript
const app = new Vue({
  data: { notifications: [ ... ] },
  computed: {
    hasNotifications: function() {
      return notifications.length > 0;
    }
  }
}
```

v-bind:class takes an object as its value — the keys of this object are class names and the values are Vue app properties that return a truthy or falsy value. If the value is truthy, the class will be added to the element — otherwise it will not be added.

#### 5. Class Arrays

example
```html
<span v-bind:class="[{ unread: hasNotifications }, menuItemClass]">Notifications</span>
```

```javascript
const app = new Vue({
  data: { 
    notifications: [ ... ],
    menuItemClass: 'menu-item'
  },
  computed: {
    hasNotifications: function() {
      return notifications.length > 0;
    }
  }
}
```

```css
.menu-item {
  font-size: 12px;
}

.unread {
  background-color: blue;
}
```

In this example, 'menuItemClass' is applied regardless of condition.