package com.skyworth.car.version;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CarVersionPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("carVersion", CarVersionExtension.class);
        
        project.getTasks().register("printCarVersion", PrintCarVersionTask.class, task -> {
            task.setDescription("Prints the car version information");
            task.setGroup("car");
        });
    }
}