package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.modelo.Produto;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService{

    @Inject
    ProdutoRepository repository;

    @Override
    @Transactional
    public ProdutoResponseDTO update(ProdutoDTO dto, Long id) {
        Produto produto = repository.findById(id);

        if(repository.findById(id) == null || produto.getId() == null){
            
            produto.setId(id);
            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setPreco(dto.preco());
            produto.setEstoque(dto.estoque());

            }
        
        return ProdutoResponseDTO.valueOf(produto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        return ProdutoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findByNome(String nome) {
             return null;
    }

    @Override
    public List<ProdutoResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public ProdutoResponseDTO insert(ProdutoDTO dto) {
       
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }
    
}
