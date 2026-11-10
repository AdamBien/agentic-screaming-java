package airhacks.worldclock.entity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public record ZoneTime(String zoneId, ZonedDateTime time) {

    public static ZoneTime at(String zoneId, Instant instant) {
        var zone = ZoneId.of(zoneId);
        return new ZoneTime(zoneId, ZonedDateTime.ofInstant(instant, zone));
    }

}
