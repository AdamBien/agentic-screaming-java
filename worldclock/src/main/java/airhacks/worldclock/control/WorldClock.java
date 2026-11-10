package airhacks.worldclock.control;

import airhacks.worldclock.entity.ZoneTime;

import java.time.Instant;
import java.util.List;

public final class WorldClock {

    public static final List<String> DEFAULT_ZONES = List.of(
            "UTC", "America/New_York", "Europe/Berlin", "Asia/Tokyo");

    private WorldClock() {
    }

    public static List<String> zonesOrDefault(List<String> requested) {
        return requested.isEmpty() ? DEFAULT_ZONES : requested;
    }

    public static ZoneTime timeIn(String zoneId, Instant now) {
        return ZoneTime.at(zoneId, now);
    }

}
