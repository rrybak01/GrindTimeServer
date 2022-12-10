package com.grindServer.grindServer.usuario;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findUsuarioById(id);
	}

	public void addNewUsuario(Usuario usuario) {
		Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
		if (usuarioByEmail.isPresent()) {
			throw new IllegalStateException("Email ya registrado");
		} else {
			usuarioRepository.save(usuario);
		}
		System.out.println(usuario);
	}

	public void deleteUsuario(Long idUsuario) {
		boolean exists = usuarioRepository.existsById(idUsuario);
		if (!exists) {
			throw new IllegalStateException("Usuario con id " + idUsuario + ", no existe");
		} else {
			usuarioRepository.deleteById(idUsuario);
		}
	}

	@Transactional
	public void updateUsuario(Long idUsuario, String nombre, String email) {

		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new IllegalStateException("Usuario con id " + idUsuario + ", no existe"));

		if (nombre != null &&
				nombre.length() > 0 &&
				!Objects.equals(usuario.getNombre(), nombre)) {
			usuario.setNombre(nombre);
		}

		if (email != null &&
				email.length() > 0 &&
				!Objects.equals(usuario.getEmail(), email)) {

			Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
			if (usuarioByEmail.isPresent()) {
				throw new IllegalStateException("Email ya registrado");
			} else {
				usuario.setEmail(email);
			}

		}

	}

}
