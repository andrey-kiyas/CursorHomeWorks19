package com.CursorHomeWorks19.service;

import com.CursorHomeWorks19.model.Cat;
import com.CursorHomeWorks19.service.impl.CatServiceImpl;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@WireMockTest(httpPort = 8080)
@TestPropertySource(properties = "cat.url=http://localhost:8080")
public class CatServiceTest {
    @Autowired
    private CatServiceImpl catService;

    @Test
    void testCatService(WireMockRuntimeInfo runtimeInfo) {
        Cat cat = new Cat();
        cat.setFact("cat");
        cat.setLength(100);
        stubFor(get("/").willReturn(jsonResponse(cat, HttpStatus.OK.value())));
        Cat exCat = catService.getFact();
        assertEquals(cat, exCat);
    }
}
