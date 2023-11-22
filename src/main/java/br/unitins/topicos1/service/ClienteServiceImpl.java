package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.PatchSenhaDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    @Inject
    ClienteRepository repository;

    @Inject
    HashService hashService;

    @Override
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {
        Cliente novoCliente = new Cliente();

        novoCliente.setNome(dto.nome());

        novoCliente.setLogin(dto.login());

        novoCliente.setSenha(hashService.getHashSenha(dto.senha()));
       novoCliente.setPerfil(Perfil.valueOf(dto.idPerfil()));

        novoCliente.setEmail(dto.email());

        if (dto.listaEndereco() != null &&
                !dto.listaEndereco().isEmpty()) {
            novoCliente.setListaEndereco(new ArrayList<Endereco>());

            for (EnderecoDTO enderecos : dto.listaEndereco()) {
                Endereco endereco = new Endereco();

                endereco.setRua(enderecos.rua());
                endereco.setNumero(enderecos.numero());
                endereco.setCidade(enderecos.cidade());
                endereco.setEstado(enderecos.estado());
                endereco.setCep(enderecos.cep());

                novoCliente.getListaEndereco().add(endereco);
            }
        }

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {
        Cliente cliente = repository.findById(id);

        cliente.setNome(dto.nome());
        cliente.setLogin(dto.login());
        cliente.setSenha(dto.senha());

        cliente.setEmail(dto.email());

        List<Endereco> enderecos = new ArrayList<>();

        for (EnderecoDTO endereco : dto.listaEndereco()) {
            Endereco novEndereco = new Endereco();

            novEndereco.setRua(endereco.rua());
            novEndereco.setNumero(endereco.numero());
            novEndereco.setCidade(endereco.cidade());
            novEndereco.setEstado(endereco.estado());
            novEndereco.setCep(endereco.cep());
            
            enderecos.add(novEndereco);

        }
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public ClienteResponseDTO findByLoginAndSenha(String login, String senha) {
        Cliente cliente = repository.findByLoginAndSenha(login, senha);
        if (cliente == null) 
            throw new ValidationException("login", "Login ou senha inválido");
        
        return ClienteResponseDTO.valueOf(cliente);
    }
    @Override
    public ClienteResponseDTO findByLogin(String login) {
        Cliente cliente = repository.findByLogin(login);
        if (cliente == null) 
            throw new ValidationException("login", "Login inválido");
        
        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public String updateSenha(PatchSenhaDTO senha, Long id) {
        Cliente cliente = repository.findById(id);

        if(hashService.getHashSenha(senha.senhaAnterior()).equals(cliente.getSenha())){
            cliente.setSenha(hashService.getHashSenha(senha.novaSenha()));
            repository.persist(cliente);
            return "Senha alterada com êxito";
        }else{

        throw new ValidationException("updateSenha", "Favor inserir a senha antiga correta.");
    }
    }
}
