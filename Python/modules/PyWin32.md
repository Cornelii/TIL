# PyWin32
Python extension to use Win32 API

`pip install pywin32`

## I. MOUSE

#### 1. get mouse cursor position
`win32api` , `GetCursorPos()`

```python
import win32api

print(win32api.GetCursorPos())
```

#### 2. let Mouse Click!
`win32con` , `mouse_event`

`mouse_event`'s arguments
`mouse_event(type,x,y,0,0)`

    * type:
    win32con.MOUSEEVENTF_LEFTDOWN (keep pressing)
    // win32con.MOUSEEVENTF_LEFTUP (unpress)
    * x: x-coordinate of mouse
    * y: y-coordinate of mouse

(mouse-event functions)[https://docs.microsoft.com/en-us/windows/desktop/api/winuser/nf-winuser-mouse_event]

example
```python
import win32api, win32con


def mouse_click(x, y):
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, x, y, 0, 0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, x, y, 0, 0)

mouse_click(200, 200)
```
    
#### 3. MOUSE DRAG

* click => move => unclick.
`MOUSEEVENTF_MOVE`
example
```python

import win32api, win32con

def mouse_drag(x, y, dx, dy):
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, x, y, 0, 0)
    win32api.mouse_event(win32con.MOUSEEVENTF_MOVE, dx, dy, 0, 0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, x+dx, y+dy, 0, 0)

mouse_drag(200, 200, 50, 20)
```

## II. Screen

#### 1. get pixel
`win32gui`
`.GetPixel()`

example
```python
import win32api
import win32gui

color = win32gui.GetPixel(win32gui.GetDC(win32gui.GetActiveWindow()), 500, 500)
print(hex(color)) # pixel info at (500,500)
```

To get rgb as tuple
```python
import win32api
import win32gui


def rgbint2rgbtuple(RGBint):

    blue = RGBint & 255
    green = (RGBint >> 8) & 255
    red = (RGBint >> 16) & 255

    return (red, green, blue)

color = win32gui.GetPixel(win32gui.GetDC(win32gui.GetActiveWindow()), 500, 500)
print(rgbint2rgbtuple(color))
```

