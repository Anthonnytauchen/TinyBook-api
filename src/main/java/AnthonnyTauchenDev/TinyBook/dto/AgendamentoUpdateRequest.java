package AnthonnyTauchenDev.TinyBook.dto;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AgendamentoUpdateRequest(
        @Size(max=120) String titulo,
        String descriacao,
        LocalDateTime dataInicio,
        LocalDateTime dataFimn
) {
}
