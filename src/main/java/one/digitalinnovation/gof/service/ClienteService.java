package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void inserirComNotificacao(Cliente cliente, String tipoNotificacao);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
