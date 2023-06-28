# CadastroPOO - Projeto de Cadastro utilizando Programação Orientada a Objetos
[Clique aqui para baixar o arquivo PDF](Procedimento1.pdf)

Este projeto é um sistema de cadastro implementado em Java utilizando conceitos de Programação Orientada a Objetos (POO). Ele permite o cadastro e gerenciamento de pessoas físicas e jurídicas, utilizando classes, herança, interfaces e persistência em arquivos.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- `CadastroPOO.java`: classe principal que contém o método `main` e interage com o usuário através do console.
- Pacote `model`:
  - `Pessoa.java`: classe abstrata que representa uma pessoa, com os atributos `id` e `nome`, e métodos para exibição e manipulação desses dados.
  - `PessoaFisica.java`: classe que herda de `Pessoa` e adiciona os atributos `cpf` e `idade`, além de métodos específicos.
  - `PessoaJuridica.java`: classe que herda de `Pessoa` e adiciona o atributo `cnpj`, além de métodos específicos.
  - `PessoaFisicaRepo.java`: classe de gerenciamento para entidades de pessoa física, com métodos para inserir, alterar, excluir e obter dados, além de persistência e recuperação em arquivos.
  - `PessoaJuridicaRepo.java`: classe de gerenciamento para entidades de pessoa jurídica, com métodos para inserir, alterar, excluir e obter dados, além de persistência e recuperação em arquivos.
  
## Utilização do Projeto

O projeto oferece um menu interativo para o usuário, com as seguintes opções:

1. Incluir: permite incluir uma nova pessoa física ou jurídica.
2. Alterar: permite alterar os dados de uma pessoa física ou jurídica existente.
3. Excluir: permite excluir uma pessoa física ou jurídica existente.
4. Exibir por ID: exibe os dados de uma pessoa física ou jurídica pelo seu ID.
5. Exibir todos: exibe os dados de todas as pessoas físicas ou jurídicas cadastradas.
6. Salvar dados: realiza a persistência dos dados em arquivos.
7. Recuperar dados: recupera os dados salvos anteriormente.
0. Sair: finaliza a execução do sistema.

Ao selecionar uma opção, o sistema solicita os dados necessários e realiza a operação correspondente. As opções 6 e 7 permitem especificar um prefixo para os nomes dos arquivos de persistência.

## Considerações Finais

O projeto "CadastroPOO" é um exemplo de implementação de um sistema de cadastro utilizando conceitos de Programação Orientada a Objetos. Ele demonstra a utilização de classes, herança, interfaces e persistência de dados em arquivos. Sinta-se à vontade para explorar o código e realizar modificações para adaptá-lo às suas necessidades ou expandir suas funcionalidades.
