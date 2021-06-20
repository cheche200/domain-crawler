package com.jcalderon.domaincrawler.controller;

import com.jcalderon.domaincrawler.service.DomainCrawlerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainCrawlerController {

    private final DomainCrawlerService domainCrawlerService;

    public DomainCrawlerController(DomainCrawlerService domainCrawlerService) {
        this.domainCrawlerService = domainCrawlerService;
    }

    @GetMapping("/lookup/{name}")
    public String lookup(@PathVariable final String name){
        domainCrawlerService.crawl(name);
        return "Domain crawler has scrapped your data";
    }
}
