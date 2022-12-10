package ru.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class OrderDto {
    private long id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime craeteDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime declineDate;

       public OrderDto(long id, String title, LocalDateTime craeteDate, LocalDateTime declineDate) {
        this.id = id;
        this.title = title;
        this.craeteDate = craeteDate;
        this.declineDate = declineDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCraeteDate() {
        return craeteDate;
    }

    public void setCraeteDate(LocalDateTime craeteDate) {
        this.craeteDate = craeteDate;
    }

    public LocalDateTime getDeclineDate() {
        return declineDate;
    }

    public void setDeclineDate(LocalDateTime declineDate) {
        this.declineDate = declineDate;
    }
}
