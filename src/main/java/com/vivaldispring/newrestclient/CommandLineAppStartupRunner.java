package com.vivaldispring.newrestclient;

import com.vivaldispring.newrestclient.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger LOG =
            LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
    private final RestService restService;

    public CommandLineAppStartupRunner(RestService restService) {
        this.restService = restService;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Calling new RestClient");
        restService.setRestClient();
    }
}
