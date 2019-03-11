# Seaborn

## Visualizing statistical relationship

```python
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

sns.set(style="white")

```

### Scatter plot

```python
tips=sns.load_dataset('tips') # tips is dataframe

sns.relplot(x="total_bill",y="tip",data=tips)  # data=<dataframe>, x=label1, y= label2
# sns.scatterplot(x="total_bill",y="tip",data=tips)
#for relplot. kind="scatter" is default
```

![image](https://seaborn.pydata.org/_images/relational_4_0.png)

**1. hue semantic => 3rd dimension by color!** (hue)

```python
sns.scatterplot(x="total_bill",y="tip",hue="smoker",data=tips)
```

![1](https://seaborn.pydata.org/_images/relational_6_0.png)

**2. Different Marker style** by (style)

```python
sns.scatterplot(x="total_bill",y="tip",hue="smoker",style="smoker",data=tips)
```

**Tip: Four-variables representation is also available using different feature in style.**

![2](https://seaborn.pydata.org/_images/relational_8_0.png)

**3. hue in numeric values**

```python
sns.relplot(x="total_bill",y='tip',hue="size",data=tips)

# color modification
sns.relplot(x="total_bill",y='tip',hue="size",palette="ch:r=-.5,l=.75",data=tips)
## for palette refer to interface of cubehelix_palette()
```

![3](https://seaborn.pydata.org/_images/relational_14_0.png)

**4. Representation by size **by (size)

```python
sns.relplot(x="total_bill",y='tip',size="size",data=tips)
```

![4](https://seaborn.pydata.org/_images/relational_16_0.png)

**Size range**

```python
sns.relplot(x="total_bill",y='tip',size="size",sizes=(10,300),data=tips)
```

![5](https://seaborn.pydata.org/_images/relational_18_0.png)

### Line Plot to emphasize continuity

```python
df=pd.DataFrame(dict(time=np.arange(500),value=np.random.randn(500).cumsum()))
g=sns.relplot(x="time",y="value",kind="line",data=df)
#g=sns.lineplot(x="time",y="value",data=df)
#g.fig.autofmt_xdate()
#g=sns.lineplot(x="time",y="value",sort=False,data=df) # No sorting before plotting
```

![](https://seaborn.pydata.org/_images/relational_21_0.png)

**Aggregation and representing uncertainty**

```python
fmri=sns.load_dataset("fmri")
fmri.columns
sns.relplot(x="timepoint",y="signal",kind="line",data=fmri)
#when repetitive data exist. there are more thant two y in a x 
# multiple observation at each point.
#95% confidence interval
```

![6](https://seaborn.pydata.org/_images/relational_25_0.png)

**remove confidence interval**

```python
sns.relplot(x="timepoint",y="signal",ci=None,kind="line",data=fmri)
#ci-> confidence interval
```

![](https://seaborn.pydata.org/_images/relational_27_0.png)

**standard deviation instead of confidence interval**

```python
sns.relplot(x="timepoint",y="signal",ci="sd",kind="line",data=fmri)
```

![](https://seaborn.pydata.org/_images/relational_29_0.png)

**Plotting subsets with semantic mappings**

```python
sns.relplot(x="timepoint",y="signal",hue="event",kind="line",data=fmri)
```



![](https://seaborn.pydata.org/_images/relational_33_0.png)

It works in same way as the one of scatter plot!

hue, style.

```python
sns.relplot(x="timepoint",y="signal",style="region",hue="event",
            dashes=False,markers=True,kind="line",data=fmri)
```

![](https://seaborn.pydata.org/_images/relational_37_0.png)

```python
sns.relplot(x="timepoint",y="signal",hue="region",units="subject",
            estimator=None,kind="line",data=fmri.query("event=='stim'"))
```

![](https://seaborn.pydata.org/_images/relational_41_0.png)

```python
dots=sns.load_dataset("dots").query("align=='dots'")
palette=sns.cubehelix_palette(light=.8,n_colors=6)
sns.relplot(x="time",y="firing_rate",hue="coherence",style="choice",
           palette=palette,kind="line",data=dots)
```

![](https://seaborn.pydata.org/_images/relational_45_0.png)

```python
sns.relplot(x="time", y="firing_rate",
           hue="coherence", size="choice",
           palette=palette,
           kind="line", data=dots);
```

![](https://seaborn.pydata.org/_images/relational_51_0.png)

**Showing multiple relationships with facets**

relplot() is based on the **FacetGrid**

```python
sns.relplot(x="total_bill",y="tip",hue="smoker",col="time",data=tips)
```

![](https://seaborn.pydata.org/_images/relational_55_0.png)

**The size of FacetGrid is controlled by height and aspect ratio of each facet**

```python
sns.relplot(x="timepoint",y="signal",hue="subject",col="region",row="event",
           height=3,kind="line",estimator=None,data=fmri)
```

![](https://seaborn.pydata.org/_images/relational_57_0.png)

**Showing at a feature that has many levels by col and col_wrap**

```python
sns.relplot(x="timepoint", y="signal", hue="event", style="event",
            col="subject", col_wrap=5,
            height=3, aspect=.75, linewidth=2.5,
            kind="line", data=fmri.query("region == 'frontal'"))
```

![](https://seaborn.pydata.org/_images/relational_59_0.png)



## Plotting with categorical data

**catplot()**

* Categorical scatter plots:
  * stripplot() (with kind="strip";the default)
  * swarmplot() (with kind="swarm")
* Categorical distribution plots:
  * boxplot() (with kind="box")
  * violinplot() (with kind="violin")
  * boxenplot() (with kind="boxen")
* Categorical estimate plots:
  * pointplot() (with kind="point")
  * barplot() (with kind="bar")
  * countplot() (with kind="count")

```python
import seaborn as sns
import matplotlib.pyplot as plt
sns.set(style="ticks",color_codes=True)
```



### I. Categorical scatter plots

#### 1. stripplot

```python
tips=sns.load_dataset("tips")
sns.catplot(x="day",y="total_bill",data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_4_0.png)

**with jitter parameter**

```python
sns.catplot(x="day",y="total_bill",jitter=False,data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_6_0.png)

#### 2. swarmplot

prevents data from overlapping although it only works well for relatively small datasets

```python
sns.catplot(x="day",y="total_bill",kind="swarm",data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_8_0.png)

##### It is possible to add another dimension by hue, style, size

```python
sns.catplot(x="day", y="total_bill", hue="sex", kind="swarm", data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_10_0.png)

**order parameter**

```python
sns.catplot(x="smoker",y="tip",order=["No","Yes"],data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_14_0.png)

```python
sns.catplot(x="total_bill",y="day",hue="time",kind="swarm",data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_16_0.png)

### II. Categorical Distribution plot

#### 1. boxplot

```python
sns.catplot(x="day",y="total_bill",kind="box",data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_18_0.png)

```python
sns.catplot(x="day",y="total_bill",hue="smoker",kind="box",data=tips)
```

**disable dodging** each level of the semantic variable is moved along the categorical axis

```python
tips["weekend"] = tips["day"].isin(["Sat", "Sun"])
sns.catplot(x="day", y="total_bill", hue="weekend",
            kind="box", dodge=False, data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_22_0.png)

#### 2. Boxen plot

This is more informative and suiter for lager dataset

```python
diamonds = sns.load_dataset("diamonds")
sns.catplot(x="color", y="price", kind="boxen",
            data=diamonds.sort_values("color"))
```

![](https://seaborn.pydata.org/_images/categorical_24_0.png)

#### 3. Violin plot

kind of box plot with kernel density estimator(KDE)

```python
sns.catplot(x="total_bill",y="day",hue="time",kind="violin",data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_26_0.png)

Since violinplot use KDE, there are additional options. (bw=,cut=)

##### split (only possible when parameter has two levels)

```python
sns.catplot(x="day", y="total_bill", hue="sex",
            kind="violin", split=True, data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_30_0.png)



There are several options to draw on the interior of the violins.

```python
sns.catplot(x="day",y="total_bill",hue="sex",kind="violin",inner="stick",split=True
           , palette="pastel",data=tips)
```

![](https://seaborn.pydata.org/_images/categorical_32_0.png)

**violin+swarm**

```python
g = sns.catplot(x="day", y="total_bill", kind="violin", inner=None, data=tips)
sns.swarmplot(x="day", y="total_bill", color="k", size=3, data=tips, ax=g.ax)
```

![](https://seaborn.pydata.org/_images/categorical_34_0.png)

## III. Statistical estimation within categories

#### 1. barplot

```python
titanic=sns.load_dataset("titanic")
sns.catplot(x="sex",y="survived",hue="class",kind="bar",data=titanic)
```

![](https://seaborn.pydata.org/_images/categorical_36_0.png)

#### 2. countplot

```python
sns.catplot(x="deck", kind="count", palette="ch:.25", data=titanic)
```

![](https://seaborn.pydata.org/_images/categorical_38_0.png)



**For the Bar and count plots can call all the options discussed above**

```python
sns.catplot(y="deck", hue="class", kind="count",
            palette="pastel", edgecolor=".6",
            data=titanic)
```



#### 3. pointplot

point estimate and confidence interval

```python
sns.catplot(x="sex", y="survived", hue="class", kind="point", data=titanic)
```

![](https://seaborn.pydata.org/_images/categorical_42_0.png)

```python
sns.catplot(x="class", y="survived", hue="sex",
            palette={"male": "g", "female": "m"},
            markers=["^", "o"], linestyles=["-", "--"],
            kind="point", data=titanic)
```

![](https://seaborn.pydata.org/_images/categorical_44_0.png)





## IV. refer the FacetGrid object!

```python
g = sns.catplot(x="fare", y="survived", row="class",
                kind="box", orient="h", height=1.5, aspect=4,
                data=titanic.query("fare > 0"))
g.set(xscale="log")
```

![](https://seaborn.pydata.org/_images/categorical_54_0.png)

## Visualize distribution of a dataset

```python
import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from scipy import stats

sns.set(color_codes=True)
```



#### 1. distplot (hist,rug,kde in this ) [Count_based]

histogram+ kernel density estimate(KDE)

```python
x = np.random.normal(size=100)
sns.distplot(x,hist=True, rug=True,kde=True)
```

options

* bins => How many columns you will separate it

* hist=True/False

* rug=True/False (small vertical ticks representing each point)
* kde=True/False



#### 2. kdeplot

It offers more options than kde derived from distplot.

* shade
  * sns.kdeplot(x, shade=True)

* bandwidth parameter (bw)
  * sns.kdeplot(x,bw=1.5)

#### 3. Fitting parametric distributions

How close it fit to the given distributive fcn.

```python
x = np.random.gamma(6, size=200)
sns.distplot(x, kde=False, fit=stats.gamma)
```



## Plotting bivariate distribution

```python
mean,cov=[0,1],[(1,.5),(.5,1)]
data=np.random.multivariate_normal(mean,cov,200)
df=pd.DataFrame(data,columns=["x","y"])
```



#### 1. jointplot

```python
sns.jointplot(x="x",y="y",data=df)
```

![](https://seaborn.pydata.org/_images/distributions_28_0.png)

#### 2. hexbinplot

```python
sns.jointplot(x="x",y="y",kind="hex",data=df,color="k")
```

![](https://seaborn.pydata.org/_images/distributions_30_0.png)

#### 3. Kernel density estimation

```PYTHON
sns.jointplot(x="x",y="y",data=df,kind='kde')
```

![](https://seaborn.pydata.org/_images/distributions_32_0.png)

#### 4. kdeplot and rugplot

kdeplot() and rugplot() enable you to draw on specific matplotlib axes

```python
f, ax = plt.subplots(figsize=(6, 6))
sns.kdeplot(df.x, df.y, ax=ax)
sns.rugplot(df.x, color="g", ax=ax)
sns.rugplot(df.y, vertical=True, ax=ax)
```

![](https://seaborn.pydata.org/_images/distributions_34_0.png)

#### 5. Denser density plot

just increase the number of contour level (n_levels)

```python
f, ax = plt.subplots(figsize=(6, 6))
cmap = sns.cubehelix_palette(as_cmap=True, dark=0, light=1, reverse=True)
sns.kdeplot(df.x, df.y, cmap=cmap, n_levels=60, shade=True)
```

![](https://seaborn.pydata.org/_images/distributions_36_0.png)

#### 6. JointGrid

jointplot() uses a JointGrid and returns JointGrid object

```python
g = sns.jointplot(x="x", y="y", data=df, kind="kde", color="m")
g.plot_joint(plt.scatter, c="w", s=30, linewidth=1, marker="+")
g.ax_joint.collections[0].set_alpha(0)
g.set_axis_labels("$X$", "$Y$")
```

![](https://seaborn.pydata.org/_images/distributions_38_0.png)

## Pairwise relationships in a dataset

#### 1. pairplot

```python
iris=sns.load_dataset("iris")
sns.pairplot(iris)
```

![](https://seaborn.pydata.org/_images/distributions_40_0.png)

pairplot() is based on PairGrid Object

```python
g = sns.PairGrid(iris)
g.map_diag(sns.kdeplot)
g.map_offdiag(sns.kdeplot, n_levels=6)
```

![](https://seaborn.pydata.org/_images/distributions_42_0.png)


# Seaborn in acdemy.

## 1. Bar plot by seaborn

seaborn is optimized to use pandas dataframe

example
```python

df = pd.read_csv("data.csv")

sns.barplot(
    data=df,
    x="column_namex_df",
    y="column_namey_df"
)

plt.show()  ## Remarks in use of plt.show() with sns
```

**Arguments**
    1. data (pandas dataframe)
    2. x (column name)
    3. y (column name)
    4. ci (error bar)  ex)  "sd": standard deviation
    5. estimator (any function that works on list) ex) len, np.median, etc.
    6. hue (adding nested categorical variable.)

**Tips**: Setting the sns plot style by
`sns.set_style() ex) "darkgrid"`
`sns.set_palette() ex) "pastel"`

## 2. KDE Plots (Kernel Density Estimator)

`sns.kdeplot()`

**Arguments**
    1.data [pd.Dataframe,list,numpy array..] `
        **take one variable!**
    2.shade [boolean]


## 3. Box Plots
1st and 3rd quartiles, median, and outliers.
`sns.boxplot()`

**Arguments**
This is similar to the one of bar plot
    1. data [pd.Dataframe,pd.Series..]
    2. x [column name]
    3. y [column name]

## 4. Violin Plots
Box plot + KDE plot
white point in the center : median
Thick black bar : interquartile range
Thin black bar : confidence interval
Other shaded area : KDE.
`sns.violinplot()`

**Arguments**
    1. data [pd.Dataframe]
    2. x [column name]
    3. y [column name]


## Seaborn Styling
### 1. Built-in Themes: Background color & Grids
`sns.set_style()`
Five built-in themes:
    1. darkgrid
    2. whitegrid
    3. dark
    4. white
    5. ticks

### 2. Despine
`sns.despine()`
changing boarder.

**Arguments**
    1. left [boolean, False default]
    2. bottom [boolean, False default]
    3. right [boolean, True default]
    4. top [boolean, True default]

### 3. Scaling
`sns.set_context()`
scale, fontsize, rc

#### 3.1 Scaling Plots
    1.  paper
    2.  notebook
    3.  talk
    4.  poster

example
```python
sns.set_context("paper")
```
#### 3.2 Scaling Fonts and Line Widths

example
```python
sns.set_context("poster",font_scale = 1,rc={"grid.linewidth":5})
```

#### rc (run command)
`sns.plotting_context()`
This command print out features of the sns plot!
Modify this in dict. and give this dict as rc.


### 4. Color
You can build up your own palette using RGB, tuples, hex, etc.
```python
palette = sns.color_palette("bright")

sns.palplot(palette) # show palette
```
`sns.set_palette({pallete})`
* six variations of seaborn default color palette
    1. deep
    2. muted
    3. pastel
    4. bright
    5. dark
    6. colorblind

#### Use of Brewer Palettes.
example
```python
custom_palette = sns.color_palette("Paired",7)
sns.palplot(custom_palette)
```
[colorbrewer](http://colorbrewer2.org)

Palettes can be classified on its purpose.
1. qualitative palettes (categorical data)
2. Sequential palettes (for ordered categories)
3. Divering palettes (temperature)


applying palettes in each plot with argument : palette





