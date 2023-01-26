package tasks.task;

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
                && localDate.getDayOfMonth() == getDateTime().getDayOfMonth()
                && localDate.isAfter(getDateTime().toLocalDate().minusDays(1));
    }
}


































//    int dayOfYear1 = localDate.getDayOfYear();
//    int dayOfYear2 = getDateTime().getDayOfYear();
//
//        if (localDate.isLeapYear() && localDate.getMonthValue() > 2) {
//                dayOfYear1 -= 1;
//                }
//                if (getDateTime().toLocalDate().isLeapYear() && getDateTime().toLocalDate().getMonthValue() > 2) {
//                dayOfYear2 -= 1;
//                }
//                return dayOfYear1 == dayOfYear2
//                && localDate.isAfter(getDateTime().toLocalDate().minusDays(1));