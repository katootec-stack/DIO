package one.digitalinnovation.gof.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public String getTipo() {
        return "SMS";
    }

    @Override
    public void enviarNotificacao(String mensagem, String destinatario) {
        System.out.println("Enviando SMS para " + destinatario + ": " + mensagem);
    }
}
