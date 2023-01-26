package tasks.task;

import tasks.api.Task;
import tasks.api.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().getDayOfMonth()
                && localDate.isAfter(getDateTime().toLocalDate().minusDays(1));
    }
}
