# PyAutoGUI
PyWin32 is only for window OS

To control mouse and keybord at varoius OS system.

PyAutoGUI is required.

[PyAutoGUI official Doc](https://pyautogui.readthedocs.io/en/latest/index.html)

`pip install pygetwindow==0.0.1`
`pip install pyautogui`

## I. MOUSE

#### 1. mouse position and monitor size
```python
import pyautogui

print(pyautogui.position()) # return tuple of position of mouse
print(pyautogui.size())  # return tuple of monitor size
```

#### 2. mouse movement and click

```python
import pyautogui

pyautogui.moveTo(200, 200)
pyautogui.click()

# at once
pyautogui.click(200,200)

# button keyword
pyautogui.click(200,200,button="right")

# multiple click
pyautogui.click(200,200,clicks=2,interval=0.5)

# relative moving and double click
pyautogui.moveRel(10,20) #dx,dy
pyautogui.doubleClick()

```

#### 4. mouse drag
```python
import pyautogui

pyautogui.dragTo(300, 300, button='left')
pyautogui.dragTo(400, 400, 2, button='left')
pyautogui.dragRel(30, 0, 2, button='right')
```
drag to x, y, (seconds), button


## II. Keyboard

#### 1. Typing letters
```python
import pyautogui

pyautogui.click(500, 500)
pyautogui.typewrite('Hello world!', interval=0.1)
```
* interval : typing interval between each character

## III. Screen Shot

```python
import pyautogui

im1 = pyautogui.screenshot()
im2 = pyautogui.screenshot('my_screenshot.png')
im3 = pyautogui.screenshot('my_region.png', region=(0, 0, 300, 300))

```
`pyautogui.screenshot({file_name},region=(p1x, p1y, p2x p2y))`


## III. Sort of things


**Tip** Position to mouse by image
1. To find image area

```python
import pyautogui as pag

btn = pag.locateOnScreen('imgname.PNG')
print(btn)

```

2. get position of center of img
`pyautogui.center()`
example
```python
import pyautogui as pag

btn = pag.locateOnScreen('imgName.PNG',confidence = 0.8)
center = pag.center(btn)
print(center)

```
or 
`locateCenterOnScreen()`

## Fail-Safe and others
#### 1. Fail Safe
If emergency comes, program will be exited when moving mouse cursor to (0,0) by safe mode

If you do not want to use this mode, do this as follows
```python
import pyautogui

pyautogui.FAILSAFE = False
```

#### 2. PAUSE
pause
```python
import pyautogui

pyautogui.PAUSE = 2.5 # (sec) default = 0.1sec
# commands
```

