package com.comecu.todo.core.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;

/**
 * TodoItem
 *
 * @author comeCU
 * @date 2022/3/14 10:35
 */
@EqualsAndHashCode
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "todo_items")
public class TodoItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long index;

    @Column
    private String content;

    @Column
    private boolean done;

    public TodoItem(final String content) {
        this.content = content;
        this.done = false;
    }

    public void assignIndex(final long index) {
        this.index = index;
    }

    public void markDone() {
        this.done = true;
    }
}
