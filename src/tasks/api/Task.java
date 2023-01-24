package tasks.api;

import tasks.exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;


    public Task(String title, Type type, LocalDateTime dateTime,String description) {
        setTitle(title);
        this.type = type;
        this.id = ++idGenerator;
        this.dateTime = dateTime;
        this.description = description;
    }
    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        if (this.title != null||!title.isBlank()||!title.isEmpty()) {
            this.title = title;
        } else {
            try {
                throw new IncorrectArgumentException("Введен неверный аргумент", title);
            } catch (IncorrectArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    public abstract boolean appearsIn(LocalDate localDate);
    @Override
    public String toString() {
        return  "Задача: " + title + " " +
                "Тип: " + type + " " +
                "ID - " + id + " " +
                "Дата: " + dateTime + " " +
                "Описание: " + description + "\n";
    }
}
