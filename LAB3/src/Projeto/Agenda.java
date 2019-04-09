package Projeto;

/**
 * Representação de uma agenda de contatos
 * Toda agenda possui uma lista de contatos
 * 
 * @author Matheus Claudino
 *
 */
public class Agenda {

	/**
	 * Lista de contatos 
	 */
    private Contato[] contatos;
    
    /**
     * Quantidade de contatos criados
     */
    private int contatosCriados;

    /**
     * Contrói uma agenda
     * A lista de contatos é inicializada com 101 posições com todas posições com valores nulos
     * Inicializa a quantidade de contatos criados com 0
     */
    public Agenda() {
    	contatosCriados = 0;
    	contatos = new Contato[101];
    }
    
    /**
     * Cadastra um contato na lista de contatos a partir do indice da lista à ser utilizado e a partir das informçaões do contato à ser cadastrado
     * Os indices válidos devem ser qualquer numero a partir de 1 até 100
     *  
     * @param indice indice da lista a ser utulizado no cadastro
     * @param nome nome do contato à ser cadastrado
     * @param sobrenome sobrenome do contato à ser cadastrado
     * @param telefone telefone do contato à ser cadastrado
     */
    public void cadastraContato(int indice, String nome, String sobrenome, String telefone){	
        contatos[indice] = new Contato(nome, sobrenome, telefone);
        contatosCriados++;

    }
    
    /**
     * Retorna um contato, a parir de um idice informado por parâmetro que indentifica o contato da lista de contatos à ser retornado
     * Os indices válidos devem ser qualquer numero a partir de 1 até 100
     * 
     * @param indice indice do contato a ser retornado
     * @return contato do indice informado, caso o indice seja válido
     */
    public Contato getContatos(int  indice) {
    	return contatos[indice];
    }

    /** 
     * Retorna uma array de Strings, onde cada indice deste array representa cada um dos contatos já cadastrados
     * Cada indice do array obedesce o seguinte formato: indice - nome sobrenome
     * O numero de indices dessa array será igual ao numero de contatos cadastrados
     * Caso o número de contatos cadastrados seja 0 será retornado uma array de um indice com uma string vazia
     * 
     * @return lista das informações de contatos já cadastrados
     */
    public String[] getListaContatos(){

    	
    	if (contatosCriados == 0) { 
    		String[] str = {""};
    		return str;
    	}
    	
    	String[] str = new String[contatosCriados];
    	
    	int indice = 0;
        for (int i = 1; i < contatos.length; i++){
        	if (contatos[i] != null){
            	str[indice] = i + " - " + contatos[i].getNomeCompleto();
            	++indice;
            }
        }

        return str;
    }

    /**
     * Retorna a representação em String de um contato da lista, a partir so indice do contato passado por parâmetro
     * 
     * @param indice indice so contato à ser processado
     * @return representação em String do contato
     */
    public String getContato(int indice){
        return contatos[indice].toString();
    }

    /**
     * Verifica se um indice é válido
     * Um indice é válido se e somente se variar entre 1 e 100
     * 
     * @param indice indice à ser verificado
     * @return valor booleano referente à veracidade da afirmação: o indice é válido?
     */
    public boolean indiceValido(int indice){
        return (indice >= 1 && indice <= 100);
    }
    
    /**
     * Retorna um valor booleano referente à veracidade da afirmação: a presente agenda é igual à agenda passado por parâmetro?
     * Duas agendas são iguais se tiverem sua lista de contatos iguais
     *  
     * @param obj Agenda à ser comparada
     */
    @Override
    public boolean equals(Object obg) {
    	Agenda agenda = (Agenda) obg;
    	
    	
    	for (int i = 1; i < agenda.contatos.length; i++) {
    		if (agenda.contatos[i] == null || this.contatos[i] == null) {
    			if (!(agenda.contatos[i] == null && this.contatos[i] == null)) return false ;
    		}
    		else if(!agenda.contatos[i].equals(this.contatos[i])) return false;
    	}
    	
    	return true;
    	
    }


}