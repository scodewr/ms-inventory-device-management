# ms-inventory-device-management

Um microsserviço para gerenciamento de dispositivos de inventário (POC utilizando o padrão de projeto Chain of Responsibility).

## O que é o Microsserviço

Este projeto é um microsserviço responsável pelo gerenciamento de dispositivos em um inventário, permitindo operações como cadastro, atualização, consulta e remoção de dispositivos. Ele faz parte de uma arquitetura de microsserviços, podendo ser integrado a outros serviços do ecossistema.

## Design de Arquitetura

- **Arquitetura baseada em microsserviços:** Cada serviço é independente, facilitando escalabilidade e manutenção.
- **Spring Boot:** Framework principal para desenvolvimento rápido e produtivo de aplicações Java.
- **Banco de dados H2:** Utilizado em memória para facilitar testes e desenvolvimento.
- **Comunicação REST:** Exposição de endpoints RESTful para integração com outros sistemas.

## Padrão de Projeto

- **Chain of Responsibility:** O microsserviço implementa o padrão Chain of Responsibility para processar requisições de forma flexível e desacoplada, permitindo que múltiplos handlers possam tratar diferentes tipos de operações ou validações sobre os dispositivos.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Como Executar

1. Clone o repositório.
2. Execute `mvn clean install`.
3. Inicie a aplicação com `mvn spring-boot:run`.
4. Acesse o console H2 em `/h2-console` para visualizar o banco em memória.

## Observações

- Este projeto é uma Prova de Conceito (POC) e pode ser expandido para uso em produção com ajustes de segurança, persistência e escalabilidade.