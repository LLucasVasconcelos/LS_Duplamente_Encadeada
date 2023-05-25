package Test;

import Domain.ListaDupEnc;

public class Main {
    public static void main(String[] args) throws Exception {

        ListaDupEnc<Integer> list = new ListaDupEnc<Integer>();

        list.incluir(3).incluir(2).incluirInicio(5).incluir(2);
        list.incluir(4);
        list.incluir(5);
        list.incluir(6);
        list.incluirInicio(2);
        list.imprimir();
        list.incluir(5, 4);
        list.imprimir();
        list.removerPosicao(4);
        list.imprimir();
        ListaDupEnc subList = list.Sublista(1, 4);
        subList.imprimir();
        System.out.println(list.contem(9));
    }
}