package Projeto;


import java.util.Scanner;

/**
 * Representação de um menu de opções, referente a manipulção de caracteristícas da classe Agenda
 * Toda operação de leitura ou escrita é feita dentro desta classe
 * 
 * @author Matheus Claudino
 *
 */
public class Menu {

	/**
	 * Scanner usado para ler informações do usuário
	 */
    Scanner s = new Scanner(System.in);
    
    /**
     * Array de opcoes de ações do menu
     */
    private Opcao[] opcao;
    
    /**
     * Agenda de contatos do qual o menu vai manipular
     */
    private Agenda agenda;
    
    /**
     * Mensagem quando o usuário escolhe uma opção inválida
     */
    private String invalido;

    /**
     * Constrói um menu, inicializando as opções com valores padrões
     * Inicializa a agenda e a mensagem para opções inválidas
     */
    public Menu(){
        opcao = new Opcao[4];

        opcao[0] = new Opcao("C", "(C)adastrar Contato");
        opcao[1] = new Opcao("L", "(L)istar Contatos");
        opcao[2] = new Opcao("E", "(E)xibir Contato");
        opcao[3] = new Opcao("S", "(S)air");

        agenda = new Agenda();
        
        invalido = "OP��O INV�LIDA!";
    }
    
    /**
     * Verifica se uma String passado por parâmetro esta dentre as opções do menu
     * 
     * @param opcao opcao a ser verificada
     * @return retorna valor booleano referente à afirmação: a opcao passada por parametro esta é válida?
     */
    public boolean eOpcao(String opcao){

        for (int i = 0; i < this.opcao.length; i++){
            if (this.opcao[i].comparador(opcao)) return true;
        }

        return false;
    }
    
    /**
     * Exibe o menu de opcoes
     */
    public void exibeMenu(){
    	for (int i = 0; i < opcao.length; i++) {
    		System.out.println(opcao[i].getComplemento());
    	}
    	System.out.print("\nOp��o> ");
    	
    }

    /**
     * Inicia o processo de cadastro, sendo a interface com o usuário
     */
    private void iniciaProcessoCadastro(){
    	
    	int indice;
        System.out.print("\nPosi��o: ");

        indice = s.nextInt();
        if (!agenda.indiceValido(indice)){
            System.out.println(invalido);
            return;
        }

        System.out.print("Nome: ");
        String nome = s.next();
        
        System.out.print("Sobrenome: ");
        String sobrenome = s.next();

        System.out.print("Telefone: ");
        String telefone = s.next();

        agenda.cadastraContato(indice, nome, sobrenome, telefone);

        System.out.println("CADASTRO REALIZADO!\n");
        
    }
    /**
     * Inicia o processo de listagem de contatos cadastrados, sendo a interface com o usuário
     */
    private void iniciaProcessoListagem(){
    	
    	String[] str =  agenda.getListaContatos();
        
        for (int i = 0; i < str.length; i++){
            System.out.print("\n"+str[i]);
        }
        System.out.println("\n");
        
    }
    
    /**
     * Inicia o processo exibir contatos já cadastrados, sendo a interface com o usuário
     */
    private void iniciaProcessoExibeContato(){
    	int indice;
    	System.out.print("Contato> ");

        indice = s.nextInt();
        if (!agenda.indiceValido(indice)){
        	System.out.println("POSI��O INV�LIDA!");
        	return;
        }

        System.out.println("\n"+agenda.getContato(indice)+"\n");
    }
    
    /**
     * Encerra a execução do menu
     */
    private void iniciaProcessoFechamento(){
    	s.close();
    }

    /**
     * Direciona as próximas ações a serem executadas de acordo com a escolha do usuário onde o usuário
     * 
     * @return retorna valor referente à afirmação booleana: deve-se continuar a executar o direcionamento?
     */
    public boolean redireciona(){
    	
    	String opcao = s.next();
    	
    	if (!eOpcao(opcao)){
    		System.out.println(invalido+"\n");
    		return true;
    	}

        switch (opcao){
            case "C":
                iniciaProcessoCadastro();
                return true;

            case "L":
                iniciaProcessoListagem();
                return true;

            case "E":
                iniciaProcessoExibeContato();
                return true;

            case "S":
            	iniciaProcessoFechamento();
                return false;
        }

        return true;


    }


}