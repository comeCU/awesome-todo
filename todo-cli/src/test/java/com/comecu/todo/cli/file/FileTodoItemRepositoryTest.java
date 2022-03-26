package com.comecu.todo.cli.file;

import com.comecu.todo.core.domain.TodoItem;
import com.google.common.collect.Iterables;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * FileTodoItemRepositoryTest
 *
 * @author comeCU
 * @date 2022/3/18 10:52
 */
public class FileTodoItemRepositoryTest {
    @TempDir
    File tempDir;
    private File tempFile;
    private FileTodoItemRepository repository;

    @BeforeEach
    public void setUp() throws IOException {
        this.tempFile = File.createTempFile("file", "", tempDir);
        this.repository = new FileTodoItemRepository(this.tempFile);
    }

    // TODO test case
    // 1. 对于空的代办不应该查出任何项
    // 2. 已保存的代办可查出
    // 3. 可更新已存在项
    // 4. 不可保存空代办项

    @Test
    public void should_find_nothing_for_empty_repository() {
        Iterable<TodoItem> items = this.repository.findAll();
        assertThat(items).hasSize(0);
    }

    @Test
    public void should_find_saved_items() {
        this.repository.save(new TodoItem("foo"));
        this.repository.save(new TodoItem("bar"));
        final Iterable<TodoItem> items = this.repository.findAll();
        assertThat(items).hasSize(2);
        final TodoItem firstItem = Iterables.get(items, 0);
        assertThat(firstItem.getIndex()).isEqualTo(1);
        assertThat(firstItem.getContent()).isEqualTo("foo");
        final TodoItem secondItem = Iterables.get(items, 1);
        assertThat(secondItem.getIndex()).isEqualTo(2);
        assertThat(secondItem.getContent()).isEqualTo("bar");
    }

    @Test
    public void should_update_saved_items() {
        this.repository.save(new TodoItem("foo"));
        this.repository.save(new TodoItem("bar"));
        final Iterable<TodoItem> items = this.repository.findAll();
        final TodoItem toUpdate = Iterables.get(items, 0);
        toUpdate.markDone();
        this.repository.save(toUpdate);
        Iterable<TodoItem> updated = this.repository.findAll();
        assertThat(updated).hasSize(2);
        assertThat(Iterables.get(updated, 0).isDone()).isTrue();
    }

    @Test
    public void should_not_save_null_todo_item() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> this.repository.save(null));
    }

}
