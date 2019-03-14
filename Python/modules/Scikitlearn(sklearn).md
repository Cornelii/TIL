# Scikitlearn (sklearn)

## I. Preprocessing




## II. Classification Model



## III. Regression Model




## IV. ETC

### 1. Cross Validation
`cross_val_score`


### 19. Pipe line


### 20. Grid Search
Grid Search is a procedure to find optimized hyperparameter of model

```python
from sklearn import linear_model
from sklearn.preprocessing import PolynomialFeatures
from sklearn.pipeline import Pipeline
from sklearn.decomposition import PCA
from sklearn.model_selection import KFold, GridSearchCV

ridge = linear_model.Ridge()

model = Pipeline([('poly', PolynomialFeatures(degree=2)), ('pca', PCA()), ('linear', ridge)])

model.get_params() # you can check parameter names of model

params = {'linear__alpha':[0.1, 1, 10],'pca__n_components':[5,10,15]}
grid = GridSearchCV(model, params, cv=kfold, scoring = 'r2')

grid.fit(X,y)
print(grid.best_score_, grid_best_params)
```

[scoring](https://scikit-learn.org/stable/modules/model_evaluation.html#scoring-parameter)