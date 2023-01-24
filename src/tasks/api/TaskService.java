package tasks.api;

import tasks.exceptions.TaskNotFoundException;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();
    private static List<Task> removedTasks = new ArrayList<>();

//    public TaskService() {
//        Map<Integer, Task> taskMap = new HashMap<>();
//        List<Task> removedTasks = new ArrayList<>();
//    }

    public void add (Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task remove(int id) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            Task task = taskMap.get(id);
            taskMap.remove(id);
            removedTasks.add(task);
            return task;
        } else {
            throw new TaskNotFoundException("Пользователя не существует");
        }
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        Collection<Task> order = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().appearsIn(localDate)) {
                order.add(entry.getValue());
            }
        }
        return order;
    }
}
