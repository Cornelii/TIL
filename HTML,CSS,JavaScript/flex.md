# FLEX


## example of use of flex

```html or css
<!-- by id -->
#pond{
    display: flex:
    justify-content: start;
    align-items: flex-start;
    flex-direction:row;
    order:1;
    align-self: flex-end;
    flex-wrap:wrap;
    flex-flow:row wrap;
    align-content:flex-start;
}

```
## justify-content 
#### horizontal align
* justify-content: flex-start;
* justify-content: flex-end;
* justify-content: center;
* justify-content: space-between;
* justify-content: space-around;

## align-itmes 
#### vertical align
* align-items: flex-start;
* align-items: flex-end;
* align-items: center;
* align-items: baseline;
* align-items: stretch;

## flex-direction 
#### mirror or up side down, right side left vice versa

* flex-direction: row;
* flex-direction: row-reverse;
* flex-direction: column;
* flex-direction: column-reverse;

## order
basic location 0
+1 or -1
(Is individual numbering possible?! )

## align-self
#### This make individual control possible
all the inputs are the same as the one of align-items
ex) align-self: flex-start;

## flex-wrap
#### align easily according to its original size
* flex-wrap: nowrap;
* flex-wrap: wrap;
* flex-wrap: wrap-reverse;

## flex-flow
#### flex-direction + flex-wrap
* flex-flow: [flex-direction attributes] [flex-wrap attributes]

## align-content 
#### (This is for lines. not a line)

* align-content:flex-start;
* align-content:flex-end;
* align-content:center;
* align-content:space-between;
* align-content:space-around;
* align-content:stretch;


## Froggy game is good for flex practice
![Froggy](./figures/froggy.png)