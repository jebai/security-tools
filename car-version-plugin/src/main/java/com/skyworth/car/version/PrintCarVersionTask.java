package com.skyworth.car.version;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class PrintCarVersionTask extends DefaultTask {
    @TaskAction
    public void printVersion() {
        CarVersionExtension extension = getProject().getExtensions().findByType(CarVersionExtension.class);
        System.out.println("Car Version Information:");
        System.out.println("  App Version: " + extension.getAppVersion());
        System.out.println("  Build Type: " + extension.getBuildType());
        System.out.println("  Flavor: " + extension.getFlavor());
    }
}