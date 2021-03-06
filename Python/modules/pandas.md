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



# Pandas Academy

## I. Create a DataFrame
### By Dict
Dataframe can be initialized with dictionary
each key is corresponding to column, and all the values should have the same length as records that fill each rows.

example
```python
df = pd.DataFrame({
       'col1':[1,2,3]
       'name1':['a','b','c']
})
```
### By list of Lists
```python
df = pd.DataFrame([[row1],[row2],[row3],[row4]],columns=[head1,head2,head3...])

```

### From CSV file (Comma Separated Variables)
```python
# csv -> df
df = pd.read_csv({filename.csv})

# df -> csv
df.to_csv({savingname.csv})
```

### Inspect a Dataframe
`df.head()`
`df.info()`


## II. Select
### Select Columns
df.[{col_name}]

Only if col_name is suit to rule of variable naming.

df.col_name without quot mark is available as well.

### Selecting Multiple Columns
`f[[col1,col2,col3]]`

`[[]]` double list is needed!!

### Select Rows
> df.iloc[{# of row}]
> df.iloc[{# of row},{# of col}]
slicing is also available!

### Select Row with Logic
`df[df.{col_name} with logic]`

**Remarks**: combination of logic. Parenthesis is neccesary
       1. `|`: or
       2. '&': and

`df[df.{col_name}.isin([record_name1,record_name2...)]`

### Setting incides!
When we make subsets from a dataframe, its indicies are conserved. In the other word, non-consecutive indicies make us to use .iloc() difficult

`df.reset_index()` is very useful in this situation.
**Remarks**: When we do .reset_index(), old indices comas as a column called "index". If you don't need it.
`drop = True.  ex) df.reset_index(drop=True)`

**Remarks**: By `inplace=True`, we can modify existing dataframe.

example
```python

sub_df.reset_index(drop=True,inplace=True)

```

## III. Modifying Dataframes

### Adding a column

#### 1. simply define like dict with same length
example
```python
df["new column"]=[5,1,6,2,7,3,8...]

```

#### 2. Adding a column with a single value
example
```python
df["new column"]="a Value"

```

#### 3. Adding a column by manipulation of other columns
example
```python
df["new column"]= df.other1 - df["other2"]
```
The manipulation is performed row by row.

#### 4. Column Operation.
`.apply()`
example
```python

df["new column"] = df.existingColumn.apply(func)

```
The argument function is dealt with as first-class fuction in python. And, it is applied to row by row in given column

#### 5. Applying lambda function to a Column
This is nothing but using `.apply()`
example

```python
lambda_func = lambda x: x*2 if x > 3 else 5

df.newcolumn = df['target'].apply(lambda_func)
```

#### 6. Applying lambda function to a Row
When `.apply()` is applied directly to dataframe.
It hand over entire row by row or entire column by column.

and argument `axis=1` make us apply function within a row.

example
```python
lambda_fn = lambda row : row["col1"] -row["col2"] if row["col3"] < 3 else 1 # row : dataframe_name


df["new column"] = df.apply(lambda_fn, axis=1) # .apply() applied to dataframe
```

### Renaming Columns
1. We can modify columns name by adjusting list of df.columns!

example

```python
df.columns = ["ID","COL1","NEW_NAME1",...]
```

2. Use of `.rename()`

`.rename()` require usually two arguments.
       1. columns  (columns in dict type) 
**Remarks** keyword expression is necessary! column = {}
```python
       {
              "old_column_name1" : "new_name1",
              "old_column_name2" : "new_name2",
              "old_column_name3" : "new_name3",
       }
```
       1. inplace (boolean)
**Tips** `.rename` is preferable to `.columns` for these following reasons.
1. You can only rename column you want.
2. You can specify which column will by changed.


## IV. AGGREGATES IN PANDAS

#### 1. There are column-wise commands
       * mean
       * std
       * median
       * max
       * min
       * count
       * nunique
       * unique

example
``` python
df.columnsName.mean()

```
#### 2. .groupby
groupby enable us to do groupwise aggregate in specific column!

example
```python
df.groupby("col1")["col2"].min()

```
**Remarks** Above code returns pd.Series.
If you want to it as dataframe with index.
just put `.reset_index()` behind code.

example
```python
df.groupby("col1")["col2"].min().reset_index()
```

##### .groupby() with ,apply()
example

```python
df.groupby('col1').col2.min().apply(lambda x: np.percentile(x,25)).reset_index()
```
##### .groupby multiple columns
Just use list including names of  multiple columns.

example
```python

df_multigroup = df.groupby(['col1','col2','col3']).col4.count().reset_index()
```
#### 3. pivoting
Pivoting means reorganization of data table.

**Arguments**
       1. columns = "column name that will be column in pivot"
       2. index = "column name that will be index"
       3. values = "column name to fill values"

```python
df_multigroup = df.groupby(['col1','col2','col3']).col4.count().reset_index()

df_pivot = df_multigroup.pivot(columns="col1", index="col2", values= "col4")
```

## V. Multiple DataFrames

#### 1. Inner Merge
`.merge`
Merge method looks for common column first. Then, merge the dataframe with respect to the column.

example

```python
merged_df = pd.merge(df1,df2)
```

merge has merging order!

example
```python
merged_df 1 =  pd.merge(df1,df2) # merge df1 to df2
merged_df2 = df1.merge(df2) # This is the same as the above one.

other_example = df1.merge(df2).merge(df3)
```

##### Merge on Specific Columns1
changing name by `.rename()`

example
```python
merge_df = df.merge(df2.rename(columns={"id":"foreign_id"}))
```
##### Merge on Specific Columns2
Use of arguments left_on & right_on

If there exist the same name of column except selected columns, pd.merge() automatically divide it like id_x, id_y.
In this case, suffixes arguments is useful

example
```python
merge_df = pd.merge(df1,df2,
    left_on='df_id',
    right_on='id',
    suffixes=['_df1', '_df2']
)

```
**Remarks** Inner merge does not conserve record of missing data.

#### 2. Outer Merges
conserve missing data not deleting the row
Missing record are filled with nan

using argument `how`
`pd.merge(df1,df2,how="outer")`

#### 3. Left and Right Merges
1. Left merge conserves first comming dataframe.
2. Right merge conserves second dataframe.

#### 3. Concatenate Dataframes
pd.concat([df1,df2,df3..])

This method is only available when all the dataframe have same number and names of columns.
