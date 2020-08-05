# TIMEO WEB GUI Installation

## Getting Started

### Init submodules

TIMEO WEB GUI uses gentelella's web template, which is included as a git submodule. To init the submodule with the contents run

```
$ git submodule update --init --recursive
```

### Create the folder structure

Copy the contents of TIMEO_WEB_GUI (folders: timeo_web_gui and gentelella) into the folder which will be used by the web server (we refer to this folder as <web_gui_folder>).

### Install

Apache 2 configuration for running the WEB GUI (Ubuntu)

```
$ sudo apt-get update
$ sudo apt-get install apache2

$ cd /etc/apache2/
```

Edit apache2.conf adding the following lines:

```
<Directory <web_gui_folder>>
        Options Indexes FollowSymLinks Includes
        AllowOverride None
        Require all granted
</Directory>
```

- NOTE: the path must point at the directory that includes "timeo_web_gui" and also the WEB GUI template "gentelella"

```
$ cd /etc/apache2/sites-enabled/
```

Edit 000-default.conf:

```
DocumentRoot <web_gui_folder>
```

```
$ cd /etc/apache2/conf-available/
```

Create ssi.conf with the following lines:

```
AddType text/html .html
AddOutputFilter INCLUDES .html
```

```
$ cd /etc/apache2/conf-enabled/
```

Create link to ../conf-available/ssi.conf

```
$ sudo ln -sv ../conf-available/ssi.conf ssi.conf

$ cd /etc/apache2/mods-enabled/
```

Create link to ../mods-available/include.load

```
$ sudo ln -sv ../mods-available/include.load include.load

$ sudo service apache2 restart
$ sudo service apache2 status
```

## WEB GUI at http://localhost/timeo_web_gui/
