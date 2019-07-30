# Vim for editing documents in linux terminal

#### 1. file save and quit. 
- `shift` + `zz` at command mode

- :q  quit when no change in the file.

- :q! quit without saving at last row mode

- :w [file name]  save.

- :wq!  save and quit vim



#### 2. writing_mode (i,a,o, I,A,O)

- i, a  => front and rear of cursor, respectively
- o     => from next row.

#### 3. Moving cursor (non-writing mode)
h,j,k,l   => left, down, up, right, respectively.
0 (number) or ^   => to the start on the current row
$   => to the end on the current row.
`-` => to the start on the right previous row
+ or enter  => to the start on the right next row
H    => to the start on the upmost row of screen
M    => to the start on the middle row of screen
L    => to the start on the last row of screen
w    => to the first character of the next word
b    => to the first character of the previous word
e    => to the end character of the next word


#### 4. Moving screen (non-writing mode)
ctrl+u: up half of screen
ctrl+d: down half of screen
ctrl+b: up to a screen size
ctrl+f: down to a screen size
ctrl+y: up to a row
ctrl+e: down to a row

#### 5. Go to specific row
`:`+row number => to the row (last row mode)
G => to the last row of a file
row number + G => to the row
`:$` => to the last row of a file (last row mode)

#### 6. Alter contents
all the command except `r`, automatically shift from command mode to input mode. So, `exc` is needed to get back to command mode.

r => change a character where the cursor is located.
cw, #cw => alter characters from cursor to the very word. or 
number+cw => from cursor to the number of word.

s, #s  => alter character and insert characters from cursor to point when getting `exc`.  `#s` => from cursor to the number of characters! (not words), then insert characters

cc => alter all the characters in the row where the cursor is.
(the row will be deleted)

C => alter from cursor to the end of the row

