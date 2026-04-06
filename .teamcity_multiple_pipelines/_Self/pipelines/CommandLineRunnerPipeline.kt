package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object CommandLineRunnerPipeline : Pipeline({
    name = "Command Line Runner: pipeline"

    repositories {
        repository(_Self.vcsRoots.HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster)
    }

    triggers {
        vcs {
            branchFilter = """
                +:*
                +pr:*
            """.trimIndent()
        }
    }

    job(CommandLineRunnerPipeline_Job1)
})

object CommandLineRunnerPipeline_Job1 : Job({
    id("Job1")
    name = "Job CMD"

    steps {
        script {
            scriptContent = "sh ./echo.sh"
            dockerImage = "ubuntu:latest"
        }
    }
})
