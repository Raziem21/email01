package co.develhope.email01.entities;

public class NotificationDto {

    private String contactId;
    private String title;
    private String text;

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public NotificationDto() {}

    public NotificationDto(String contactId, String title, String text) {
        this.contactId = contactId;
        this.title = title;
        this.text = text;
    }
}
