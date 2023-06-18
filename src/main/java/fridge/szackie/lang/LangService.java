package fridge.szackie.lang;


import java.util.List;

import static java.util.stream.Collectors.toList;


class LangService {

    private LangRepository langRepository;

    LangService() {
        this(new LangRepository());
    }

    LangService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }

    List<LangDTO> findAll() {

        return langRepository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());
    }

}
