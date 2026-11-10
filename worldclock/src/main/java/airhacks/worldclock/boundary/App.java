package airhacks.worldclock.boundary;

import airhacks.worldclock.control.WorldClock;
import airhacks.worldclock.entity.ZoneTime;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class App {

    private static final DateTimeFormatter LINE =
            DateTimeFormatter.ofPattern("EEE HH:mm xxx");

    private App() {
    }

    public static String line(ZoneTime zoneTime) {
        return "%-20s %s".formatted(zoneTime.zoneId(), LINE.format(zoneTime.time()));
    }

    public static void main(String... args) {
        var zones = WorldClock.zonesOrDefault(List.of(args));
        var now = Instant.now();
        for (var zone : zones) {
            try {
                IO.println(line(WorldClock.timeIn(zone, now)));
            } catch (DateTimeException e) {
                System.err.println("unknown time zone: " + zone);
                System.exit(1);
            }
        }
    }

}
