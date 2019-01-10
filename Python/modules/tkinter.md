# Tkinter

## tkinter (python) python GUI

```python
from tkinter import *
import webbrowser as wb
import requests as rq
from bs4 import BeautifulSoup as BS

### making GUI
# GUI is all the things except thing in CLI

### tick-> constant rendering within infinite loop
def open_bitbucket():
    url="https://bitbucket.org/ssafy-seoul/python_basic"
    wb.open(url)

## kaggle repos list
def scrap_info():
    url="https://github.com/Cornelii?tab=repositories"
    res=rq.get(url)
    doc=BS(res.text,"html.parser")
    wanted=doc.select(".d-inline-block.mb-1")

    for repo in wanted:
        print(repo.text)

    label1.config(text="button pushed")## change setting of label1

    print("This is scraped information")


root=Tk()

#Label("Which program it belongs",text="text")
label1=Label(root,text="Tkinter")
button1=Button(root,text="Open bitbucket",command=open_bitbucket)# command= func_name

button2=Button(root,text="scrap info",command=scrap_info)

### Geometry manager!

label1.pack() # default position
button1.pack()
button2.pack()



root.mainloop()

""" all the format is very similar
from flaks import Flask

app=Flask(__name__)

**** hided ***
app.run()
"""
```

**py2exe** : to make program into .exe file







**Tip**electron (window application) is good to make GUI app



