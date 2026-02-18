package AnthonnyTauchenDev.TinyBook.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record AgendamenteCreateRequest(
        @NotBlank @Size(max=120) String titulo,
        @Size(max = 4000) String descriçao,
        @NotNull LocalDateTime dataInicio,
        @NotNull LocalDateTime dataFim,
        @NotNull @Size(max=80) String usuario

        ) { }
