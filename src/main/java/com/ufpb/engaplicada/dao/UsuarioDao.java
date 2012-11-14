package com.ufpb.engaplicada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufpb.engaplicada.entity.Usuario;

@Repository("usuarioDao")
public class UsuarioDao {

	@PersistenceContext(name="sigEducaPU")
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Usuario> findAll(){
		String hql = "SELECT u from Usuario u order by u.nome";
		Query query = entityManager.createQuery(hql);
		List<Usuario> usuario = (List<Usuario>) query.getResultList();
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Usuario> findByName(String nome){
		String hql = "SELECT u from Usuario u where nome like:nome oreder by u.nome";
		Query query = entityManager.createQuery(hql);
		query.setParameter("nome", nome+"%");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		return usuarios;
	}
	
	@Transactional
	public Usuario save(Usuario usuario){
		 entityManager.persist(usuario);
		return usuario;
	}
	
	@Transactional
	public void update(Usuario usuario){
		entityManager.merge(usuario);
	}
	
	@Transactional
	public void delete(Usuario usuario){
		usuario = entityManager.find(Usuario.class, usuario.getIdUsuario());
		entityManager.remove(usuario);
	}
	
	public void setEntityManeger(EntityManager entityManeger){
		this.entityManager = entityManeger;
	}
}
