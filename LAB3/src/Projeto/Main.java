package Projeto;

public class Main {

    public static void main(String[] args){
        Menu menu = new Menu();
        
        boolean condicao = true;
        
        while (condicao) {
        
        	menu.exibeMenu();
        	condicao = menu.redireciona();
    	
        }
    }
}