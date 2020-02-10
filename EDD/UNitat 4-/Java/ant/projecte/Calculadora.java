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
    
      public float media(float op1, float op2){
        // Fem els càlculs
        float result=(op1*op2)/2;

        // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="media";

        // I finalment retornem els resultats
        return result;
    }

     public float major(float op1, float op2){
        // Fem els càlculs
        if (op1>op2){
            result=op1;
        }
        else{
            result=op2;
        }
          // Actualitzem els atributs de la classe
        this.lastResult=result;
        this.lastOp="major";

        // I finalment retornem els resultats
        return result;
    }

}
