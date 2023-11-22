package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.CupomResponseDTO;
import br.unitins.topicos1.model.Cupom;
import br.unitins.topicos1.repository.CupomRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CupomServiceImpl implements CupomService{

    @Inject
    CupomRepository repository;

    @Override
    @Transactional
    public CupomResponseDTO insert(CupomDTO dto) {
        Cupom novoCupom = new Cupom();

        novoCupom.setCodigo(dto.codigo());

        repository.persist(novoCupom);

        return CupomResponseDTO.valueOf(novoCupom);
    }

    @Override
    @Transactional
    public CupomResponseDTO update(CupomDTO dto, Long id) {
            Cupom cupom = repository.findById(id);

            cupom.setCodigo(dto.codigo());
            
        return CupomResponseDTO.valueOf(cupom);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Transactional
    public CupomResponseDTO findById(Long id) {
        return CupomResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<CupomResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> CupomResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CupomResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> CupomResponseDTO.valueOf(e)).toList();
    }
    
}
