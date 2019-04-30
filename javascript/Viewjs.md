# Viewjs

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
{{username}}
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


```
`v-bind` takes a value from the Vue app’s data object and uses it as the value of the specified component prop.