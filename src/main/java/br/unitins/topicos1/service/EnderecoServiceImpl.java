package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.EnderecoResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.repository.EnderecoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public EnderecoResponseDTO insert(@Valid EnderecoDTO dto) {
        Endereco novoEndereco = new Endereco();
        novoEndereco.setRua(dto.rua());
        novoEndereco.setNumero(dto.numero());
        novoEndereco.setCidade(dto.cidade());
        novoEndereco.setEstado(dto.estado());
        novoEndereco.setCep(dto.cep());

        enderecoRepository.persist(novoEndereco);

        return EnderecoResponseDTO.valueOf(novoEndereco);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO update(Long id, EnderecoDTO dto) {
        Endereco endereco = enderecoRepository.findById(id);

        if (enderecoRepository.findById(id) == null || endereco.getId() == null) {
            endereco.setId(id);
            endereco.setRua(dto.rua());
            endereco.setNumero(dto.numero());
            endereco.setCidade(dto.cidade());
            endereco.setEstado(dto.estado());
            endereco.setCep(dto.cep());
        }

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!enderecoRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        return EnderecoResponseDTO.valueOf(enderecoRepository.findById(id));
    }

    @Override
    public List<EnderecoResponseDTO> findByAll() {
        return enderecoRepository.listAll().stream()
                .map(e -> EnderecoResponseDTO.valueOf(e)).toList();
    }

}
