# Set - ups

## I. Pyenv

linux pre-setup

```console
sudo apt-get update && sudo apt-get upgrade

sudo apt-get install -y make build-essential libssl-dev zlib1g-dev libbz2-dev libreadline-dev libsqlite3-dev wget curl llvm libncurses5-dev git

sudo apt-get python3-pip
```

sqlite3

```console
[sqlite3]

sudo apt-get update
sudo apt-get install sqlite3 libsqlite3-dev
```



pyenv

```console


git clone https://github.com/pyenv/pyenv.git ~/.pyenv
echo 'export PYENV_ROOT="$HOME/.pyenv"' >> ~/.bashrc
echo 'export PATH="$PYENV_ROOT/bin:$PATH"' >> ~/.bashrc
echo -e 'if command -v pyenv 1>/dev/null 2>&1; then\n  eval "$(pyenv init -)"\nfi' >> ~/.bashrc

exec "$SHELL"


git clone https://github.com/pyenv/pyenv-virtualenv.git $(pyenv root)/plugins/pyenv-virtualenv
echo 'eval "$(pyenv virtualenv-init -)"' >> ~/.bashrc
exec "$SHELL"

pyenv install 3.6.8
pyenv global 3.6.8

mkdir {my_directory}
cd {my_directory}

pyenv virtualenv 3.6.8 {project-venv}
pyenv local {project-venv}
pip list

```



## Django on pyenv

pip install django==2.1.8

pip install django_extensions django_bootstrap4 django_imagekit pillow

pip install djangorestframework django-rest-swagger

pip install "ipthon[notebook]"



