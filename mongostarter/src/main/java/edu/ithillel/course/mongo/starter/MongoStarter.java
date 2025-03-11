package edu.ithillel.course.mongo.starter;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.IOException;

public class MongoStarter {
    public static void main(String[] args) throws IOException {
        MongodStarter starter = MongodStarter.getDefaultInstance();

        MongodConfig mongodConfig = MongodConfig.builder()
                .version(Version.Main.V6_0) // Change version if needed
                .net(new Net(27017, Network.localhostIsIPv6()))
                .build();

        MongodExecutable mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();

        System.out.println("MongoDB started on port 27017. Press ENTER to stop.");
        System.in.read(); // Keep running until ENTER is pressed

        mongodExecutable.stop();
    }
}
