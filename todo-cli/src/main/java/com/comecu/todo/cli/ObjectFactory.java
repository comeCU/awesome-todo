package com.comecu.todo.cli;

import com.comecu.todo.cli.file.FileTodoItemRepository;
import com.comecu.todo.core.service.TodoItemService;
import picocli.CommandLine;

import java.io.File;

/**
 * ObjectFactory
 *
 * @author comeCU
 * @date 2022/3/22 22:12
 */
public class ObjectFactory {
    public CommandLine createCommandLine(final File repositoryFile) {
        return new CommandLine(createTodoCommand(repositoryFile));
    }

    private TodoCommand createTodoCommand(final File repositoryFile) {
        final TodoItemService service = createService(repositoryFile);
        return new TodoCommand(service);
    }

    public TodoItemService createService(final File repositoryFile) {
        final FileTodoItemRepository repository = new FileTodoItemRepository(repositoryFile);
        return new TodoItemService(repository);
    }
}
