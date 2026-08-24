package one.digitalinnovation.gof.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class WhatsappNotificationStrategy implements NotificationStrategy {

    @Override
    public String getTipo() {
        return "WHATSAPP";
    }

    @Override
    public void enviarNotificacao(String mensagem, String destinatario) {
        System.out.println("Enviando WHATSAPP para " + destinatario + ": " + mensagem);
    }
}
