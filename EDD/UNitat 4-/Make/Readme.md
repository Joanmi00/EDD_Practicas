
# MAKE

1.- Lo primero que haremos será instalar e make con el siguiente comando:

_`$sudo apt install make`_

### COMPILAREMOS UN "HOLA MUNDO"

2.- Crearemos, un progrma en C senzillo, con un "Hola Mundo":

-Dentro del fitxero pondremos esto: 

```
#include <stdio.h>

int main()
{
        printf("Hola món\n");
        return 0;
}
```

3.- Copilaremos este fitxero con:

_`gcc hola.c`_

4.- Obtendremos un ejecutable llamado __a.out__, si volem cambiar el nom de fitxer d'eixida heu farem amb un parametre __-o__.

5.-SI volem que mos mostre el Warnings ficarme el comando :

`_gcc -Wall -g hola.c -o hola_`

### ARA UTILITZAREM MAKE

6.- Creem un fitxer en el meu cas el anomenarem __calc.c__, en el cual anem a vore com funciona make, ara dins de aquest fitxer possarem el següent:

```
#include <stdio.h>

int suma(int op1, int op2){
    return (op1+op2);
}

int resta(int op1, int op2){
    return (op1-op2);
}

int multiplica(int op1, int op2){
    return (op1*op2);
}

int divideix(int op1, int op2){
    return (op1/op2);
}

int main()
{
        int a=10;
        int b=5;

        printf("La suma de %d i %d és %d\n", a, b, suma(a,b));
        printf("La resta entre %d i %d és %d\n", a, b, resta(a,b));
        printf("La multiplicació de %d i %d és %d\n", a, b, multiplica(a,b));
        printf("La divisió entre %d i %d és %d\n", a, b, divideix(a,b));
}
```


-En aquest fitxer lo que hem fet es ficarli 4 funcions: la de suma, resta, multiplicacio i diivisio.

7.- Ara en el fitxer __calc.c__ posarem les 4 funcions:

```
int suma(int op1, int op2){
    return (op1+op2);
}

int resta(int op1, int op2){
    return (op1-op2);
}

int multiplica(int op1, int op2){
    return (op1*op2);
}

int divideix(int op1, int op2){
    return (op1/op2);
}
```

8.- EL fitxer __calc.h__ conté les capcaeres de les funcions:

```
#ifndef MYCALC
#define MYCALC

int suma(int op1, int op2);
int resta(int op1, int op2);
int multiplica(int op1, int op2);
int divideix(int op1, int op2);

#endif
```
### COPILAR EN LLIBRETES PROPIES

9.- Ara anem a crear el __calacula__ en el que necessitarem __calcula.c__, __calc.o__ i __calc.c__.

10.- Per a realitxar la copilació en primer lloc haurem de obtindre el __calc.o__ mitjançant __calc.c__:

_`gcc -c calc.c -o calc.o`_

11.- El executable __calcula__ el obtidrem amb el __calc.o__ i la font del __calcula.c__:

_`gcc calc.o calcula.c -o calcula`_

12.- Ara comprobem que el programa funciona amb el ejecutador:

```
$ ./calcula
La suma de 10 i 5 és 15
La resta entre 10 i 5 és 5
La multiplicació de 10 i 5 és 50
La divisió entre 10 i 5 és 2
```

Si ens ixes asovoldra dir que hem fet bé el programa.

13.- Ara per acabar farem dos funcionetes més una que ens diga el numero major y l'alra que ens diga la mitjana entre els dos numeros.

14.- **Matjor**, per a traurela lo que farem sera añadir al nostre __calc.c__ lo que mostrare ara:

```
int major (int op1, int op2) {
    if (op1>op2){
        return op1;
    }
    else{
        return op2;  
    }  
}
```

També tindrem que añadir la funcio al nostre __calc.h__, simplemet ficarem: _`int major(int op1, int op2);`_

-Per a acabr lo unic que tindriem que fer es tornar a fer els passos desde l'apartat 9 fins el 12 i lo unic que cambiara es que el calcula ens odnara aquest resultat:

```
La suma de 10 i 5 és 15
La resta entre 10 i 5 és 5
La multiplicació de 10 i 5 és 50
La divisió entre 10 i 5 és 2
El major entre 10 i 5 és 10
```

15.- Per a acabar farem la **mitja** que sera fer lo mateix que en el de abans sols añadirem en el __calc.c__ aquesta funcio:

```
float mitjana (float op1, float op2){
    return ((op1+op2)/2);
}
```

-I en el __calc.h__ añadriem: _`int mitja(int op1, int op2);_`

### EL RESULTAT FINAL ES AQUEST

-**CACL.H**
```
#ifndef MYCALC
#define MYCALC

int suma(int op1, int op2);
int resta(int op1, int op2);
int multiplica(int op1, int op2);
int divideix(int op1, int op2);
int major(int op1, int op2);
int mitjana(int op1, int op2)

#endif
```

-**CALC.C**
```
#include <stdio.h>

int suma(int op1, int op2){
    return (op1+op2);
}

int resta(int op1, int op2){
    return (op1-op2);
}

int multiplica(int op1, int op2){
    return (op1*op2);
}

int divideix(int op1, int op2){
    return (op1/op2);
}

int major (int op1, int op2) {
    if (op1>op2){
        return op1;
    }
    else{
        return op2;  
    }  
}

float mitjana (float op1, float op2){
    return ((op1+op2)/2);
}
int main()
{
        int a=10;
        int b=5;

        printf("La suma de %d i %d és %d\n", a, b, suma(a,b));
        printf("La resta entre %d i %d és %d\n", a, b, resta(a,b));
        printf("La multiplicació de %d i %d és %d\n", a, b, multiplica(a,b));
        printf("La divisió entre %d i %d és %d\n", a, b, divideix(a,b));
        printf("EL major entre %d i %d és %d\n", a, b, major(a,b));
        printf("La mitja entre %d i %d és %f\n", a, b, mitjana(a,b));
}
```

-./CALCULA
```
La suma de 10 i 5 és 15
La resta entre 10 i 5 és 5
La multiplicació de 10 i 5 és 50
La divisió entre 10 i 5 és 2
EL major entre 10 i 5 és 10
La mitja entre 10 i 5 és 7.500000
```

