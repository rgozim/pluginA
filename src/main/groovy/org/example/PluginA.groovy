package org.example

import org.ajoberstar.reckon.gradle.ReckonExtension
import org.ajoberstar.reckon.gradle.ReckonPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginA implements Plugin<Project> {

    private Project project

    @Override
    void apply(Project project) {
        this.project = project

        // Apply reckon
        project.pluginManager.apply(ReckonPlugin)

        // Prefer patch as default scope
        project.ext.set("reckon.scope", "patch")

        project.extensions.getByType(ReckonExtension).with {
            scopeFromProp()
            snapshotFromProp()
        }
    }

}