package one.digitalinnovation.gof.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public String getTipo() {
        return "EMAIL";
    }

    @Override
    public void enviarNotificacao(String mensagem, String destinatario) {
        System.out.println("Enviando EMAIL para " + destinatario + ": " + mensagem);
    }
}
