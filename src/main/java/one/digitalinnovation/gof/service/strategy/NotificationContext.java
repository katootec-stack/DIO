package one.digitalinnovation.gof.service.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class NotificationContext {

    private final Map<String, NotificationStrategy> strategies;

    public NotificationContext(List<NotificationStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        s -> s.getTipo().toUpperCase(),
                        Function.identity()
                ));
    }

    public void notificar(String tipo, String mensagem, String destinatario) {
        NotificationStrategy strategy = strategies.get(tipo.toUpperCase());
        if (strategy != null) {
            strategy.enviarNotificacao(mensagem, destinatario);
        } else {
            System.out.println("Estratégia " + tipo + " não encontrada. Notificação cancelada.");
        }
    }
}
