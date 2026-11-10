package airhacks;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class WorldClock {

    public static final List<String> DEFAULT_ZONES = List.of(
            "UTC", "America/New_York", "Europe/Berlin", "Asia/Tokyo");

    private static final DateTimeFormatter LINE =
            DateTimeFormatter.ofPattern("EEE HH:mm xxx");

    private WorldClock() {
    }

    public static String render(String zoneId, Instant instant) {
        var zone = ZoneId.of(zoneId);
        var time = ZonedDateTime.ofInstant(instant, zone);
        return "%-20s %s".formatted(zoneId, LINE.format(time));
    }

}
