package br.com.scodewr.inventorydevicemanagment.domain.messages;

import lombok.Getter;

@Getter
public enum IDMStatusMessages {
    IDM_101("IDM-100", "Nenhuma ação executada."),
    IDM_201("IDM-201", "Dispositivo cadastrado com sucesso.") ,
    IDM_202("IDM-202", "Dispositivo atualizado com sucesso."),
    IDM_401("IDM-401", "Parâmetros de entrada inválidos.") ,
    IDM_402("IDM-402", "Validação de Regras de negócio não atendida.") ,
    IDM_500("IDM-500", "Erro ao gerar atributo/entidade. Campo nulo não esperado."),
    IDM_501("IDM-502", "Erro de comunicação entre os serviços."),
    IDM_999("IDM-999", "Erro não mapeado.");

    private final String code;
    private final String message;

    IDMStatusMessages(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
