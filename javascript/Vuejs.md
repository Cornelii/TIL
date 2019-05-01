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
