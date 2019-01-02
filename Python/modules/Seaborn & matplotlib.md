# Seaborn & matplotlib

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













