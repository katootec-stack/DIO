package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("gof-test")
public class GofTestRestController {

    @GetMapping("/singleton")
    public ResponseEntity<Map<String, String>> testeSingleton() {
        Map<String, String> result = new HashMap<>();

        SingletonLazy lazy1 = SingletonLazy.getInstancia();
        SingletonLazy lazy2 = SingletonLazy.getInstancia();
        result.put("singleton_lazy", "lazy1 == lazy2 ? " + (lazy1 == lazy2) + " (" + lazy1 + ")");

        SingletonEager eager1 = SingletonEager.getInstancia();
        SingletonEager eager2 = SingletonEager.getInstancia();
        result.put("singleton_eager", "eager1 == eager2 ? " + (eager1 == eager2) + " (" + eager1 + ")");

        SingletonLazyHolder holder1 = SingletonLazyHolder.getInstancia();
        SingletonLazyHolder holder2 = SingletonLazyHolder.getInstancia();
        result.put("singleton_lazy_holder", "holder1 == holder2 ? " + (holder1 == holder2) + " (" + holder1 + ")");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/strategy")
    public ResponseEntity<Map<String, String>> testeStrategy() {
        Map<String, String> result = new HashMap<>();

        Robo robo = new Robo();

        robo.setComportamento(new ComportamentoNormal());
        robo.mover();
        result.put("passo_1", "Comportamento Normal ativado");

        robo.setComportamento(new ComportamentoDefensivo());
        robo.mover();
        result.put("passo_2", "Comportamento Defensivo ativado");

        robo.setComportamento(new ComportamentoAgressivo());
        robo.mover();
        result.put("passo_3", "Comportamento Agressivo ativado");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/facade")
    public ResponseEntity<Map<String, String>> testeFacade(@RequestParam(defaultValue = "Lucas") String nome,
                                                            @RequestParam(defaultValue = "01001000") String cep) {
        Facade facade = new Facade();
        facade.migrarCliente(nome, cep);

        Map<String, String> result = new HashMap<>();
        result.put("status", "Migracao realizada com sucesso via Facade Java Puro!");
        result.put("nome", nome);
        result.put("cep", cep);

        return ResponseEntity.ok(result);
    }
}
