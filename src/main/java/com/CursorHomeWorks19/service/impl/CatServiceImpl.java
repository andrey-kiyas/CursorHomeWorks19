package com.CursorHomeWorks19.service.impl;

import com.CursorHomeWorks19.model.Cat;
import com.CursorHomeWorks19.service.CatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatServiceImpl implements CatService {
    @Value("${cat.url}")
    private String url;

    public Cat getFact() {
        return new RestTemplate().getForObject(url, Cat.class);
    }
}
