package be.businesstraining;


import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestCollectorsApp extends Application<Configuration> {

    private static final Logger log = LoggerFactory.getLogger(TestCollectorsApp.class);

    public static void main(String[] args) throws Exception {
        new TestCollectorsApp().run(args);
    }

    @Override
    public void run(Configuration config, Environment env) throws Exception {
        final ScheduledExecutorService scheduler =
                env.lifecycle().scheduledExecutorService("mem-gc-test").build();

        scheduler.scheduleAtFixedRate(thrasher(), 1, 1, TimeUnit.SECONDS);
    }

    private Runnable thrasher() {
        return new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                log.info("Running thrasher..");

                final List<String> messages = new ArrayList<>();

                for (int i = 0; i < 5_000_000; i++) {
                    messages.add("yoz_" + i);
                }

                log.info("Created {} messages", messages.size());

                if (++count == 60) {
                    log.info("60 runs complete - exiting");

                    System.exit(0);
                }
            }
        };
    }
}