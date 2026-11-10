import airhacks.WorldClock;

import java.time.Instant;

void main() {
    var epoch = Instant.parse("2026-01-01T12:00:00Z");

    var utc = WorldClock.render("UTC", epoch);
    assert utc.startsWith("UTC") : utc;
    assert utc.contains("12:00") : utc;

    var tokyo = WorldClock.render("Asia/Tokyo", epoch);
    assert tokyo.contains("21:00") : tokyo;

    var newYork = WorldClock.render("America/New_York", epoch);
    assert newYork.contains("07:00") : newYork;

    try {
        WorldClock.render("Mars/Olympus", epoch);
        assert false : "unknown zone must be rejected";
    } catch (java.time.DateTimeException expected) {
    }
}
