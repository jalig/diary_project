import tasks.task.DailyTask;
import tasks.task.MonthlyTask;
import tasks.service.TaskService;
import tasks.api.Type;
import tasks.task.WeeklyTask;
import tasks.task.YearlyTask;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        DailyTask dailyTask = new DailyTask(
                "Выбросить мусор ",
                Type.PERSONAL,
                LocalDateTime.of(2024, 3, 1, 14,20),
                "Отсутсвует ");
        MonthlyTask monthlyTask = new MonthlyTask(
                "Выучить стримы ",
                Type.PERSONAL,
                LocalDateTime.of(2024, 3, 1, 14,20),
                "Учить стримы ");
        WeeklyTask weeklyTask = new WeeklyTask(
                "Сделать отчет  ",
                Type.WORK,
                LocalDateTime.of(2024, 3, 1, 14,20),
                "Отчет нужно предоставить на почту руководителю");
        YearlyTask yearlyTask = new YearlyTask(
                "Прочитать книгу ",
                Type.PERSONAL,
                LocalDateTime.of(2024, 3, 1, 14,20),
                "Да прочти ты уже");

        TaskService taskService = new TaskService();


    }
}