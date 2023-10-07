package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Endereco;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
      @NotBlank(message = "O campo nome não pode ser nulo.")
     private final String nome;
     @NotBlank(message = "O campo email não pode ser nulo.")
     private final String email;
     @NotBlank(message = "O campo endereco não pode ser nulo.")
     private final Endereco endereco;
     
     public ClienteDTO(String nome, String email, Endereco endereco) {
          this.nome = nome;
          this.email = email;
          this.endereco = endereco;
     }
     public String getNome() {
          return nome;
     }
     public String getEmail() {
          return email;
     }
     public Endereco getEndereco() {
          return endereco;
     }
     @Override
     public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((nome == null) ? 0 : nome.hashCode());
          result = prime * result + ((email == null) ? 0 : email.hashCode());
          result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
          return result;
     }
     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null)
               return false;
          if (getClass() != obj.getClass())
               return false;
          ClienteDTO other = (ClienteDTO) obj;
          if (nome == null) {
               if (other.nome != null)
                    return false;
          } else if (!nome.equals(other.nome))
               return false;
          if (email == null) {
               if (other.email != null)
                    return false;
          } else if (!email.equals(other.email))
               return false;
          if (endereco == null) {
               if (other.endereco != null)
                    return false;
          } else if (!endereco.equals(other.endereco))
               return false;
          return true;
     }

     

}