package calculadora;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Operacao
{

    private double valor1, valor2, resposta;
    private String sinal;
    

    
    public Operacao(double operador1, double operador2, String simbolo) throws Exception
    {
        valor1 = operador1;
        valor2 = operador2;
        sinal =simbolo;
        executa();
    }
    
   
    public double executa() throws Exception
    {
        if (sinal == "+")
        {
            return soma();
        }
        else if (sinal == "-")
        {
            return subtracao();
        }
        else if (sinal == "*")
        {
            return multiplicacao();
        }
        else if (sinal == "/")
        {
            return divisao();
        }
        else if (sinal == "^")
        {
            return potencia();
        }
        else if (sinal == "raiz") 
        {
            return raiz();
        }
        else if (sinal == "log") 
        {
            return log();
        }
        else
        {            
           return 0;
        }
    }
    
   
    @Override
    public String toString()
    {
        return valor1 + sinal +  valor2 + " = " + resposta;
    }

    
    private double soma()
    {   
        double respostaSoma = valor1 + valor2; 
        resposta = respostaSoma;
        return resposta;
    }
    
    
    private double subtracao()
    {
        double respostaSubtracao = valor1 - valor2;
        resposta = respostaSubtracao;
        return resposta;
    }
    
    
    private double multiplicacao()
    {
        double respostaMultiplicacao = valor1 * valor2;
        resposta = respostaMultiplicacao;
        return resposta;
    }
   
    private double divisao() throws Exception
    {
        if(valor2 == 0)
        {
            
         throw new Exception("divisão por 0 não permitida");
            
        }
        double respostaDivisao = valor1 / valor2;
        resposta = respostaDivisao;
        return resposta;
    }
    
    private double potencia()
    {
        double respostaPotencia = Math.pow(valor1, valor2);
        resposta = respostaPotencia;
        return resposta;
    }
   
    private double raiz() throws Exception
    {
        if (valor2 % 2 == 0 && valor1 < 0)
        {
            throw new Exception("raiz de numero negativo com indice par nao pode");
        }
        double respostaRaiz = Math.pow(valor1, 1 / valor2); 
        resposta = respostaRaiz;
        return resposta;
        
    }
    
    
    private double log()
    {
        
        double respostaLog = Math.log(valor1) / Math.log(valor2); //valor2 e a base.
        resposta = respostaLog;
        return resposta;
    }
}
