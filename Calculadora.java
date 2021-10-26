package calculadora;
//oi
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;

public class Calculadora {

    public static void main(String[] args) throws IOException {
        ArrayList<String> Vetor = new ArrayList();       
        int escolha; 
        int sair = 0;
        double operador2, operador1; 
        operador2 = 0;
        operador1 = operador2;
        String sinal = "0";
         Scanner inputReader = new Scanner(System.in);
        do {
            System.out.println("menu:");
            System.out.println(" 0 - Soma");
            System.out.println(" 1 - Subtracao");
            System.out.println(" 2 - Multiplicacao");
            System.out.println(" 3 - Divisao");
            System.out.println(" 4 - Potencia ");
            System.out.println(" 5 - Raiz");
            System.out.println(" 6 - Log");
            System.out.println(" 7 - Gravar no Arquivo");
            System.out.println(" 8 - Carregar Arquivo");
            System.out.println(" 9 - Exit");
            System.out.println("\n digite o número referente a opcao desejada");

            try {
                escolha = inputReader.nextInt();

                if (0 <=  escolha && escolha <= 6) {
                    System.out.print("Digite o primeiro valor: ");
                   operador1 = inputReader.nextDouble();
                    System.out.print("Digite o segundo valor: ");
                   operador2 = inputReader.nextDouble();
                    
                }

                if (escolha == 0) {
                   sinal = "+";
                } else if (escolha == 1) {
                   sinal = "-";
                } else if (escolha == 2) {
                   sinal = "*";
                } else if (escolha == 3) {
                   sinal = "/";
                } else if (escolha == 4) {
                   sinal = "^";
                } else if (escolha == 5) {
                   sinal = "raiz";
                } else if (escolha == 6) {
                   sinal = "log";
                } else if (escolha == 7) {
                    try {
                        System.out.print("\n Digite o nome do arquivo: ");
                        String nome = inputReader.next();

                        FileWriter arquivoEscrito = new FileWriter(nome);
                        PrintWriter arquivoPreparado = new PrintWriter(arquivoEscrito);
                        System.out.println("\n Operação realizada com sucesso.");

                        int n = Vetor.size();
                        for (int i = 0; i < n; i++) {
                            arquivoPreparado.println(Vetor.get(i));
                        }
                        arquivoPreparado.close();
                    } catch (IOException ex) {
                        System.err.println("Ocorreu um erro, tente novamente!");
                    }

                } else if (escolha == 8) {
                    try {
                        System.out.print("\nDigite o nome do arquivo a ser lido: ");
                        String nome = inputReader.next();

                        FileReader arquivoLido = new FileReader(nome);
                        BufferedReader buffer = new BufferedReader(arquivoLido);

                        String str;
                        String simb[] = new String[3];

                        while ((str = buffer.readLine()) != null) {
                            Vetor.add(str);
                            simb = str.split(" ");

                            Operacao novaOperacao = new Operacao(Double.parseDouble(simb[0]), Double.parseDouble(simb[2]), simb[1].toString());
                            System.out.println(novaOperacao);
                        }

                        System.out.println("---------------------------------------------------------------------------------------\n");
                    } catch (FileNotFoundException e) {
                        System.err.println("Arquivo não encontrado.");
                        System.out.println("---------------------------------------------------------------------------------------\n");
                    }
                } else if (escolha == 9) {
                    System.out.println("\n Sair do programa.");
                    sair = 1;
                } else 
                {
                    throw new Exception("O que foi digitado nao corresponde a uma operacao valida.");
                }

               
                if(0 <= escolha && escolha <= 6)
                {
                    Operacao novaOperacao = new Operacao(operador1,operador2,sinal);
                    Vetor.add(operador1 + " " +sinal + " " +operador2);
                    System.out.println(novaOperacao);
                    
                }

            } catch (InputMismatchException e) {
     
                System.err.println("entre apenas numeros");
               
                inputReader.nextLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (sair != 1);

    }
}
