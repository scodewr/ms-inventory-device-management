# ms-inventory-device-management

Microsserviço para gerenciamento de inventário de dispositivos, com ênfase em desacoplamento via Arquitetura Hexagonal e orquestração de regras através do padrão Chain of Responsibility.

## Visão Geral

Este serviço provê operações para cadastro, atualização e remoção de dispositivos no inventário. O desenho aplica princípios de baixo acoplamento, testes facilitados e evolução incremental, mantendo o domínio independente de tecnologias externas.

## Arquitetura

- Estilo: Arquitetura Hexagonal (Ports & Adapters)
- Núcleo de domínio independente de framework
- Entradas: REST Controller (adapter de entrada)
- Saídas: Portas de saída para persistência e consultas
- Orquestração: Chain of Responsibility para selecionar e executar o fluxo por tipo de dispositivo

Organização de pacotes (resumo):
- domain/*: entidades, DTOs e enums do domínio (ex.: RegiterDevice, RegiterDeviceHGU, DeviceInventoryEntity, DeviceType, CharacteristicAttributes)
- application/ports: contratos de entrada/saída (ex.: UseCaseHandler)
- application/usecases: coordenação de casos de uso (ex.: DefineUseCaseAllocateHandler, RegisterDeviceUseCaseHandler)
- application/usecases/allocate: handlers específicos por tipo (ex.: RegisterDeviceHGUHandler)
- application/services: utilitários e registries (ex.: EntityExtractor, ValidationRules, AllocateHandlerRegistry)
- application/mappers: conversores entre DTOs e entidades (ex.: AllocateDeviceHGUMapper)
- infrastructure/adapters/in: controladores HTTP (ex.: DeviceController)
- infrastructure/adapters/out: adapters para portas de saída (ex.: DeviceAdapterOut, DeviceCategoryAdapterOut, DeviceModelAdapterOut)
- infrastructure/config: composição de beans e wiring (ex.: HandlerConfig)

## Padrões e Princípios

- Chain of Responsibility: seleção e encadeamento dos handlers conforme o tipo de dispositivo.
- Strategy/Registry: roteamento de handlers específicos via registro por DeviceType.
- Dependency Inversion: domínio depende de portas (interfaces), adapters implementam as portas.
- Separation of Concerns: mapeamento, validação e persistência separados por responsabilidades.

## Fluxo de Processamento (cadastro/atualização)

1) DeviceController recebe a requisição e delega para um UseCaseHandler<DeviceInventoryEntity, ?>.
2) DefineUseCaseAllocateHandler extrai do payload o tipo do dispositivo e cria o DTO do domínio correspondente.
3) RegisterDeviceUseCaseHandler aplica validações (ValidationRules) e consulta o AllocateHandlerRegistry para obter o handler específico do tipo.
4) O handler específico (ex.: RegisterDeviceHGUHandler) utiliza mapeadores e portas de saída para realizar a operação (consulta de categoria/modelo, persistência, retorno da resposta).

Esse desenho mantém o domínio isolado e permite adicionar novos tipos de dispositivos com impacto mínimo: criar DTO, mapper, handler e registrar no AllocateHandlerRegistry.

## Endpoints

- POST /device/register
  - Ação: cadastro/alocação de dispositivo.
  - Corpo: entidade de inventário contendo características (ver seção "Formato do Payload").
  - Respostas: 201 Created em caso de sucesso.

- PATCH /device/update 
  - Ação: atualização de dispositivo.
  - Corpo: entidade de inventário com as características a serem atualizadas.
  - Respostas: 200 OK em caso de sucesso.

- DELETE /device/uninstall/{deviceId}
  - Ação: remoção/desinstalação de dispositivo.
  - Parâmetros: deviceId no path.
  - Respostas: 410 Gone em caso de sucesso.

### Formato do Payload (resumo)

O corpo trafega características do dispositivo baseadas em chaves do enum CharacteristicAttributes, em especial:
- TYPE: tipo do dispositivo (ex.: HGU)
- CATEGORY: nome da categoria do dispositivo
- MODEL: nome do modelo do dispositivo
- ID: identificador do dispositivo (quando aplicável)

Observação: o formato detalhado do payload é extraído em EntityExtractor e consumido pelos handlers conforme o tipo. Ajustes podem ser necessários conforme a evolução dos DTOs.

## Execução Local

Pré-requisitos:
- Java 21+
- Maven 3.9+

Passos:
1. Compilar e empacotar:
   - mvn clean install
2. Executar a aplicação:
   - mvn spring-boot:run
3. Console H2 (opcional):
   - /h2-console

## Testes

- Testes unitários e de integração podem ser adicionados para cada handler e mapper, garantindo a cobertura do fluxo por tipo de dispositivo.
- O design atual facilita a criação de testes isolados do framework, dado o uso de portas e mapeadores como dependências explícitas.

## Decisões de Design

- Mappers não são anotados com estereótipos do framework: são POJOs, instanciados e conectados na camada de infraestrutura (configuração), preservando a independência do domínio.
- Roteamento por DeviceType via AllocateHandlerRegistry: evita condicionais dispersas e facilita a inclusão de novos tipos.
- Handlers recebem portas de saída e mappers por injeção de dependência, permitindo substituição em testes e manutenção do baixo acoplamento.

## Roadmap

- Inclusão de novos tipos de dispositivos (ex.: REPEATER, STB) com seus respectivos DTOs, mappers e handlers.
- Respostas de API mais ricas (payloads de retorno padronizados).
- Customizar as descrições na documentação gerada automaticamente com Springdoc OpenAPI (Swagger).
- Validações adicionais e regras específicas por categoria/modelo.
- Observabilidade (logs estruturados, métricas e tracing).
- Estratégias de persistência e cache para ambientes produtivos.
- Tratativa de vulnerabilidades presentes em dependências do framework.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Versionamento Semântico

Este projeto segue o Versionamento Semântico (SemVer), no formato MAJOR.MINOR.PATCH:
- MAJOR: mudanças incompatíveis.
- MINOR: novas funcionalidades compatíveis.
- PATCH: correções e melhorias.

Versão atual: 1.1.0
