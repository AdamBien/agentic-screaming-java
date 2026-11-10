package airhacks;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.List;

public interface App {

    static void main(String... args) {
        var zones = args.length == 0 ? WorldClock.DEFAULT_ZONES : List.of(args);
        var now = Instant.now();
        for (var zone : zones) {
            try {
                IO.println(WorldClock.render(zone, now));
            } catch (DateTimeException e) {
                System.err.println("unknown time zone: " + zone);
                System.exit(1);
            }
        }
    }

}
