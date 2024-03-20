import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Transacao {
    
    private String data;
    private String hora;
    private String descricao;
    private double valor;

    public Transacao(String descricao) {
        this.descricao = descricao;

        LocalDateTime agora = LocalDateTime.now();
    
        DateTimeFormatter newFormatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = agora.format(newFormatoData);

        DateTimeFormatter newFormatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.hora = agora.format(newFormatoHora);

    }

    public void registrarDeposito(Double valorDeposito) {
        this.valor += valorDeposito;
        
    }

    public void mostrarInformacoesDeposito() {
        System.out.println("Deposito efetuado");
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Data: " + this.data);
        System.out.println("Hora: "+ this.hora);
        System.out.println("Valor depositado: R$ " + String.format("%.2f", this.valor));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a descricao do depósito: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o valor do depósito");
        double valorDeposito = scanner.nextDouble();

        Transacao transacao = new Transacao(descricao);
        transacao.registrarDeposito(valorDeposito);
        transacao.mostrarInformacoesDeposito();

        scanner.close();
    }
}