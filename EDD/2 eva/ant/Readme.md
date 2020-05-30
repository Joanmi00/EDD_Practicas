# Aplicaió d'exeple

1.'Deurem de cresr dos fitxers .java, en el meu cas seran aquest dos:

```
.
`-- edd
    `-- ant
        `-- projecte
            | -- Calculadora.java 
            ` -- Calcula.java
```

### Classe edd.ant.projecte.Calculadora

2.- Dins _`Calculadora.java`_ tindrem que añadir lo que vuigam que faja el nostre fitxer :

```
package edd.ant.projecte;

public class Calculadora {

    private float lastResult;
    private String lastOp;

    public float getLastResult(){
        return this.lastResult;
    }

    public String getLastOp(){
        return this.lastOp;
    }

    public float suma(float op1, float op2){
        float result=op1+op2;
        this.lastResult=result;
        this.lastOp="Suma";

        return result;
    }

    public float resta(float op1, float op2){
        float result=op1-op2;
        this.lastResult=result;
        this.lastOp="Resta";

        return result;
    }

    public float multiplica(float op1, float op2){
        // Fem els càlculs
        float result=op1*op2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Multiplica";

        // I finalment retornem els resultats
        return result;
    }

    public float divideix(float op1, float op2){
        // Fem els càlculs
        float result=op1/op2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="Divideix";

        // I finalment retornem els resultats
        return result;
    }

}
```

### Classe edd.ant.projecte.Calcula

2.- Dins _`Calcula.java`_ tindrem que añadir lo que vuigam que faja el nostre fitxer :

package edd.ant.projecte;

import edd.ant.projecte.Calculadora;

public class Calcula {
    private static float operand1;
    private static float operand2;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("\nSintaxi incorrecta. Necessite dos números.");
            System.exit(-1);
        }

        operand1=Float.parseFloat(args[0]);
        operand2=Float.parseFloat(args[1]);

        Calculadora myCalc=new Calculadora();

        System.out.println("La suma entre "+operand1+" i "+operand2+" és "+myCalc.suma(operand1, operand2));
        System.out.println("La resta entre "+operand1+" i "+operand2+" és "+myCalc.resta(operand1, operand2));
        System.out.println("La multiplicació entre "+operand1+" i "+operand2+" és "+myCalc.multiplica(operand1, operand2));
        System.out.println("La divisió entre "+operand1+" i "+operand2+" és "+myCalc.divideix(operand1, operand2));
        System.out.println("Última operació realitzada: "+myCalc.getLastOp()+"; Últim resultat: "+myCalc.getLastResult());
    }
}

### Compilació i execusió

3.- Primer deurem de copilar els dos fitxers de java que hem creat en la carpeta projecte, aixo eu farem amb este comando:

```
$ javac edd/ant/projecte/*.java
```

javac el gastarem per a copilar.

4.- Ara ejecutarem el fitxer calculadora amb:

```
$ java edd.ant.projecte.Calcula num1(un numero qualsevol) num2(un numero qualsevol)
```

## Apache Ant

5.- El primer que deurem de fer es crear el fixer build.xml, que sera el nostre fitxer de construcció d'Ant. En aquest fitxer posarem el seguent:

```
<project>
    <target name="clean">
        <delete dir="classes" />
    </target>

    <target name="compile" depends="clean">
        <mkdir dir="classes" />
    <javac includeantruntime="false" srcdir="edd/ant/projecte" destdir="classes" />
    </target>

    <target name="run" depends="compile">
        <java classpath="classes" classname="edd.ant.projecte.Calcula">
            <arg value="${arg0}"/>
            <arg value="${arg1}"/>
        </java>

    </target>
</project>
```

EL fitxer el deurem de crear en l'arrell.

### Instal·lació d'Ant

6.- Comprovarem si el tenim instalat amb: 

```
$ apt-cache policy ant
```

7.- I per a instalarlo ficarem:

```
$ sudo apt isntall ant
```

### Ús d'Ant

8.- Per a copilar el el fiter creat i veure que tot va be, farem :

```
$ ant compile
```

9.- I per a la seua ejecució, possarem:

```
$ ant run -Darh0=3 -Darg1=4
```