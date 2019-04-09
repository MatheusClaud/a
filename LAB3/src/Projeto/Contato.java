package Projeto;
/**
 * Representação de um contato de uma agenda, cada contato deve possuir nome, sobrenome e telefone obrigatóriamente
 * @author Matheus Claudino
 */
public class Contato {

	/**
	 * Nome do contato
	 * Não pode ser composto apenas por espaços e não pode ser uma string vazia
	 */
    private String nome;
    
    /**
     * Sobrenome do contato
     * Não pode ser composto apenas por espaços e não pode ser uma string vazia
     */
    private String sobrenome;
    
    /**
     * Telefone do contato
     * Não pode ser composto apenas por espaços e não pode ser uma string vazia
     */
    private String telefone;
    
    /**
     * Verifica se uma String passada por parâmetro é válida.
     * Uma String é válida se não for vazia ou composta apenas por espaços
     * 
     * @param str String à ser verificada
     * @return o valor booleano referente à afirmação: a String é válida?
     */
    public boolean checarStringValida(String str) {
    	if (str == "") {
    		return false;
    	}
    	
    	for (int i = 0; i < str.length(); i++) {
    		if (str.charAt(i) != ' ') {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    
    /**
     * Constrói um contato a partir de seu nome, sobrenome e telefone.
     * Todo atributo de contato já é inicializado com um valor passado por parâmetro
     * 
     * @param nome nome à ser atribuido no contato
     * @param sobrenome sobrenome à ser atribuido no contato
     * @param telefone telefone à ser atribuido no contato
     */
    public Contato(String nome, String sobrenome, String telefone){
    	
    	if (nome == null || sobrenome == null || telefone == null) {
    		throw new NullPointerException("Parametro nulo em cadastro de notas");
    	}
    	
    	if (!(checarStringValida(nome) && checarStringValida(sobrenome) && checarStringValida(telefone))) {
    		throw new IllegalArgumentException();
    	}
    	
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public String getNomeCompleto(){
        return nome + " " + sobrenome;
    }
    
    /**
     * Retorna um valor booleano referente à veracidade da afirmação: o presente contato é igual ao contato passado por parâmetro?
     * Dois contatos são iguais se tiverem nome e sobrenome iguais
     *  
     * @param obj Contato à ser comparado
     */
    @Override
    public boolean equals(Object obj){

        Contato contato = (Contato) obj;

        return contato.getNomeCompleto().equals(getNomeCompleto());
    }

    /**
     * Retorna à representação so objeto no formato de String
     * O formato da String retornada é: nome sobrenome - telefone
     */
    @Override
    public String toString(){
        return getNomeCompleto() + " - " + telefone;
    }
}