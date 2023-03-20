public class Capitulo{
    private String titulo;
    private String contexto;
    private Escolha escolhas;
    private Capitulo proximo;


    public Capitulo(String titulo, String contexto, String[][] escolhas) {
        this.titulo = titulo;
        this.contexto = contexto;
        addAllEscolhas(escolhas);
    }

    private void addAllEscolhas(String[][] escolhas) {
        int i = 0;
        while (i < 3) {
            addEscolhas(escolhas[i]);
            i++;
        }
    }

    public Capitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void printEscolhas() {
        System.out.println(this.escolhas.getTitulo() );
        Escolha aux = this.escolhas.getProxima();
        for(int i = 0; i < 2; i++){
            System.out.println( aux.getTitulo() );
            aux = aux.getProxima();
        }
    }

    public Escolha getEscolha(){
        return this.escolhas;
    }

    public void addEscolhas(String[] conteudo) {
        String titulo = conteudo[0];
        String resultado = conteudo[1];
        if(this.escolhas == null){
            this.escolhas = new Escolha(titulo, resultado);
        } else if ( this.escolhas.getProxima() == null ){
            Escolha aux = new Escolha(titulo, resultado);
            this.escolhas.setProxima(aux);
        }else{
            Escolha aux = this.escolhas.getProxima();
            addEscolhas(aux, titulo, resultado);
        }
    }
    private void addEscolhas(Escolha escolha, String titulo, String resultado) {
        if(escolha.getProxima() == null){
            Escolha aux = new Escolha(titulo, resultado);
            escolha.setProxima(aux);
        }else{
            Escolha aux = escolha.getProxima();
            addEscolhas(aux, titulo, resultado);
        }
    }
    
    public Capitulo getProximo() {
        return proximo;
    }

    public void setProximo(Capitulo proximo) {
        this.proximo = proximo;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }
}