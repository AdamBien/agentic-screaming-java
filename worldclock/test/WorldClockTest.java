import airhacks.worldclock.boundary.App;
import airhacks.worldclock.control.WorldClock;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.List;

void main() {
    var epoch = Instant.parse("2026-01-01T12:00:00Z");

    var utc = App.line(WorldClock.timeIn("UTC", epoch));
    assert utc.startsWith("UTC") : utc;
    assert utc.contains("12:00") : utc;

    var tokyo = App.line(WorldClock.timeIn("Asia/Tokyo", epoch));
    assert tokyo.contains("21:00") : tokyo;

    var newYork = App.line(WorldClock.timeIn("America/New_York", epoch));
    assert newYork.contains("07:00") : newYork;

    try {
        WorldClock.timeIn("Mars/Olympus", epoch);
        assert false : "unknown zone must be rejected";
    } catch (DateTimeException expected) {
    }

    assert WorldClock.zonesOrDefault(List.of()).equals(WorldClock.DEFAULT_ZONES);
    assert WorldClock.zonesOrDefault(List.of("Europe/Paris")).equals(List.of("Europe/Paris"));
}
