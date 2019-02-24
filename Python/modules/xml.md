# xml

## I. xml.etree.ElementTree
XML API

each tags are refered as Element in this API

#### 1. Example
```python
import xml.etree.ElementTree as ET

tree = ET.parse('filename.xml')

root = tree.getroot()

root.tag
root.attrib
root[0][1].text

for neighbor in root.iter():
    print(neighbor.tag, neighbor.attrib, neighbor.text)

```

#### 2. Finding elements
`.iter()`, `.findall()`, `.find()`, and `.get()`

* `.iter()`: recursive iterator for some tag.
* `.findall()`: return element containing its children
* `.find()`: finds first child with a particular tag
* `.get()`: to get specific attributes in any element


#### 3. Modifying an XML file

`.set()`, `.text`, `.append()`, `.remove()`, and `.write(filename.xml)`

* `.set()`: 
* `.text`: directly changing its fields
* `.append()`: adding new children(element)
* `.remove()`: removing children
* `.write()`: writing xml file

#### 4. Building XML documents
`ET.Element()`, `ET.SubElement()`, `ET.ElementTree`

```python
import xml.etree.ElementTree as ET

b= ET.Element('lemon')
b_color = ET.SubElement(b, 'color')
b_flavor = ET.SubElement(b,'flavor')
b_source = ET.SubElement(b, 'source')
b_source_1 = ET.SubElement(b_source,'Cooking')

b_color.text = 'yellow'
b_color.set('class','color')
b_color.set('name','yes')

b_flavor.text = "Sour"
b_flavor.set('name','flavor')

ET.dump(b)

tree = ET.ElementTree(b)
tree.write('filename.xml')
```


#### 4.

[python-xml official DOC](https://docs.python.org/2/library/xml.etree.elementtree.html#modifying-an-xml-file)










## II. xml.dom