package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    @Inject
    ClienteRepository repository;

    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setEndereco(dto.getEndereco());

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }
    
    @Override
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());

         return ClienteResponseDTO.valueOf(cliente);

    }

    @Override
    public void delete(Long id) {
       if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
       return ClienteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }
}
