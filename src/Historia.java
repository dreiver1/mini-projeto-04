import java.util.Scanner;

public class Historia {
    private Capitulo inicio;
    private int contador = 0;


    public void iniciar() throws InterruptedException{
        lerCapitulo(this.inicio);
    }

    private void lerCapitulo(Capitulo capitulo) throws InterruptedException {
        System.out.println(capitulo.getTitulo());
        System.out.println(" ");
        System.out.println(capitulo.getContexto());
        System.out.println(" ");
        inicio.printEscolhas();
        System.out.println("Faça sua escolha: ");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int opcao = Integer.parseInt(scanner.nextLine());
        int i = 1;
        Escolha escolha = capitulo.getEscolha();
        while(i <= opcao){
            if(i == opcao){
                System.out.println(escolha.getResultado());
                System.out.println(" ");
            }else{
                escolha = escolha.getProxima();
            }
            i++;
        }
        System.out.println("Para continuar digite Enter ... ");
        scanner.nextLine();
        if(capitulo.getProximo() != null){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("...");
            Thread.sleep(1000);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Capitulo aux = capitulo.getProximo();
            lerCapitulo(aux);
        } else {
            System.out.println(" ");
            System.out.println("E assim termina sua jornada em busca do tesouro lendário da ilha misteriosa.");
        }
    }


    public void addCapitulo(String titulo, String contexto, String[][] escolhas) {
        if(this.inicio == null){
            this.inicio = new Capitulo(titulo, contexto, escolhas);
            this.contador = contador + 1;
        } else if (this.inicio.getProximo() == null){
            Capitulo aux = new Capitulo(titulo, contexto, escolhas);
            this.inicio.setProximo(aux);
            this.contador = contador + 1;
        } else {
            Capitulo prox = this.inicio.getProximo();
            addCapitulo(prox, titulo, contexto, escolhas);
        }
    }

    private void addCapitulo(Capitulo capitulo, String titulo, String contexto, String[][] escolhas) {
        if(capitulo.getProximo() == null){
            Capitulo aux = new Capitulo(titulo, contexto, escolhas);
            capitulo.setProximo(aux);
            this.contador = contador + 1;
        } else {
            Capitulo prox = this.inicio.getProximo();
            addCapitulo(prox, titulo, contexto, escolhas);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String tituloCapitulo01 = "Capítulo 1: O Chamado";
        String contextoCapitulo01 = "Você é um jovem aventureiro que ouve falar de uma misteriosa ilha que supostamente abriga um tesouro lendário. Você decide investigar a ilha e chegar lá de barco. No entanto, durante a viagem, uma grande tempestade aparece e você tem que tomar uma decisão.";
        String[][] escolhasCapitulo01 = new String[3][2];
        escolhasCapitulo01[0][0] = "Opção 1: Continuar navegando";
        escolhasCapitulo01[0][1] = "Você decide continuar navegando e enfrentar a tempestade. Isso pode ser perigoso, mas também pode permitir que você chegue à ilha mais cedo e tenha uma vantagem sobre outros aventureiros.";
        escolhasCapitulo01[1][0] = "Opção 2: Ancorar em uma ilha próxima";
        escolhasCapitulo01[1][1] = "Você decide ancorar em uma ilha próxima e esperar a tempestade passar. Isso pode ser mais seguro, mas também pode atrasar sua chegada à ilha e permitir que outros aventureiros cheguem primeiro.";
        escolhasCapitulo01[2][0] = "Opção 3: Pedir ajuda a um navio próximo";
        escolhasCapitulo01[2][1] = "Você decide pedir ajuda a um navio próximo para navegar em segurança pela tempestade. Isso pode ser uma escolha sábia, mas também pode significar que você terá que dividir o tesouro com os outros aventureiros.";
        Historia tesouro = new Historia();
        tesouro.addCapitulo(tituloCapitulo01, contextoCapitulo01, escolhasCapitulo01);
        String tituloCapitulo02 = "Capítulo 2: A Exploração";
        String contextoCapitulo02 = "Depois de superar a tempestade, você finalmente chega à ilha. No entanto, ela é muito maior do que você imaginou e você precisa decidir como explorá-la.";
        String[][] escolhasCapitulo02 = new String[3][2];
        escolhasCapitulo02[0][0] = "Opção 1: Seguir pelo caminho mais curto";
        escolhasCapitulo02[0][1] = "Você decide seguir pelo caminho mais curto que leva diretamente ao local do tesouro. Isso pode ser mais rápido, mas também pode estar cheio de armadilhas e perigos.";
        escolhasCapitulo02[1][0] = "Opção 2: Fazer um desvio seguro";
        escolhasCapitulo02[1][1] = "Você decide fazer um desvio mais seguro que leva mais tempo, mas te leva para o tesouro sem correr riscos. Isso pode garantir que você chegue ao tesouro em segurança, mas também pode permitir que outros aventureiros cheguem antes de você.";
        escolhasCapitulo02[2][0] = "Opção 3: Explorar a ilha inteira";
        escolhasCapitulo02[2][1] = "Você decide explorar a ilha inteira e descobrir todos os segredos que ela guarda. Isso pode levar muito tempo, mas também pode permitir que você encontre tesouros e recursos valiosos que ninguém mais encontrará.";
        tesouro.addCapitulo(tituloCapitulo02, contextoCapitulo02, escolhasCapitulo02);
        String tituloCapitulo3 = "Capítulo 3: O Final";
        String contextoCapitulo3 = "Depois de explorar a ilha e superar todos os obstáculos, você finalmente chega ao local do tesouro. No entanto, você descobre que um grupo de outros aventureiros também chegou lá e está disputando o tesouro. Você precisa decidir como lidar com a situação.";
        String[][] escolhasCapitulo3 = new String[3][2];
        escolhasCapitulo3[0][0] = "Opção 1: Lutar contra os outros aventureiros";
        escolhasCapitulo3[0][1] = "Você decide lutar contra os outros aventureiros para obter o tesouro. Isso pode ser perigoso, mas também pode garantir que você fique com o tesouro inteiro.";
        escolhasCapitulo3[1][0] = "Opção 2: Negociar com os outros aventureiros";
        escolhasCapitulo3[1][1] = "Você decide negociar com os outros aventureiros e dividir o tesouro. Isso pode ser uma escolha sábia, mas também pode significar que você terá que dividir o tesouro com outras pessoas.";
        escolhasCapitulo3[2][0] = "Opção 3: Deixar o tesouro para trás";
        escolhasCapitulo3[2][1] = "Você decide deixar o tesouro para trás e partir para outras aventuras em busca de tesouros e riquezas. Isso pode ser uma escolha sábia, já que você evita conflitos e pode encontrar outras oportunidades de riqueza, mas também pode ser frustrante, pois você pode ter perdido a chance de conseguir um grande tesouro.";
        tesouro.addCapitulo(tituloCapitulo3, contextoCapitulo3, escolhasCapitulo3);
        tesouro.iniciar();
    }
}