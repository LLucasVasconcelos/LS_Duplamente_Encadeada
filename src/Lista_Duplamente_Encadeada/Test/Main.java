package Lista_Duplamente_Encadeada.Test;

import Lista_Duplamente_Encadeada.Domain.LS_encadeada;

public class Main {
    public static void main(String[] args)throws Exception {


   LS_encadeada<Integer> list= new LS_encadeada<Integer>();

   list.incluir(3).incluir(2).incluirInicio(5).incluir(2);
   list.incluir(4);
   list.incluir(5);
   list.incluir(6);
   list.incluirInicio(2);
   list.imprimir();
   list.incluir(5,4);
   list.imprimir();
   list.removerPosicao(4);
   list.imprimir();
   LS_encadeada subList = list.Sublista(1, 4);
   subList.imprimir();
   System.out.println(list.contem(9));
    }}