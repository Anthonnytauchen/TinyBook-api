package AnthonnyTauchenDev.TinyBook.controler;

import AnthonnyTauchenDev.TinyBook.dto.AgendamenteCreateRequest;
import AnthonnyTauchenDev.TinyBook.dto.AgendamentoResponse;
import AnthonnyTauchenDev.TinyBook.dto.AgendamentoUpdateRequest;
import AnthonnyTauchenDev.TinyBook.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/agendamentos")
public class AgendamentoControler {

    private final AgendamentoService service;
    @PostMapping
    public AgendamentoResponse criar(@Valid @RequestBody AgendamenteCreateRequest request){
    return service.criar(request);
    }
    @PutMapping("{id}")
    public AgendamentoResponse update(@PathVariable Long id, @Valid @RequestBody AgendamentoUpdateRequest request){
        return service.atualizar(id,request);
    }
    @PutMapping("{id}/cancelar")
    public  AgendamentoResponse cancelar (@PathVariable Long id){
        return service.cancelado(id);
    }
    @PutMapping("{id}/concluir")
    public  AgendamentoResponse concluir(@PathVariable Long id){
        return service.concluido(id);
    }
@GetMapping("{id}")
public AgendamentoResponse buscarPorId(Long id){
    return service.buscarPorId(id);
}



}
