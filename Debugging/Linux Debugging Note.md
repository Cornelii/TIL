# Linux Debugging Note



## Android

### I. Virtual Device error /dev/kvm not found!

1. Go to the Bios (esc) and change the virtualization?! enable.

>sudo apt install qemu-kvm
>
>sudo adduser {user name} kvm
>
>sudo chown {user name} /dev/kvm 

### II. pyenv install ZipImport error
>sudo apt-get install -y make build-essential libssl-dev zlib1g-dev libbz2-dev libreadline-dev libsqlite3-dev wget curl llvm libncurses5-dev xz-utils tk-dev

