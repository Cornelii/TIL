# Django_AWS lightSail


## I. gunicorn, nginx

#### 1. generate Lightsail Server 
Only OS / Ubuntu

#### 2. Installing Packages
```
sudo apt update
sudo apt-get update
sudo apt install nginx python3-pip
```

**For pyenv**

```
git clone https://github.com/pyenv/pyenv.git ~/.pyenv
echo 'export PYENV_ROOT="$HOME/.pyenv"' >> ~/.bashrc
echo 'export PATH="$PYENV_ROOT/bin:$PATH"' >> ~/.bashrc
echo -e 'if command -v pyenv 1>/dev/null 2>&1; then\n  eval "$(pyenv init -)"\nfi' >> ~/.bashrc
exec "$SHELL"

sudo apt install zlib-dev bzip2 bzip2-dev readline-dev sqlite3 sqlite3-dev libssl-dev xz-utils

git clone https://github.com/pyenv/pyenv-virtualenv.git $(pyenv root)/plugins/pyenv-virtualenv
echo 'eval "$(pyenv virtualenv-init -)"' >> ~/.bashrc
exec "$SHELL"

pyenv install 3.6.8
pyenv global 3.6.8

mkdir {project_directory}
cd {project_directory}

pyenv virtualenv 3.6.8 {project-venv}

pyenv activate {project-venv}

git init
git remote add oprigin {git-remote repo}
git pull origin master

pip install -r requirements.txt
# pip install gunicorn

mkdir {run}
```

After making custom PORT,
django debugging server check
```
python manage.py runserver 0.0.0.0:{YOUR PORT}
```

#### 3. gunicorn setting
```
gunicorn --bind 0.0.0.0:{YOUR PORT} {project-name}.wsgi:application
```
check whether it works.

```
pyenv deactivate
```

```
sudo nano /etc/systemd/system/gunicorn.service
```
Copy & Paste

```
[Unit]
Description=gunicorn daemon
After=network.target

[Service]
User=ubuntu
Group=www-data
WorkingDirectory=/home/ubuntu/{project-directory}
ExecStart=/home/ubuntu/.pyenv/versions/3.6.8/envs/venv/bin/gunicorn --access-logfile - --workers 3 --bind unix:/home/ubuntu/{project-directory}/{run}/{project-name}.sock {project-name}.wsgi:application

[Install]
WantedBy=multi-user.target

```

```
sudo nano /etc/systemd/system/gunicorn.socket
```

Copy & Paste
```
[Unit]
Description=gunicorn socket

[Socket]
ListenStream=/run/gunicorn.sock

[Install]
WantedBy=sockets.target
```

#### 4. Testing Gunicorn
```
sudo systemctl start gunicorn.socket
sudo systemctl enable gunicorn.socket
```

```
sudo systemctl daemon-reload
sudo systemctl restart gunicorn
```

```
sudo systemctl status gunicorn.socket
sudo systemctl status gunicorn
```
Check both are active without errors


#### 5. Setting Up Nginx

```
sudo nano /etc/nginx/sites-available/{project-directory}
```

Copy & Paste

```
server {
    listen 80;
    server_name {YOUR PORT};

    location = /favicon.ico { access_log off; log_not_found off; }
    location /static/ {
        root /home/ubuntu/{project-directory}/staticfiles;
    }

    location / {
        include proxy_params;
        proxy_pass http://unix:/run/gunicorn.sock;
    }
}
```

```
sudo ln -s /etc/nginx/sites-available/{project-directory} /etc/nginx/sites-enabled

sudo nginx -t
```

```
sudo systemctl daemon-reload
sudo service nginx restart
```

Finished.

Work flow
User Browser -> nginx -> gunicorn(with systemd) -> Django 