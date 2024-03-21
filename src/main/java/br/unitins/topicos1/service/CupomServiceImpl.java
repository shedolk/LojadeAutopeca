package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.dto.CupomResponseDTO;
import br.unitins.topicos1.model.Cupom;
import br.unitins.topicos1.repository.CupomRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

    @Inject
    CupomRepository cupomRepository;

    @Override
    @Transactional
    public CupomResponseDTO insert(CupomDTO dto) {
        Cupom novoCupom = new Cupom();
        novoCupom.setNomeCupom(dto.nomeCupom());
        novoCupom.setDataAplicada(dto.dataAplicada());
        novoCupom.setDesconto(dto.desconto());

        cupomRepository.persist(novoCupom);

        return CupomResponseDTO.valueOf(novoCupom);
    }

    @Override
    @Transactional
    public CupomResponseDTO update(Long id, CupomDTO dto) {
        Cupom cupom = cupomRepository.findById(id);

        if (cupom == null) {
            throw new NotFoundException("Cupom não encontrado");
        }

        cupom.setNomeCupom(dto.nomeCupom());
        cupom.setDataAplicada(dto.dataAplicada());
        cupom.setDesconto(dto.desconto());

        return CupomResponseDTO.valueOf(cupom);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!cupomRepository.deleteById(id)) {
            throw new NotFoundException("Cupom não encontrado");
        }
    }

    @Override
    public CupomResponseDTO findById(Long id) {
        Cupom cupom = cupomRepository.findById(id);
        if (cupom == null) {
            throw new NotFoundException("Cupom não encontrado");
        }
        return CupomResponseDTO.valueOf(cupom);
    }

    @Override
    public List<CupomResponseDTO> findByAll() {
        return cupomRepository.listAll().stream()
                .map(CupomResponseDTO::valueOf)
                .toList();
    }

}
