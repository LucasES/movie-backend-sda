package br.com.sda.service;

public interface ISecurityService {

	/**
	 * Realiza a busca no contexto do security para buscar o username do usu[ario logado.
	 * 
	 * @return String com login do usuario
	 */
	public String findLoggedInUsername();

    /**
     * Método para realizar o auto login do usuário
     * 
     * @param username
     * @param password
     */
    public void autologin(String username, String password);
}
