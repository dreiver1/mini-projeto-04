public class Escolha {
    private String titulo;
    private String resultado;
    private Escolha proxima;
    
    public Escolha(String titulo, String resultado) {
        this.titulo = titulo;
        this.resultado = resultado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Escolha getProxima() {
        return proxima;
    }

    public void setProxima(Escolha proxima) {
        this.proxima = proxima;
    }

}
