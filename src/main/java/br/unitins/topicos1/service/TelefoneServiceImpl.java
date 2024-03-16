package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.TelefoneRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    @Inject
    TelefoneRepository telefoneRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public TelefoneResponseDTO insert(TelefoneDTO dto, Long idUsuario) {
        Telefone novoTelefone = new Telefone();
        novoTelefone.setCodigoArea(dto.codigoArea());
        novoTelefone.setNumero(dto.numero());
        novoTelefone.setUsuario(usuarioRepository.findById(idUsuario));

        telefoneRepository.persist(novoTelefone);

        return TelefoneResponseDTO.valueOf(novoTelefone);
    }

    @Override
    @Transactional
    public TelefoneResponseDTO update(Long id, TelefoneDTO dto) {
        Telefone telefone = telefoneRepository.findById(id);

        telefone.setCodigoArea(dto.codigoArea());
        telefone.setNumero(dto.numero());

        return TelefoneResponseDTO.valueOf(telefone);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!telefoneRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public TelefoneResponseDTO findById(Long id) {
        return TelefoneResponseDTO.valueOf(telefoneRepository.findById(id));
    }

    @Override
    public List<TelefoneResponseDTO> findByAll() {
        return telefoneRepository.listAll().stream()
                .map(e -> TelefoneResponseDTO.valueOf(e)).toList();
    }

}
