# How to jekyll


## I. Start Jekyll
```
gem install jekyll bundler

jekyll new myblog

cd myblog

bundle exec jekyll serve
# ruby v2.4 > required, gem -v, gcc -v, make -v
```

```
gem install jekyll bundler

bundle init ## Create a new Gemfile

gem "jekyll"  ## Add jekyll as a dependency
```

```
jekyll build # BUilds the site and outputs a static site to a directory _site

jekyll serve # local Server
```

#### i. Several Command Line Usages
```
jekyll new PATH # Create a new Jekyll site with default gem-base theme

jekyll new PATH --blank # Create a new blank Jekyll site

jekyll build ## or jekyll b (Performs a one off build your site to ./site default)

jekyll serve ## or jekyll s Builds your site any time a source file changes and serves it locally

jekyll doctor ## outputs any deprecation and configuration issues

jekyll clean ## Removes all generated files: Destination folder, metadata file, Sass and Jekyll caches

jekyll help ## Show help, optionally for a given subcommand (ex: jekyll help build)
```

#### ii. Configuration
`_config.yml`
TODO: https://jekyllrb.com/docs/configuration/


## II. Components

#### i. at the Front Matter
Any file that contains a YAML front matter block will be processed by Jekyll (triple-dashed lines)


- user post_url tag to link to other posts (regardless of URLs Breaking)

**Between the triple-dashed lines, You can even define your own variables**

- Predefined Global Variables
  - layout   : layout must be placed in `_layouts`
  - permalink: it will be used as the final URL
  - published: set to false if you don't want a specific post to show up when site is generated

- Custom Variables
example
```
---
game: soccer
---

<h1>{{page.game}}</h1>
```

- Predefined Variables for Posts
  - date (YYYY-MM-DD HH:MM:SS +/-TTTT)
  - categories, category, tags


#### ii. Including Images
```
![images name](/assets/screenshot.jpg)
```
#### iii. Displaying an index of posts
```
{% for post in site.posts %}

{{post.url}} {{post.title}}

{% endfor %}
```

#### iv. Categories and Tags
Categories cna be part of the URL for a post whereas a tag cannot

example
```
---
layout: post
title: A Trip
categories: [blog, travel]
tags: [hot, summer]

```

Categories and Tags can be available by `site.categories or site.tags`
example

```
{% for category in site.categories %}
    {{category[0]}}
    {% for post in category[1]%}
        {{post.url}} {{post.title}}
    {% endfor %}
{% endfor %}
```

**A snippet of a post's content can be accessed by `excerpt`**

#### v. Drafts
Drafts are draft for a post that you are working on, but don't want to publish.

_draft/
      somefiles.md

#### vi. Collections
example
```
## at _config.yml
collections:
    {wanted_name}:
        output: true

collections_dir: {wanted_directory name}

## Your pages must be placed in {wanted_name}/_{wanted_directory name} 
```

usage example
```
{% for thing in site.{wanted_name}%}
    {{thing.name}}
    {{thing.content}}
    {{thing.url}}
    {{thing.position}}
{% endfor %}
```

#### vii. Sort in Collections
```
collections:
    my_collect1:
        sort_by: {variable}

# other example
collections:
    my_collect2:
        order:
            - chapter1.md
            - chapter2.md
            - chapter4.md
```

#### viii. Collections itself can be given as Liquid Attributes

label, docs, files, relative_directory, directory, output

#### ix. Attributes of Documents
content, output, path, relative_path, url (in case that output:true), collection, date

## III. Data Files
Jekyll supports loading data from YAML, JSON, CSV, and TSV files loacated in the `_data` directory.

Example
_data/people.yml
```
- name: Jhon
    hobby: guitar

- name: James
    hobby: soccer

- name: Niki
    hobby: piano

```

_data/people.csv
```
name,hobby
Jhon,guitar
James,soccer
Niki,piano
```

```
{% for person in site.data.people %}

    {{person.name}}
    {{person.hobby}}
{% endfor %}
```

#### i. Subdirectory
example)
_data/club/people.yml
```
username: name1
name: name2
members:
    - name: Jhon
        hobby: guitar

```

```
{% for person_hash in site.data.club %}
    {% assign person = person_hash[1] %}
    {{person.name}}
    {{person.hobby}}
{% endfor %}
```



```
---
title: some post
author: Lukas
---

{% assign author = site.data.people[page.author] %}
 
{{author.name}}
{{author.hobby}}
```


## IV. Assets

Jekyll provides built-in support for `Sass` and can work with `Coffe Script` via a Ruby gem.
TO use them, you need one of `.sass, .scss, or .coffee`

!! `Start the file with two lines of triple dashes`
```
---
---

// something
```

If file path is `css/styles.scss`, Jekyll will process it and put it into `css/styles.css`

!! If you are using Mustache or another JavaScript templating, You have to use
`{% raw %},  {% endrow %}`



## V. Static Files
A static file is a file that does not contain any front matter. These include images, PDFs, and other un-redered content.

They can be refered by `site.static_files`

file.path, file.modified_time, file.name, file.basename, file.extname


one of example to set up its path
_config.yml
```
defaults: 
    - scope:
        path: "assets/img"
      values:
        image: true
```

image file loop with above definition
```
{% assign image_files = site.static_files | where: "image", true%}
{% for myimage in image_files %}
    {{ myimage.path }}
{% endfor %}

```

## VI. Directory Structure

Jekyll uses gem-based themes

|file, directory| description|
|---|---|
|_config.yml|Configuration data|
|_drafts|directory for unpublished posts|
|_includes| partials, {% include file.ext %}, _includes/file.ext|
|_layouts|templates, {{ content }}, also can be chosen on a front matter|
|_posts|YYYY-MM-DD-title.md, Dynamic post content, permalinks can be specified for each posts|
|_data|.yml, .json, .scv. tsv,. yaml,  ex) site.data.members for members.yml|
|_sass|main.scss into main.css|
|_site|This is where the generated site will be placed. (.gitignore is recommended)|
|.jekyll-metadata|This helps jekyll keep track of which files are modified|
|index.html, index.md, *.html, *.md|These files can have front matter|
|||

## VII. Variables

#### i. Global Variables
 site, layout, page, content, paginator

#### ii. Site Variables
site.time, site.pages....
posts, related_posts, static_files
html_pages, html_files, collections, data
documents, categories.CATEGORY, tags.TAG
url, ...

#### iii. Page Variables
page.content, page.title...
excerpt, url, data, id, categories, collection,
tags, dir, name, path, next, previous

#### iv. Paginator
paginator.page, paginator.per_page...
posts, total_posts, previous_page, previous_page_path,
next_page, next_page_path

[Details](https://jekyllrb.com/docs/variables/)


## VIII. Liquid
You generally use output content by two-curly braces `{{}}`.
To performing logic statements with curly brace percentage sign `{% %}`.

[Official Liquid Document](https://shopify.github.io/liquid/)

#### i. Liquid Filters Jekyll provides



#### ii. Liquid Tags Jekyll provides


## IX. Includes

## X. Layouts

## XI. Permalinks

## XII. Themes

## XIII. Pagination

## XIX. Others



#### i. install


#### ii. local server page
```
# at the page directory.
bundle  exec jekyll serve
```

