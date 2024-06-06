package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.ItemCarrinhoDTO;
import br.unitins.topicos1.dto.OrderDTO;
import br.unitins.topicos1.dto.OrderResponseDTO;
import br.unitins.topicos1.model.ItemCarrinho;
import br.unitins.topicos1.model.Order;
import br.unitins.topicos1.model.Product;
import br.unitins.topicos1.repository.OrderRepository;
import br.unitins.topicos1.repository.ProductRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    ProductRepository productRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderResponseDTO insert(OrderDTO dto, String login) {
        Order order = new Order();
        order.setDataHora(LocalDateTime.now());

        // calculo do total do order
        Double total = 0.0;
        for (ItemCarrinhoDTO itemDto : dto.itens()) {
            total += (itemDto.preco() * itemDto.quantidade());
        }
        order.setTotalPedido(total);

        // adicionando os itens do order
        order.setItens(new ArrayList<ItemCarrinho>());
        for (ItemCarrinhoDTO itemDto : dto.itens()) {
            ItemCarrinho item = new ItemCarrinho();
            item.setPreco(itemDto.preco());
            item.setQuantidade(itemDto.quantidade());
            item.setPedido(order);
            Product product = productRepository.findById(itemDto.idProduct());
            item.setProduct(product);

            // atualizado o estoque
            product.setEstoque(product.getEstoque() - item.getQuantidade());

            order.getItens().add(item);
        }

        // buscando o usuario pelo login
        order.setUsuario(usuarioRepository.findByLogin(login));

        // salvando no banco
        orderRepository.persist(order);

        // atualizando o estoque

        return OrderResponseDTO.valueOf(order);
    }

    // @Override
    // public OrderResponseDTO findById(Long id) {
    // return OrderResponseDTO.valueOf(orderRepository.findById(id));
    // }

    // @Override
    // public OrderResponseDTO findById(Long id) {
    //     Order order = orderRepository.findById(id);
    //     if (order == null) {
    //         // Tratar o caso onde o pedido não é encontrado, talvez lançar uma exceção ou
    //         // retornar null.
    //         return null;
    //     }
    //     return OrderResponseDTO.valueOf(order);
    // }

    @Override
    @Transactional
    public OrderResponseDTO findById(Long id) {
        Order order = orderRepository.findByIdWithItems(id);
        if (order == null) {
            // Tratar o caso onde o pedido não é encontrado, talvez lançar uma exceção ou retornar null.
            return null;
        }
        return OrderResponseDTO.valueOf(order);
    }

    // @Override
    // public List<OrderResponseDTO> findByAll() {
    // return orderRepository.listAll().stream()
    // .map(e -> OrderResponseDTO.valueOf(e)).toList();
    // }

    @Override
    public List<OrderResponseDTO> findByAll() {
        return orderRepository.listAll().stream()
                .map(OrderResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    // @Override
    // public List<OrderResponseDTO> findByAll(String login) {
    // return orderRepository.find("usuario.login", login).list().stream()
    // .map(e -> OrderResponseDTO.valueOf(e)).toList();
    // }

    @Override
    public List<OrderResponseDTO> findByAll(String login) {
        return orderRepository.find("usuario.login", login).list().stream()
                .map(OrderResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    // @Override
    // public List<OrderResponseDTO> findByUserLogin(String login) {
    // List<Order> orders = orderRepository.findAll(login);
    // return orders.stream()
    // .map(OrderResponseDTO::valueOf)
    // .collect(Collectors.toList());
    // }

    @Override
    public List<OrderResponseDTO> findByUserLogin(String login) {
        return orderRepository.find("usuario.login", login).list().stream()
                .map(OrderResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    public List<Order> findByAll(Long idUsuario) {
        return orderRepository.findAll(idUsuario);
    }

    @Override
    public List<OrderResponseDTO> findByUserId(Long idUsuario) {
        return orderRepository.find("usuario.id", idUsuario).list().stream()
                .map(OrderResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    // @Override
    // public List<OrderResponseDTO> findByUserId(Long idUsuario) {
    // List<Order> orders = orderRepository.findAll(idUsuario);
    // return orders.stream()
    // .map(OrderResponseDTO::valueOf)
    // .collect(Collectors.toList());
    // }

}
