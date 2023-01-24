package tasks;

import tasks.api.Task;
import tasks.api.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getMonthValue() == getDateTime().getMonthValue()
                && localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
