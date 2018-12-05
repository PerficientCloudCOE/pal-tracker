package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by f.ajmalkhan on 12/4/2018.
 */
public class InMemoryTimeEntryRepository  implements  TimeEntryRepository{

    HashMap<Long, TimeEntry> timeSheets = new HashMap<>();
    private static long timeEntryCounter;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntryCounter++);
        timeSheets.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        return timeSheets.put(timeEntryId, timeEntry);
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeSheets.get(timeEntryId);
    }

    @Override
    public void delete(long timeEntryId) {
        timeSheets.remove(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeSheets.values());
    }
}
