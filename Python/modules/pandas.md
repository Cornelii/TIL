# Pandas

Easy-to-use data structures and data analysis tools for python

- Primarily, Series and DataFrame. (Panel etc.)
- axis indexing, grouping, data range generation
- File IO and Sparse

| Dimensions | Name      | Description                           |
| ---------- | --------- | ------------------------------------- |
| 1D         | Series    | 1D labeled array                      |
| 2D         | DataFrame | General 2D labeled tabular structure. |



## Object Creation

```python
import pandas as pd

## make series
s=pd.Series([1,3,5,np.nan,6,8])

## make dataframe1
dates=pd.date_range('20190102',period=6)
df=pd.DataFrame(np.random.randn(6,4),index=dates,columns=list('ABCD'))
# index -> same number of row as the one of table.
# columns -> same number of column as the one of table.

df.dtypes #different data type per each columns

```

## View Data

```python
df.head()
#df.head(n)
df.tail()
#df.tail(n)

df.index # row labels
df.columns # column labels

df.values # table entries

df.describe() # quick statistic summary per each column

df.T # Transpose

df.sort_index(axis=1,ascending=False)
# sort by an axis
df.sort_values(by="B")
# sort by values in a column
```

## Data Selection

```python
df['A'] # getting column by column labels
df[['A','B']]

df[0:3] # slice by rows
```

### Selection by label

```python
df.loc[:,['A','B']]
```

### Selection by Position

```python
df.iloc[3] # by row index

df.iloc[2:4,0:5] # row,column

df.iloc[[0,1,5],[1,6]] ## specific rows and columns

df.iloc[m,n] ## m,n entry
df.iat[m,n] ## the same as df.iloc[m,n]
```

### Boolean Indexing

```python
df[df.A>0]
df[df>0]

df2=df.copy() # dataframe copy

# filtering by isin()

df2[df2['E'].isin(['two','four'])]
# <column in dataframe>.isin(<[values]>)
```

### Setting a new column

```python
df.at[dates[0],'A']=0 ## assign 0

df.iat[0,1] ## assign 0

df.loc[:,'D']=np.array([5]*len(df)) ## len(df) => number of row of dataframe

df2[df2>0]=-df2 ### this is quite interesting operation. 
# boolean-selected the dataframe = f(the dataframe) => only f() applied in the
# location in which the boolean-selected condition holds
```

### Missing Data

pandas primarily uses the value np.nan to represent missing data.

```python
# pandas adding column with missing data "NaN"
df1=df.reindex(index=dates[0:4],columns=list(df.columns)+['E'])

# To drop any rows that have missing data.
df1.dropna(how='any')

# Filling missing data with value
df1.fillna(value=5)

# get boolean
pd.isna(df1)
```

### Sort of Operations

```python
df.mean() #average per column
df.mean(1) # average per rows df.mean(order of axis)

# applying functions to the data
df.apply(lambda x:x.max()-x.min()) # x=> each column!!

#Histogramming and Counting
s=pd.Series(np.random.randint(0,7,size=10))
s.value_counts() # index: value, entry: counts

```

#### String method

in the attribute of str

ex)  s.str.lower() 



#### Merge

##### I. Concatenation

```python
df=pd.DataFrame(np.random.randn(10,4))
pieces=[df[:3],df[3:7],df[7:]] ## list including dataframes
 ## each dataframes sliced by rows
df1=pd.concat(pieces)
```

##### II. Join

```python
left=pd.DataFrame({'key':['foo','foo'],'lval':[1,2]})
right=pd.DataFrame({'key':['foo','foo'],'lval':[4,5]})
pd.merge(left,right,on='key') ## 
# 4columns each two 2 entires corresponding foo 2x2=4

left=pd.DataFrame({'key':['foo','bar'],'lval':[1,2]})
right=pd.DataFrame({'key':['foo','bar'],'lval':[4,5]})
pd.merge(left,right,on='key') ## 
# 2columns each two 1 entires corresponding each key 1x1 + 1x1 =2
#                                                    (foo) (bar)

```

##### III. Append

```python
df=pd.DataFrame(np.random.randn(8,4),columns=['A','B','C','D']) ## 8 columns
append_row=df.iloc[3]
df.append(append_row,ignore_index=True)
## 9 columns
```

### Grouping

"groupby" for splitting, applying or combining.

```python
df = pd.DataFrame({'A' : ['foo', 'bar', 'foo', 'bar',
                           'foo', 'bar', 'foo', 'foo'],
                   'B' : ['one', 'one', 'two', 'three',
                          'two', 'two', 'one', 'three'],
                   'C' : np.random.randn(8),
                   'D' : np.random.randn(8)})

df.groupby('A').sum() ### making group with different components in A then, sum()

df.groupby(['A','B']).sum() ### making group with different components in A and B
################# m different components in A, n different components in B
# m x n new dataframe with summed entries.
```

### Reshaping

##### Hierarchical Indexing and Stack

```python
hindex=list(zip(['h1','h1','h2','h2'],['p','div','p','div']))
index=pd.MultiIndex.from_tuples(hindex,names=['first','second'])
df=pd.DataFrame(np.random.randn(4,2),index=index,columns=["A",'B'])
                
stacked=df.stack() # this is about index, label-> index
stacked.unstack() # basic index and label
stacked.unstack(1) # other index and label (1st index in multiindex goes index)
stacked.unstack(2) # other index and label (2nd one goes index)

```



### Pivot Table

```python
df = pd.DataFrame({'A' : ['one', 'one', 'two', 'three'] * 3,
                   'B' : ['A', 'B', 'C'] * 4,
                   'C' : ['foo', 'foo', 'foo', 'bar', 'bar', 'bar'] * 2,
                   'D' : np.random.randn(12),
                   'E' : np.random.randn(12)})
pd.pivot_table(df,values="D",index=["A","B"],columns=['C'])
```



**Tip** <dataframe>.astype()

### Plotting

```python
plt.figure();df.plot();plt.legend(loc='best')
```

### File IO

##### CSV

```python
df.to_csv('foo.csv')
pd.read_csv('foo.csv')
```

##### HDF5

```python
df.to_hdf('foo.h5','df')
pd.read_hdf('foo.h5','df')
```

##### Excel

```python
df.to_excel('foo.xlsx',sheet_name="Sheet1")
pd.read_excel('foo.xlsx','Sheet1',index_col=None,na_values=['NA'])
```

##### Json

```python
df.to_json("foo.json")
df2=pd.read_json("foo.json")
```





# sorts of things

## 1. Reading data from a csv file

```python
df=pd.read_csv('../data/test.csv')
df.head(5)
# more options
df=pd.read_csv('../data/test.csv',sep=',',encoding='utf-8',index_col='Date')

df.info() # dataframe information

df2=pd.DataFrame(data=df,columns=['a','b'])

for x in df['a'].unique(): ## unique returns unique entries
    print(x)
```

## 2. Select data

```python
df3=df[df['a']=="Yeah"]
#<dataframe>[boolean] => True_dataframe
df3['a'].value_counts()

df.loc[df.index[5:6],'b']
```

## 4. Separated reading like pagination when handling big data



## . Official Documents

[Pandas](http://pandas.pydata.org/pandas-docs/stable/tutorials.html)













