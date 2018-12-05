package io.pivotal.pal.tracker;

import java.util.List;

/**
 * Created by f.ajmalkhan on 12/4/2018.
 */
public interface TimeEntryRepository {


    TimeEntry create(TimeEntry timeEntry);

    TimeEntry update(long timeEntryId,TimeEntry timeEntry);

    TimeEntry find(long timeEntryId) ;

    void  delete(long timeEntryId) ;

    List<TimeEntry> list() ;
}
