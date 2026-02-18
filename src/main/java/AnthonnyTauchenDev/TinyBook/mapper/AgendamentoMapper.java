package AnthonnyTauchenDev.TinyBook.mapper;

import AnthonnyTauchenDev.TinyBook.dto.AgendamenteCreateRequest;
import AnthonnyTauchenDev.TinyBook.dto.AgendamentoResponse;
import AnthonnyTauchenDev.TinyBook.dto.AgendamentoUpdateRequest;
import AnthonnyTauchenDev.TinyBook.model.Agendamento;
import AnthonnyTauchenDev.TinyBook.model.StatusAgendamento;

import java.time.LocalDateTime;

public class AgendamentoMapper {

    public static Agendamento toEntity(AgendamenteCreateRequest request){
        LocalDateTime now = LocalDateTime.now();
        return Agendamento.builder()
                .titulo(request.titulo())
                .descricao(request.descriçao())
                .dataInicio(request.dataInicio())
                .dataFim(request.dataFim())
                .usuario(request.usuario())
                .status(StatusAgendamento.AGENDADO)
                .criadoEm(now)
                .atualizadoEm(now)
                .build();
    }

    public static void agendamentoUpdateRequest(Agendamento entity, AgendamentoUpdateRequest request){
        if(request.titulo() != null){
            entity.setTitulo(request.titulo());
        }
        if (request.descriacao() != null){
            entity.setDescricao(request.descriacao());
        }
        if (request.dataInicio() != null){
            entity.setDataInicio(request.dataInicio());
        }
        if (request.dataFimn() != null){
            entity.setDataFim(request.dataFimn());
        }
    }

    public static AgendamentoResponse agendamentoResponse(Agendamento agendamento){
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getTitulo(),
                agendamento.getDescricao(),
                agendamento.getDataInicio(),
                agendamento.getDataFim(),
                agendamento.getStatus(),
                agendamento.getUsuario(),
                agendamento.getCriadoEm(),
                agendamento.getAtualizadoEm()
        );
    }

}
