package r.gabaglia.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r.gabaglia.cursomc.domain.Cliente;
import r.gabaglia.cursomc.repositories.ClienteRepository;
import r.gabaglia.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}