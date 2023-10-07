package br.unitins.topicos1.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.modelo.Cliente;
import br.unitins.topicos1.modelo.Endereco;
import br.unitins.topicos1.modelo.ItemPedido;
import br.unitins.topicos1.modelo.Pedido;
import br.unitins.topicos1.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {
    @Inject
    PedidoRepository repository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto) {
        Pedido novoPedido = new Pedido();
        novoPedido.setCodigo(dto.codigo());
        novoPedido.setDate(dto.date());

        if (dto.itemPedido() != null &&
                !dto.itemPedido().isEmpty()) {
            novoPedido.setItemPedido(new ArrayList<ItemPedido>());
            for (ItemPedidoDTO item : dto.itemPedido()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setQuantidade(item.quantidade());
                novoPedido.getItemPedido().add(itemPedido);
            }
        }

        if (dto.Endereco() == null &&
                !dto.Endereco().isEmpty()) {
            novoPedido.setEndereco(new ArrayList<Endereco>());
            for (EnderecoDTO enderecos : dto.Endereco()) {
                Endereco endereco = new Endereco();
                endereco.setRua(enderecos.rua());
                endereco.setNumero(enderecos.numero());
                endereco.setCidade(enderecos.cidade());
                endereco.setEstado(enderecos.estado());
                endereco.setCep(enderecos.cep());
                novoPedido.getEndereco().add(endereco);
            }
        }

        if (dto.cliente() != null &&
                !dto.cliente().isEmpty()) {
            novoPedido.setCliente(new ArrayList<Cliente>());
            for (ClienteDTO clientes : dto.cliente()) {
                Cliente cliente = new Cliente();
                cliente.setNome(clientes.nome());
                cliente.setEmail(clientes.email());

                if (clientes.endereco() != null && !clientes.endereco().isEmpty()) {
                    cliente.setEndereco(new ArrayList<Endereco>());
                    for (EnderecoDTO enderecos : clientes.endereco()) {
                        Endereco endereco = new Endereco();
                        endereco.setRua(enderecos.rua());
                        endereco.setNumero(enderecos.numero());
                        endereco.setCidade(enderecos.cidade());
                        endereco.setEstado(enderecos.estado());
                        endereco.setCep(enderecos.cep());
                        cliente.getEndereco().add(endereco);
                    }
                }

                novoPedido.getCliente().add(cliente);
            }
        }

        repository.persist(novoPedido);
        return PedidoResponseDTO.valueOf(novoPedido);

    }

@Override
@Transactional
public PedidoResponseDTO update(PedidoDTO dto, Long id) {
    Pedido pedido = repository.findById(id);

    pedido.setCodigo(dto.codigo());
    pedido.setDate(dto.date());

    List<ItemPedido> itensPedido = new ArrayList<>();
    for (ItemPedidoDTO itemDTO : dto.itemPedido()) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(itemDTO.quantidade());
        itensPedido.add(itemPedido);
    }
    pedido.setItemPedido(itensPedido);

    List<Endereco> enderecos = new ArrayList<>();
    for (EnderecoDTO enderecoDTO : dto.Endereco()) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoDTO.rua());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setEstado(enderecoDTO.estado());
        endereco.setCep(enderecoDTO.cep());
        enderecos.add(endereco);
    }
    pedido.setEndereco(enderecos);

    List<Cliente> clientes = new ArrayList<>();
    for (ClienteDTO clienteDTO : dto.cliente()) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.nome());
        cliente.setEmail(clienteDTO.email());

        List<Endereco> enderecosCliente = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : clienteDTO.endereco()) {
            Endereco endereco = new Endereco();
            endereco.setRua(enderecoDTO.rua());
            endereco.setNumero(enderecoDTO.numero());
            endereco.setCidade(enderecoDTO.cidade());
            endereco.setEstado(enderecoDTO.estado());
            endereco.setCep(enderecoDTO.cep());
            enderecosCliente.add(endereco);
        }
        cliente.setEndereco(enderecosCliente);

        clientes.add(cliente);
    }
    pedido.setCliente(clientes);

    repository.persist(pedido);

    return PedidoResponseDTO.valueOf(pedido);
}


    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(repository.findById(id));
    }

    public List<PedidoResponseDTO> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo).stream()
                .map(e -> PedidoResponseDTO.valueOf(e))
                .toList();
    }
    

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

}
