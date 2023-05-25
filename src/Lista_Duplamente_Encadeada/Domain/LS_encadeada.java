package Lista_Duplamente_Encadeada.Domain;

public class LS_encadeada<T extends Comparable<T>> {

    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;
    private int tamanho;

    public LS_encadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public LS_encadeada<T> Sublista(int start, int end) throws Exception {
        if(start > end || start >= tamanho || end >= tamanho) throw new Exception("Posições inválidas");
        LS_encadeada<T> temp = new LS_encadeada<>();
        NoDuplo<T> atual = get(start);
        int cont = start;
        while (cont <= end){
            temp.incluir(atual.num);
            atual = atual.next;
            cont++;
        }
        return temp;
    }

    public NoDuplo<T> get(int posicao){
        NoDuplo<T> atual = posicao > getTamanho()/2 ? fim : inicio;
        int cont = posicao > getTamanho()/2 ? getTamanho() : 0;
        while (cont != posicao){
            atual =  posicao > getTamanho()/2 ? atual.ant : atual.next;
            cont =  posicao > getTamanho()/2 ? cont-1 :   cont+1;
        }
        return atual;
    }

    public boolean contem(T elemento) {
        NoDuplo<T> atual = inicio;
        while (atual != null) {
            if (atual.num.equals(elemento)) {
                return true;
            }
            atual = atual.next;
        }
        return false;
    }
    public LS_encadeada<T> incluir(T elemento) {
        NoDuplo<T> novoNoDuplo = new NoDuplo<T>(elemento);

        if (inicio == null) {
            inicio = novoNoDuplo;
            fim = novoNoDuplo;
        } else {
            novoNoDuplo.ant=fim;
            fim.next = novoNoDuplo;
            fim = novoNoDuplo;
        }
        tamanho++;
        return this;

    }
    public T get(T elemento) {
        NoDuplo<T> atual = inicio;
        while (atual != null) {
            if (atual.num.equals(elemento)) {
                return atual.num;
            }
            atual = atual.next;
        }
        return null;
    }

    public LS_encadeada incluirInicio(T elemento) {
        NoDuplo<T> novoNoDuplo = new NoDuplo<T>(elemento);
        if (inicio == null) {
            inicio = novoNoDuplo;
            fim = novoNoDuplo;
        } else {
            novoNoDuplo.next = inicio;
            inicio.ant=novoNoDuplo;
            inicio = novoNoDuplo;
        }
        tamanho++;
        return this;
    }

    public void limpar(){
        inicio=fim=null;
        tamanho=0;
    }

    public LS_encadeada incluir(T elemento, int posicao) throws Exception {

        if (posicao>getTamanho()){
            throw new Exception("Posição não encontrada na lista");
        }
        if (posicao == 0) {
            incluirInicio(elemento);
            return this;
        }else if(posicao == getTamanho()){
            incluir(elemento);
            return this;
        }
        NoDuplo<T> novoNoDuplo = new NoDuplo<T>(elemento);
        NoDuplo<T> atual = posicao > getTamanho()/2 ? fim : inicio;
        int cont = posicao > getTamanho()/2 ? getTamanho() : 0;
        while (cont != posicao){
            atual =  posicao > getTamanho()/2 ? atual.ant : atual.next;
            cont =  posicao > getTamanho()/2 ? cont-1 :   cont+1;
        }
        novoNoDuplo.next=atual;
        novoNoDuplo.ant=atual.ant;
        atual.ant.next=novoNoDuplo;
        atual.ant=novoNoDuplo;
        tamanho++;
        return this;
        }


    public void remover(T elemento)throws Exception {

        NoDuplo<T> atual = inicio;
        NoDuplo<T> anterior = null;
        while (atual != null) {
            if (atual.num.equals(elemento)) {
                if (anterior == null) {
                    inicio = atual.next;
                    if (inicio == null) {
                        fim = null;
                    }
                } else {
                    anterior.next = atual.next;
                    if (atual == fim) {
                        fim = anterior;
                    }
                }
                tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.next;
        }
    }

    public void removerPosicao(int posicao) {

        NoDuplo<T> atual = posicao > getTamanho()/2 ? fim : inicio;
        int cont = posicao > getTamanho()/2 ? getTamanho() : 0;
        while (cont != posicao){
            atual =  posicao > getTamanho()/2 ? atual.ant : atual.next;
            cont =  posicao > getTamanho()/2 ? cont-1 :   cont+1;
        }
        atual.ant.next=atual.next;
        atual.next.ant=atual.ant;


        tamanho--;
    }


    public void imprimir() {
        NoDuplo<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.num + " ");
            atual = atual.next;
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }


}
