# -Subversion Egde


-Aqui os dejare un link donde os explica como instalar el docker por si no teneis  instalado: [Docker](https://www.digitalocean.com/community/tutorials/como-instalar-y-usar-docker-en-ubuntu-18-04-1-es)

### 1- El primer pas sera instalar el "subversion" al client:
```ssh 
1 $ sudo apt-get install subversion
```

2- Ara farem un check out amb el cual posarem el nostre nom de usuari
```sh
1 $ svn co http://localhost:18080/svn/Projecte1 --username=rubenberto
2 Authentication realm: <http://localhost:18080> CollabNet Subversion
    Repository
3 Password for 'rubenberto': *********
4 A     Projecte1/trunk
5 A     Projecte1/branches
6 A     Projecte1/tags
7 Checked out revision 1.
```

  - **trunk**: amb lalínia principal o troncal de desenvolupament.
- **branches**: On tenim diferents branques de desenvolupament, és a dir, bifurcacions de labranca troncal, per exemple per anar afegint noves funcionalitats a una aplicació. Quan eldesenvolupament d’una branca es vol incorporar a la brancaprincipal, es mesclen els canvis,amb el que s’anomena una operaciómerge.
- **tags**: Els tags representen comsnapshotsoinstantàniesdel projecte en un moment donat. Pottractar-se d’instantànies que contenen les versions estables d’na aplicació, per exemple.

4- Anem a treballar en **trunks** , i crearem un fitxer que en el meu cas anomenarem practica.md:
```sh
1 function saluda (){
2    console .log("Hola Subversion");
3 }
4
5 saluda()
```

5- Ejecutarem amb **nodejs** hi ha que com hem pogut comprobar es tracte de codic *javascript*:
```sh
1 $ nodejs trunk/ruben.md
2 Hola Subversion
```

6- Ara desde dins del directori llansarem l'orre (status):
```sh
1 $ svn st
2 ?     trunk/ruben.md
```
El interrogant ens diu que es un fitxer nou i que no esta sotmes a un control de versions.

7- Per a afetgirlo ficarem l'orde **svn add**:
```sh
1 $ svn add trunk/ruben.md
2 A     trunk/ruben.md
```
I ya el tendriem añadit a un control de verions.

8- Si fem altra vegada el comando **svn st** veurem que mos ix com abans, aleshores deurem de fer un commit per a pujar els canvis al servidor:
```sh
1 $ svn ci -m "Afegint el fitxer ruben.md"
2 Authentication realm: <http://localhost:18080>CollabNet Subversion
   Repositoru
3 Password for 'rubenberto': *********
4
5 Adding    trunk/ruben.md
6 Trasmitting file data .done
7 Committing transaction...8 Committed revision 2.
```

9- Per finalitzar farem un update amb el comando **svn up**:
```sh
1 $ svn up
2 Updating '.':
3 Authentication realm: <http://localhost:18080> CollabNet Subversion
    Repository
4 Password for 'rubenberto': *********
5
6 A     trunk/ruben.md
7 Updated to revision 4.
```

