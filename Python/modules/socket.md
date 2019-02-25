# socket module

Socket is a interface between internal and external part through network.

It is little different in cases of server and client.


```python
import socket

sock = socket.socket() # default family = socket.AF_INET, type=socket.SOCK_STREAM
# 1 family, the other is type!

# family : addressing system
# socket.AF_INET, or socket.AF_INET6

# type: example => raw, stream, datagram socket, etc.

# socket.SOCK_STREAM, socket.SOCK_DGRAM is frequently used.


## Serverside ######################################

# socket - port binding
sock.bind()
# parameter => a tuple (host_name, port_name)


# Programmer have to know what port they use explicitly!

## 1. port listen
sock.listen()

## 2. Start accessing
sock.accept()
# this method returns a tuple of (socket, address)
# Socket model is initially considered as 1:N transmission model



## Again common side ##################################
# read and send data from socket
sock.recv()
# sock.recv(bufsize)

sock.sendall()
# sock. sendall(data)

# close
## extremely important!
sock.close()


## Clientside ############################################
## 1. connect
sock.connect()
# parameter is the same as one of bind()

# procedure in server: generate - bind - listen - accept - read - send - close
# procedure in client: generate - connect - send - listen -close

```

## I. echo server 1

server
```python
# simple echo server

import socket

def run_server(port=8080):
    host =''
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host,port))
        s.listen(1)
        conn, addr = s.accept()
        msg = conn.recv(1024)

        print(f'{msg.decode()}')

        conn.sendall(msg)
        conn.close()
        s.close()
if __name__ == '__main__':
    run_server()
```


client
```python
import socket

def run():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect(('127.0.0.1',8080))
        line = input(":")

        s.sendall(line.encode())
        resp = s.recv(1024)

        print(f'>{resp.decode()}')
        s.close()
if __name__ == '__main__':
    run()

```

## II. echo server 2

server
```python
# repetitive echo server

import socket

def run_server(port=8080):
    host =''
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host,port))
        s.listen(1)
        conn, addr = s.accept()

        while True:
            data = conn.recv(1024)
            if not data: break
            print(data.decode())
            conn.sendall(data)
        conn.close()

if __name__ == '__main__':
    run_server()
```

client
```python
import socket

def run():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect(('70.12.107.44',8080))
        while True:
        
            line = input(":")

            s.sendall(line.encode()) # after sever get empty data
            if not line: break # break
            resp = s.recv(1024)
            print(f'>{resp.decode()}')


if __name__ == '__main__':
    run()

```

## III. multi-access echo server 
Once a Socket is binded to a port, it can generate more `conn` for multiple access. However, it only needs to be handled in separated threads.

1:N server

```python
from threading import Thread
import socket

def echo(sock):
    while True:
        data = sock.recv(1024)
        if not data:break
        sock.sendall(data)
    sock.close()

def run_server(port=8080):
    host = ''
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host, port))
        while True:
            s.listen(1)
            conn, addr = s.accept()
            t = Thread(target= echo, args=(conn,))
            t.start

if __name__ == '__main__':
    run_server()

```
**Remarks:**This is just naive implementation of server.
at least, required:
    1. thread can not be expanded without limits.
    2. `send()` method return the number of byte! data, which cannot be transmitted, is charge in programmer!
    3. `conn`s by `accept()` should be explicitly closed!. decorating?!