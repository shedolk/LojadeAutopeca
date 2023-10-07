package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.modelo.Endereco;
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
        novoCliente.setNome(dto.nome());
        novoCliente.setEmail(dto.email());

        if (dto.endereco() != null &&
                !dto.endereco().isEmpty()) {
            novoCliente.setEndereco(new ArrayList<Endereco>());
            for (EnderecoDTO enderecos : dto.endereco()) {
                Endereco endereco = new Endereco();
                endereco.setRua(enderecos.rua());
                endereco.setNumero(enderecos.numero());
                endereco.setCidade(enderecos.cidade());
                endereco.setEstado(enderecos.estado());
                endereco.setCep(enderecos.cep());
                novoCliente.getEndereco().add(endereco);
            }
        }

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }

    @Override
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());

        List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO endereco : dto.endereco()) {
            Endereco novEndereco = new Endereco();
            novEndereco.setRua(endereco.rua());
            novEndereco.setNumero(endereco.numero());
            novEndereco.setCidade(endereco.cidade());
            novEndereco.setEstado(endereco.estado());
            novEndereco.setCep(endereco.cep());
            enderecos.add(novEndereco);

        }

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
