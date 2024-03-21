package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.PagamentoDTO;
import br.unitins.topicos1.dto.PagamentoResponseDTO;
import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.repository.PagamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Inject
    PagamentoRepository pagamentoRepository;

    @Override
    @Transactional
    public PagamentoResponseDTO insert(PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(dto.momento());
        pagamento.setFormaPagamento(FormaPagamento.valueOf(dto.formaPagamento_id()));
        pagamentoRepository.persist(pagamento);
        return PagamentoResponseDTO.valueOf(pagamento);
    }

    @Override
    @Transactional
    public PagamentoResponseDTO update(Long id, PagamentoDTO dto) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento == null) {
            // Aqui você pode lançar uma exceção de acordo com suas necessidades
            return null;
        }
        pagamento.setMomento(dto.momento());
        pagamento.setFormaPagamento(FormaPagamento.valueOf(dto.formaPagamento_id()));
        pagamentoRepository.persist(pagamento);
        return PagamentoResponseDTO.valueOf(pagamento);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento != null) {
            pagamentoRepository.delete(pagamento);
        }
    }

    @Override
    public PagamentoResponseDTO findById(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id);
        if (pagamento != null) {
            return PagamentoResponseDTO.valueOf(pagamento);
        }
        return null;
    }

    @Override
    public List<PagamentoResponseDTO> findByAll() {
        List<Pagamento> pagamentos = pagamentoRepository.listAll();
        List<PagamentoResponseDTO> responseDTOs = new ArrayList<>();
        for (Pagamento pagamento : pagamentos) {
            responseDTOs.add(PagamentoResponseDTO.valueOf(pagamento));
        }
        return responseDTOs;
    }
}
