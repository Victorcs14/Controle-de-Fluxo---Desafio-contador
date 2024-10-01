import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

// aqui pega o primeiro numero 
        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = terminal.nextInt();

        int parametroDois;
        while (true) { // cria um Loop até que o segundo número seja válido
            try {
                // Captura o segundo número
                System.out.println("Digite o segundo parâmetro:");
                parametroDois = terminal.nextInt();
                
// Valida se o segundo número é maior ou igual ao primeiro 
                contar(parametroUm, parametroDois); 
                break; // Se for válido, sai do loop
                
            } catch (ParametrosInvalidosException exception) {
// Se o segundo número for inválido, exibe a mensagem e pede para digitar novamente
                System.out.println(exception.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }

        terminal.close(); // Fechar o Scanner
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
    // Verifica se o segundo número é maior ou igual ao primeiro nos dígitos individuais
        if (!validaDigitos(parametroUm, parametroDois)) {
            throw new ParametrosInvalidosException("O segundo número deve ser maior que o primeiro em todos os dígitos.");
        }

// Se os números forem válidos, imprime os dígitos de cada número
        System.out.println("Imprimindo os dígitos do primeiro número:");
        imprimirDigitos(parametroUm); // Imprime os dígitos do primeiro número

        System.out.println("Imprimindo os dígitos do segundo número:");
        imprimirDigitos(parametroDois); // Imprime os dígitos do segundo número
    }

    // Método para imprimir os dígitos de um número
    static void imprimirDigitos(int numero) {
        String numeroComoString = Integer.toString(numero); // Converte o número para String
        for (int i = 0; i < numeroComoString.length(); i++) {
            System.out.println(numeroComoString.charAt(i)); // Imprime cada dígito separadamente
        }
    }

    // Método para validar se cada dígito do segundo número é maior ou igual ao correspondente do primeiro número
    static boolean validaDigitos(int parametroUm, int parametroDois) {
        String primeiroNumero = Integer.toString(parametroUm);
        String segundoNumero = Integer.toString(parametroDois);
        
        // Se os números têm quantidades de dígitos diferentes, o segundo deve ter mais dígitos
        if (segundoNumero.length() < primeiroNumero.length()) {
            return false;
        }

        // Comparando os dígitos individualmente
        for (int i = 0; i < primeiroNumero.length(); i++) {
            int digito1 = Character.getNumericValue(primeiroNumero.charAt(i));
            int digito2 = Character.getNumericValue(segundoNumero.charAt(i));

            if (digito2 < digito1) {
                return false; // Se algum dígito do segundo número for menor que o do primeiro, retorna falso
            }
        }

        return true; // Todos os dígitos do segundo número são maiores ou iguais
    }
}

// Exceção personalizada
class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
