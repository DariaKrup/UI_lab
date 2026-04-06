package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object ProjectWithPipelinesXML_UiLabPipeline : Pipeline({
    id("UiLabPipeline")
    name = "UI Lab: pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {
            branchFilter = """
                +:*
                +pr:*
            """.trimIndent()
        }
    }

    job(ProjectWithPipelinesXML_UiLabPipeline_Job1)
})

object ProjectWithPipelinesXML_UiLabPipeline_Job1 : Job({
    id("Job1")
    name = "Job 1"

    steps {
        script {
            name = "Check readme"
            scriptContent = "echo ./README.md"
        }
    }
})
