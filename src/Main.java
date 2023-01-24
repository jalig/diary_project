import tasks.DailyTask;
import tasks.MonthlyTask;
import tasks.WeeklyTask;
import tasks.api.TaskService;
import tasks.api.Type;
import tasks.exceptions.TaskNotFoundException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DailyTask dailyTask = new DailyTask(
                "Выбросить мусор ",
                Type.PERSONAL,
                LocalDate.of(2023, 1, 3).atStartOfDay(),
                "Отсутсвует ");
        MonthlyTask monthlyTask = new MonthlyTask(
                "Выучить стримы ",
                Type.PERSONAL,
                LocalDate.of(2023, 1, 3).atStartOfDay(),
                "Учить стримы ");
        WeeklyTask weeklyTask = new WeeklyTask(
                "Прочитать книгу ",
                Type.PERSONAL,
                LocalDate.of(2023, 1, 5).atStartOfDay(),
                "Да прочти ты уже");

        TaskService taskService = new TaskService();
        taskService.add(dailyTask);
        taskService.add(monthlyTask);
        taskService.add(weeklyTask);
        try {
            taskService.remove(2);
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(taskService.getAllByDate(LocalDate.of(2023, 1, 3)));
    }
}