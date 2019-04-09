package Projeto;

/**
 * Representação da opção de um menu
 * Toda opção deve possuir um identificador, sendo identificada unicamente por esse identificador, e um complemento de texto
 * 
 * @author Matheus Claudino
 *
 */
public class Opcao {

	/**
	 * Identificador da opcao
	 */
    private String identificador;
    
    /**
     * Complemento de texto, usado na exebição do menu
     */
    private String complemento;

    /**
     * Constrói uma opção a partir de seu identificador e de seu complemento
     *
     * @param identificador identificador da opção
     * @param complemento complemento da opção
     */
    public Opcao(String identificador, String complemento){
        this.complemento = complemento;
        this.identificador = identificador;
    }
    
    /**
     * Retorna uma String equivalente ao valor do complemento
     * 
     * @return o complemento da opção
     */
    public String getComplemento() {
    	return this.complemento;
    }

    /**
     * Verifica se uma String passada por parâmetro é igual ao identificador do objeto
     * 
     * @param obj String passada por parâmetro
     * @return valor booleano referente a afirmação: str e o identificador do objeto são iguais?
     */
    public boolean comparador(Object obj){
        String str = (String) obj;

        return str.equals(identificador);
    }
    
}