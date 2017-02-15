package com.doh.api.domain.blog;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.doh.api.domain.base.AuditedEntity;

/**
 *
 */

@Entity
@Table(name = "BLOG_POST")
public class BlogPost extends AuditedEntity {

    private String title;
    private String content;

    public BlogPost() {
    }

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
            "id=" + id +
            ", createdDate=" + createdDate +
            ", createdBy=" + createdBy +
            ", updatedDate=" + updatedDate +
            ", updatedBy=" + updatedBy +
            ", version=" + version +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
