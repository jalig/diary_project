package tasks.api;

import tasks.exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String title;
    private String description;


    public Task(String title, Type type, LocalDateTime dateTime, String description) {
        setTitle(title);
        this.type = type;
        this.id = ++idGenerator;
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IncorrectArgumentException("Введена неверная дата");
        } else {
            this.dateTime = dateTime;
        }
        setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank() || title.isEmpty()) {
            throw new IncorrectArgumentException("Заголовок не введен", title);
        } else {
            this.title = title;
        }
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty() || description.isBlank()) {
            this.description = "Описание отсутствует";
        } else {
            this.description = description;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id
                && Objects.equals(title, task.title)
                && type == task.type
                && Objects.equals(dateTime, task.dateTime)
                && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    public abstract boolean appearsIn(LocalDate localDate);

    @Override
    public String toString() {
        return "Задача: " + title + " " +
                "Тип: " + type + " " +
                "ID - " + id + " " +
                "Дата: " + dateTime + " " +
                "Описание: " + description + "\n";
    }
}
