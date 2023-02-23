package io.github.mat3e.hello;

import io.github.mat3e.lang.Lang;
import io.github.mat3e.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class HelloService {
    final static String FALLBACK_NAME = "undefined";
    final static Lang FALLBACK_LANG = new Lang(1, "Products from fridge: ","en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }
        HelloService(LangRepository repository){
            this.repository=repository;
        }

    String prepareGreeting(String name, Integer langId) {
        langId=Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());

        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg+ " "+nameToWelcome+"!";
    }
}
