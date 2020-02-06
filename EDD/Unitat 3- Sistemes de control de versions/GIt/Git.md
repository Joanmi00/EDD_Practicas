# -Instal·lació de Git

### 1- Primer instalarem el **git**:

```sh
1 sudo apt update
2 sudo apt isntall git
```
-Si volem daber la versio que tenim installada ficarem este comando -->**git --version**

### 2- Parametres que cal configurar en git:

 - **Identitat de l'usurai**

```ssh
1 $ git config --global usr.name "Rubén"
2 $ git config --global user.email rubenmodul@gmail.com
```

 - **EDitor per defecte**
  
```ssh
1 $ git config --global core.editor 
```

 - **Eixida de colors**

```ssh
1 $ git config --global colorr.ui true
```

 - **Entorns Híbrids**

```ssh
1 $ git config --global core.autocrlf true
```

 - **Consultar paràmetres**

```ssh
1 $ git config --list
``` 

### 3- Creació i inicialització 

 - Ens situem en el directoori on guardarem els projectes i creem una carpeta:

```ssh
1 $ mkdir projecte
```

- Entrem dins amb un **cd projecte**

 - Initzialitzem asi el repositori
```ssh
1 $ git status
```
I ens respondra amb aquest missatge:
```ssh
1 On branch master 
2
3 No commits yet 
4
5 nothing to commit(create/copy files and use "git add" to track)
```
Y si fem un ls -la en ixira una carpeta oculta **.git**

### 4- Creació de un fitxer nou

 - Crearem un fitxer:

```ssh
1 $ touch ruben_1.md
```
 - Amb el següent comando ens mostrara el stat del git:

```ssh
1 $ git status
2 On branch master
3 
4 No commits yet
5
6 Untracked files:
7   (use "git add <file>..." to include in what will be committed)
8
9   ruben_1.md
10
11 nothing added to commit but untracked files present (use "git add" to track)
```

### 5- Fer seguiment del fitxer

```ssh 
1 $ git add ruben_1.md
```
 Y tornem a consultar el estat:
```ssh
1 $ git status
2 On branch master
3 
4 No commits yet
5
6 Changes to be committed:
7   (use "git rm --cached <file>..." to unstage)
8
9   new fie:    ruben.md
```

### 6- Fent el commit del fitxer 

 - Per añadir el fitxer al repostiri, fem el nostre primer commit

```ssh
1  git commit -a -a "Primer Commit"
2 [master (root-commit) 46c5f91] primer commit
3  1 file changed, 0 insertions(+), 0 deletions(-)
4  create mode 100644 ruben_1.md
```
  - Ara per comprobar farem un status:

```ssh 
1 $ git status
2 On branch master
3 nothing to commit, working tee clean 
```
 - També podem veure un registre:

```ssh 
1 $ git log
```

 - Més simplificada:

```ssh 
1 $ git log --online
```

### 7- Esborrar fitxers

 - Anem a crear dos fitxers en el repositori, per a més tart esborrar-los:

```ssh
1 $ touch esb1.md
2 $ tocuh esb2.md
```

Veiem l'èstat:
```ssh
1 $ git status 
2 On branch master
3 Untracked files:
4   (use "git add <file>..." to include in what will be committed)
5
6   esb1.md
7   esb2.md
```

 - Ens indica que no s'està seguint els fitxers, eks tindrem que afegir:

```ssh
1 $ git add .
```
 - I comprovarem que s'haga afegit:

```ssh
1 $ git status 
2 On branch master
3 Changes to be committed:
4   (use "git reset HEAD <file>..." to unstage)
5
6   new file:   esb1.md
7   new file:   esb2.md
```

 - Fem un commit:

```ssh
1 $ git commit -a -m "Dos fitxers esb"
2 [master fb3bcef] Dos fitxers esb
3  2 files changed, 0 insertions(+), 0 deletions(-)
4  create mode 100644 esb1.md
5  create mode 100644 esb2.md
```

### 9- Esborrar en fixer i en git

 - En local 

```ssh 
1 $ rm esb1.md
```
 - I status:

```ssh
1 $ git status
2 On branch master 
3 Changes not staged for commit: 
4 (use "git addrm <file>..." to update what will be committed)
5 (use "git checkout --<file>..."   to discard changes in working directory)
6 
7   deleted:    esb1.md 
8
9 no changes added to commit(use "git add" and/or "git commit-a")
```
 - Ara indicarem els canvis:

```ssh 
1 $ git rm esb1.md 
```
 - I fem un status:

```ssh
1 $ git status 
2 On branch master
3 Changes to be committed:
4   (use "git reset HEAD <file>..." to unstage)
5
6   deleted:   esb1.md
```

 - I ara si que podem fer el commit:

```ssh
1 $ fit commit -a -m "ESborrar esb1.md"
2 [master 5e3b2e1] Esborrar esb1.md
3 1 file changed, 0 insertions(+), 0 deletions(-)
4 delete mode 100644 esb1.md
```

 - Esborrem directament l'ordre d'esborrat a git:

```ssh
1 $ git rm esb2.md
```

 - I amb el commit farem el 2:

```ssh 
1 $ git commit -a -m "ESborrat esb2.md"
```

### 10-Movent fitxers

 - Crrem un fitxer, l'afegim al control de verions i al repositori:

```ssh 
1 $ touch mv1.md
2 $ git add mv1.md
3 $ git commit -a -m "Afegir mv1.md"
4 [master b063c63] Afegir mv1.md
5  1 file changed, 0 insertions(+), 0 deletions(-)
6  rename esb2.md => mv1.md (100%)
```

 - Mourem el fixter amb **git mv**:

```ssh 
1 $ git mv mv1.md mv1_renomenat.md
2 $ git status
3 On branch master
4 Changes to be committed:
5   (use "git reset HEAD <file>..." to unstage)
6
7       renamed:    mv1.md -> mv1_renomenat.md
```

 - Per finalitzar el pujarem:

```ssh
1 $ git commit -a -m "Renomenat mv1.md a mv1_renomenat.md"
2 [master 3ec28c1] Renomenat mv1.md a mv1_renomenat.md
3  1 file changed, 0 insertions(+), 0 deletions(-)
4  rename mv1.md => mv1_renomenat.md (100%)
```

### 11-Desder canvis

 - Afegir línies en un fitxer anterior:

```ssh
1 $ echo "Probant defer canvis" >> mv1_renomenat.md
```

 - Per comprobar un status:

```ssh
1 $ git status 
2 On branch master
3 Changes not staged for commit:
4   (use "git add <file>..." to update what will be committed)
5   (use "git check out --<file>..." to discard changes in working directory)
6
7       modified:   mv1_renomenat.md
```
 - Si ara lo que volem es defer el canvi, eu farem amb un **git checkout**

```ssh
1 $ git checkout -- mv1_renomenat.md
```

 - I si per finalitzar mirem el status podem observar que ha tornat aon abans:

```ssh
1 $ git status
2 ON branch master
3 Untracked files:
4   (use "git add <file>..." to include in what will be committed)
```


#### RUBÉN BERTO MUÑOZ - EDD