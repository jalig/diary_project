import tasks.task.DailyTask;
import tasks.task.MonthlyTask;
import tasks.service.TaskService;
import tasks.api.Type;
import tasks.task.WeeklyTask;
import tasks.task.YearlyTask;

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
                LocalDate.of(2023, 2, 3).atStartOfDay(),
                "Учить стримы ");
        WeeklyTask weeklyTask = new WeeklyTask(
                "Прочитать книгу ",
                Type.PERSONAL,
                LocalDate.of(2023, 1, 5).atStartOfDay(),
                "Да прочти ты уже");
        YearlyTask yearlyTask = new YearlyTask(
                "Прочитать книгу ",
                Type.PERSONAL,
                LocalDate.of(2024, 3, 1).atStartOfDay(),
                "Да прочти ты уже");

        TaskService taskService = new TaskService();


    }
}