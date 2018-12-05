package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by f.ajmalkhan on 12/4/2018.
 */

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PutMapping("/add")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/timeentry/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        return new ResponseEntity<>(timeEntryRepository.find(timeEntryId), HttpStatus.OK);
    }

    @GetMapping("/timeentries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id")  long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry =  timeEntryRepository.update(timeEntryId,expected);
        return new ResponseEntity<>(timeEntry, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")  long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
