package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.DadosTecnicosDTO;
import br.unitins.topicos1.dto.DadosTecnicosResponseDTO;
import br.unitins.topicos1.model.DadosTecnicos;
import br.unitins.topicos1.repository.DadosTecnicosRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class DadosTecnicosServiceImpl implements DadosTecnicosService{

    @Inject
    DadosTecnicosRepository dadosTecnicosRepository;

    @Override
    public DadosTecnicosResponseDTO findById(Long id) {
        DadosTecnicos dadosTecnicos = dadosTecnicosRepository.findById(id);
        if (dadosTecnicos == null)
            throw new NotFoundException("Dados Tecnicos não encontrado.");
        return DadosTecnicosResponseDTO.valueOf(dadosTecnicos);
    }

    @Override
    @Transactional
    public DadosTecnicosResponseDTO create(@Valid DadosTecnicosDTO dto) {
        
        DadosTecnicos entity = new DadosTecnicos();
            entity.setCompatibilidade(dto.compatibilidade());
            entity.setTipoMola(dto.tipoMola());
            entity.setTipoAmortecedor(dto.tipoAmortecedor());
            entity.setFornecedor(dto.fornecedor());
            entity.setEmbalagem(dto.embalagem());
            entity.setPeso(dto.peso());

        dadosTecnicosRepository.persist(entity);

        return DadosTecnicosResponseDTO.valueOf(entity);

    }

    @Override
    public DadosTecnicosResponseDTO update(Long id, DadosTecnicosDTO dto) {

        DadosTecnicos entity = dadosTecnicosRepository.findById(id);

            entity.setCompatibilidade(dto.compatibilidade());
            entity.setTipoMola(dto.tipoMola());
            entity.setTipoAmortecedor(dto.tipoAmortecedor());
            entity.setFornecedor(dto.fornecedor());
            entity.setEmbalagem(dto.embalagem());
            entity.setPeso(dto.peso());

        return DadosTecnicosResponseDTO.valueOf(entity);
    }

    @Override
    public void delete(Long id) {
        dadosTecnicosRepository.deleteById(id);
    }

    @Override
    public List<DadosTecnicosResponseDTO> findByAll() {
        return dadosTecnicosRepository.listAll().stream()
            .map(DadosTecnicosResponseDTO::valueOf).toList();
    }
    
}
