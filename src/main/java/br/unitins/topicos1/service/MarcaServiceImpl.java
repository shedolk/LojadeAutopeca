package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.MarcaResponseDTO;
import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.modelo.Marca;
import br.unitins.topicos1.modelo.Produto;
import br.unitins.topicos1.repository.MarcaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService{
    
    @Inject
    MarcaRepository repository;

    @Override
    @Transactional
    public MarcaResponseDTO insert(MarcaDTO dto) {
        Marca novaMarca = new Marca();

        novaMarca.setNome(dto.nome());

        novaMarca.setDescricao(dto.descricao());

        if (dto.listaProduto() != null && 
                    !dto.listaProduto().isEmpty()){
            novaMarca.setListaProduto(new ArrayList<Produto>());

            for (ProdutoDTO prod : dto.listaProduto()) {
                Produto produto = new Produto();
                
                produto.setNome(prod.nome());
                produto.setDescricao(prod.descricao());
                produto.setPreco(prod.preco());
                produto.setEstoque(prod.estoque());

                novaMarca.getListaProduto().add(produto);
            }
        }

        repository.persist(novaMarca);

        return MarcaResponseDTO.valueOf(novaMarca);
    }
    
    @Override
    @Transactional
    public MarcaResponseDTO update(MarcaDTO dto, Long id) {
            Marca marca = repository.findById(id);

            marca.setNome(dto.nome());
            
            marca.setDescricao(dto.descricao());
    
            List<Produto> produtos = new ArrayList<>();

                for (ProdutoDTO prod : dto.listaProduto()) {
                    Produto produto = new Produto();
                    produto.setNome(prod.nome());
                    produto.setDescricao(prod.descricao());
                    produto.setPreco(prod.preco());
                    produto.setEstoque(prod.estoque());

                    produtos.add(produto);
                    
        }
        return MarcaResponseDTO.valueOf(marca);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Override
    public MarcaResponseDTO findById(Long id) {
        return MarcaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<MarcaResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> MarcaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<MarcaResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> MarcaResponseDTO.valueOf(e)).toList();
    }
}
