package AnthonnyTauchenDev.TinyBook.repositosy;

import AnthonnyTauchenDev.TinyBook.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    @Query("""
      SELECT CASE WHEN COUNT(a)>0 THEN true ELSE false END
      FROM Agendamento a
      WHERE a.usuario = :usuario
      AND a.status = AnthonnyTauchenDev.TinyBook.model.StatusAgendamento.AGENDADO
      AND (a.dataInicio < :fim AND a.dataFim >:inicio)
      AND (:ignoreId is NULL OR a.id <> :ignoreId)
      
""")
    boolean exists(
            @Param("usuario") String usuario,
            @Param("inicio") LocalDateTime dataInicio,
            @Param("fim") LocalDateTime dataFim,
            @Param("ignoreId") Long ignoreId);

}