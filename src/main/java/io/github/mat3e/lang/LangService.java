package io.github.mat3e.lang;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


class LangService {

    private LangRepository langRepository;

    LangService(){
        this(new LangRepository());
    }
    LangService(LangRepository langRepository){
        this.langRepository=langRepository;
    }

    List<LangDTO> findAll(){

        return langRepository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());
    }

}
