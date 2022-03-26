package com.comecu.todo.cli;

import picocli.CommandLine;

import java.io.File;

/**
 * Bootstrap
 *
 * @author comeCU
 * @date 2022/3/16 23:25
 */
public class Bootstrap {
    public static void main(String[] args) {
        final File todoRepository = new File(todoHome(), "repository.json");
        ObjectFactory factory = new ObjectFactory();
        final CommandLine commandLine = factory.createCommandLine(todoRepository);
        commandLine.execute(args);
    }

    private static File todoHome() {
        final File homeDirectory = new File(System.getProperty("user.home"));
        final File todoHome = new File(homeDirectory, ".todo");
        if (!todoHome.exists()) {
            todoHome.mkdirs();
        }
        return todoHome;
    }
}
