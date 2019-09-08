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



## Eclipse on Linux mint

### I. Unhandled event loop exception error
Use Java-8 rather than java-11

```
sudo apt-get install opednjdk-8-jre

sudo update-alternatives --config java
// select appropriate java version

java --version

// version check

```

then, install eclipse, and enjoy it