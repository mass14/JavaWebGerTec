package br.com.calculareceita.dao;

import javax.persistence.EntityManager;

import br.com.calculareceita.entidade.Usuario;
import br.com.calculareceita.util.JpaUtil;

public class UsuarioDAO {

	private EntityManager entityManager = JpaUtil.getEntityManager();
	
	public Usuario buscaPorLogin(String email){
		return (Usuario) entityManager.createNamedQuery("UsuarioByEmail").
				setParameter("email", email).getSingleResult();
	}
}
