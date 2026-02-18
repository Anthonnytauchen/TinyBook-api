package AnthonnyTauchenDev.TinyBook.service;

import AnthonnyTauchenDev.TinyBook.dto.AgendamenteCreateRequest;
import AnthonnyTauchenDev.TinyBook.dto.AgendamentoResponse;
import AnthonnyTauchenDev.TinyBook.dto.AgendamentoUpdateRequest;
import AnthonnyTauchenDev.TinyBook.mapper.AgendamentoMapper;
import AnthonnyTauchenDev.TinyBook.model.Agendamento;
import AnthonnyTauchenDev.TinyBook.model.StatusAgendamento;
import AnthonnyTauchenDev.TinyBook.repositosy.AgendamentoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository repository;

    @Transactional
    public AgendamentoResponse criar(@Valid AgendamenteCreateRequest request) {

        validarIntervalor(request.dataInicio(), request.dataFim());

        checkConflito(request.dataInicio(), request.dataFim(), request.usuario(), null);

        Agendamento entity = AgendamentoMapper.toEntity(request);

        repository.save(entity);

        return AgendamentoMapper.agendamentoResponse(entity);

    }
    @Transactional
    public AgendamentoResponse atualizar(Long id, AgendamentoUpdateRequest request){

        Agendamento entity= repository.findById(id).orElseThrow(()-> new EntityExistsException("Agendamento não encontrado"));

        AgendamentoMapper.agendamentoUpdateRequest(entity,request);

        validarIntervalor(entity.getDataInicio(), entity.getDataFim());

        checkConflito(entity.getDataInicio(), entity.getDataFim(), entity.getUsuario(),entity.getId());

        repository.save(entity);

        return AgendamentoMapper.agendamentoResponse(entity);
    }

    @Transactional
    public  AgendamentoResponse cancelado(Long id){

        Agendamento entity= repository.findById(id).orElseThrow(()-> new EntityExistsException("Agendamento cancelado"));

        entity.setStatus(StatusAgendamento.CANCELADO);

        entity=repository.save(entity);

        return AgendamentoMapper.agendamentoResponse(entity);
    }

    @Transactional
    public  AgendamentoResponse concluido(Long id){

        Agendamento entity= repository.findById(id).orElseThrow(()-> new EntityExistsException("Agendamento concluido"));

        entity.setStatus(StatusAgendamento.CONCLUIDO);

        entity=repository.save(entity);

        return AgendamentoMapper.agendamentoResponse(entity);
    }

    public AgendamentoResponse buscarPorId(Long id){

        Agendamento entity= repository.findById(id).orElseThrow(()-> new EntityExistsException("Agendamento não encontrado"));

        return AgendamentoMapper.agendamentoResponse(entity);
    }

    public void deletar(Long id){

        repository.deleteById(id);

    }

    private void validarIntervalor(LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (dataInicio == null || dataFim == null || !dataInicio.isBefore(dataFim)) {
            throw new IllegalArgumentException("intervalor invalido: data de inicio deve ser anterior a data fim");
        }

    }
    private void checkConflito(LocalDateTime dataInicio, LocalDateTime dataFim, String usuario, Long id){
        if (repository.exists(usuario, dataInicio, dataFim, id)) {
            throw new IllegalArgumentException("Intervalor de agendamento conflito com outro agendamento");
        }
    }
}