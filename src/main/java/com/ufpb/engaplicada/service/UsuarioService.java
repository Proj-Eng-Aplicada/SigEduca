package com.ufpb.engaplicada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.engaplicada.dao.UsuarioDao;
import com.ufpb.engaplicada.entity.Usuario;

@Service("usuarioService")
public class UsuarioService {
	@Autowired
	private UsuarioDao dao;
	
	public List<Usuario> getAllUsuarios(){
		return dao.findAll();
	}
	
	public List<Usuario> getUsuarioByNome(String nome){
		return dao.findByName(nome);
	}
	
	public Usuario createUsuario(Usuario usuario){
		return dao.save(usuario);
	}
	
	public void updateUsuario(Usuario usuario){
		dao.update(usuario);
	}
	
	public void deleteUsuario(Usuario usuario){
		dao.delete(usuario);
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
	
	
	
}
