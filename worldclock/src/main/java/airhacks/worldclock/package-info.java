/**
 * World clock business component.
 *
 * <p>Capability: show the current time in named time zones, defaulting to
 * UTC, New York, Berlin and Tokyo when none are given.
 *
 * <ul>
 *   <li>boundary: {@link airhacks.worldclock.boundary.App} — CLI arguments in,
 *       one line per zone on stdout; an unknown zone reports on stderr and exits 1.</li>
 *   <li>control: {@link airhacks.worldclock.control.WorldClock} — default zone
 *       selection and time lookup.</li>
 *   <li>entity: {@link airhacks.worldclock.entity.ZoneTime} — a zone and its time.</li>
 * </ul>
 */
package airhacks.worldclock;
