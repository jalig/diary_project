package tasks.service;

import tasks.api.Task;
import tasks.exception.TaskNotFoundException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private final Map<Integer, Task> taskMap;
    private final List<Task> removedTasks;

    public TaskService() {
        taskMap = new HashMap<>();
        removedTasks = new ArrayList<>();
    }

    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException();
        }
        taskMap.put(task.getId(), task);
    }

    public Task upgradeDescription(int id, String description) throws TaskNotFoundException {
        Task task;
        if (taskMap.values().stream().anyMatch(t -> t.getId() == id)) {
            taskMap.get(id).setDescription(description);
            task = taskMap.get(id);
        } else {
            throw new TaskNotFoundException("Задачи с таким ID не существует");
        }
        return task;
    }

    public Collection<Task> getRemovedTasks() {
        return Collections.unmodifiableList(removedTasks);
    }

    public Task remove(int id) throws TaskNotFoundException {
        Task task = taskMap.remove(id);
        if (task != null) {
            removedTasks.add(task);
            return task;
        } else {
            throw new TaskNotFoundException("Нет задач для удаления");
        }
    }

    public Map<LocalDate, List<Task>> getAllGroupByDate() {
        return taskMap.values().stream()
                .collect(Collectors.groupingBy(task -> task.getDateTime().toLocalDate()));
    }

    public Task upgradeTitle(int id, String title) throws TaskNotFoundException {
        Task task;
        if (taskMap.values().stream().anyMatch(t -> t.getId() == id)) {
            taskMap.get(id).setTitle(title);
            task = taskMap.get(id);
        } else {
            throw new TaskNotFoundException("Задачи с таким ID не существует");
        }
        return task;
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskMap.values()
                .stream()
                .filter(task -> task.appearsIn(localDate))
                .collect(Collectors.toList());
    }
}
