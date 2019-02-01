#matplotlib
refered from coursework of codecademy.


## Line Graph in matplotlib

### 1. Basic line
1. plt.plot()
2. plt.show()

```python
plt.plot(x,y)
plt.show()
```

### 2. Basic line II
matplotlib automatically draw multiple plot like following code.

```python
plt.plot(x,y1)
plt.plot(x,y2)
plt.show()
```

### 3. Line Style
many options regarding style
1. color= "green", "#191919", etc
2. linestyle='--',':','', etc
3. marker= 'o','s','*',etc
4. Check out matplotlib official doc.

```python

plt.plot(x,y1, color='purple',linestyle='--')

plt.plot(x,y2,color='#82edc9',marker='s')
plt.show()

```

### 4. Axis and Labels
#### axis
plt.axis() provides axis controller.

zoom is also available
plt.axis([xlb, xub, ylb, yub])
lb: lower bound
ub: upper bound

example
```python
plt.axis([0, 12, 2900, 3100])
```

#### labels
Write in x,y labels and title by these.
1. plt.xlabel({string})
2. plt.ylabel({string})
3. plt.title({string})

### 5. Subplots
#### I.
Can draw multiple plots in a figure (matplotlib figure object)

plt.subplot(r,c,n)
r: # of row
c: # of cel
n: order of plot in range(0,r*c)

example
```python
plt.subplot(1,2,1)
plt.plot(x,y)

plt.subplot(1,2,2)
plt.plot(y,y2,'o')

plt.show()

```

#### II.
modifying subplots

plt.subplots_adjust()
This controls **margin** of each subplots

**attributes**: (default)
    * left (0.125)
    * right (0.9)
    * bottom (0.1)
    * top (0.9)
    * wspace (0.2)
    * hspace (0.2)

example
```python

plt.subplot(2,1,1)
plt.plot(x,straight_line)

plt.subplot(2,2,3)
plt.plot(x,parabola)

plt.subplot(2,2,4)
plt.plot(x,cubic)
plt.show()

plt.subplots_adjust(wspace=0.35, bottom=0.2)
```
### Legend
plt.legend()

legend method takes a corresponding list to plots

**attributes**
    * loc
0 ~ 10  [best,upper right,upper left, lower left, lower right, right center left, center right, lower center, upper center, center]

* legend also can be assigned when plotting each one by attribute `label` in plt.plot()


### Modify Ticks
First get axis object

ax = plt.subplot(1,1,1)
or x = plt.subplot()

1. ax.set_xticks({xtick_list})
2. ax.set_yticks({ytick_list})

If some special label like string is required
3. ax.set_xticklabels([xtick_list])
4. ax.set_yticklabels([ytick_list])

example
```python

month_names = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec"]

months = range(12)
conversion = [0.05, 0.08, 0.18, 0.28, 0.4, 0.66, 0.74, 0.78, 0.8, 0.81, 0.85, 0.85]

plt.xlabel("Months")
plt.ylabel("Conversion")

plt.plot(months, conversion)
ax = plt.subplot() #### plt.subplot()!!!
ax.set_xticks(months)
ax.set_xticklabels(month_names)
ax.set_yticks([0.10, 0.25, 0.5, 0.75])
ax.set_yticklabels(['10%','25%','50%','75%'])
# Your work here
plt.show()
```

### Figures

**Tips** For the so many plots, `plt.close('all')` can help plot not to stray.

1.`plt.figure()` : to create new figures.

**attributes**
    * figsize(w,h)

To save figure `plt.savefig({name_of_figure})` is available.(png, svg, pdf, etc.)
figure => plot => savefig

example
```python

plt.close('all')

plt.figure(figsize=(5,8)) # inches
plt.plot(x,y)
plt.savefig('name.png')

```

## Different Plot Types

### 1. simple bar chart
plt.bar()
This is good to compare multiple categories of data.

**Arguments**
    * x-values : position
    * y-values : height

Most case, x-values is just like list(range(n))
Like as follows

`plt.bar(list(range(len(heights))),heights)`

#### make correspondane in x-ticks.
by `as=plt.subplot() => .set_xticks, .set_xticklabels`

```python
plt.bar(range(len(x)), y)
ax=plt.subplot()
ax.set_xticks(list(range(len(x))))
ax.set_xticklabels(x)
plt.show()
```

### 2. Side-By-Side Bars
If number of data have the same axis-values, This side-by-side is good to compare them

```python

n = 1  # This is our first dataset (out of 2)
t = 2 # Number of datasets
d = len(drinks) # Number of sets of bars
w = 0.8 # Width of each bar
x1 = [t*elem + w*n for elem
             in range(d)]

n = 2  # This is our first dataset (out of 2)
t = 2 # Number of datasets
d = len(drinks) # Number of sets of bars
w = 0.8 # Width of each bar
x2 = [t*elem + w*n for elem
             in range(d)]

plt.bar(x1,y1)
plt.bar(x2,y2)
plt.show()
```

### 3. Stacked Bar
This is used to calify the total number in data sets with respest to same axis.

argument: `bottom` in plt.bar()

example
```python
ax = plt.subplot()
x_value = list(range(len(x_name))) 
plt.bar(x_value, y1)
plt.bar(x_value, y2, bottom=y1)
ax.set_xticks(x_value)
ax.set_xticklabels(x_name)
plt.legend(["Legend1","Legend2"])
plt.show()

```

### 4. Error Bars
To show uncertainty.
There are many kinds of error.

``` python
ax = plt.subplot()
x_value=list(range(len(x_names)))
error = [~~~~~~~~~]
plt.bar(x_value,y1, yerr=error,capsize=10)
ax.set_xticks(x_value)
ax.set_xticklabels(x_names)
plt.show()
```

### 5. Fill Between
