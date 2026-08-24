package one.digitalinnovation.gof.service.strategy;

public interface NotificationStrategy {
    String getTipo();
    void enviarNotificacao(String mensagem, String destinatario);
}
