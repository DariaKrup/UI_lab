package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.schedule
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object TriangleCheckerPipeline : Pipeline({
    name = "Triangle Checker: pipeline"

    repositories {
        repository(_Self.vcsRoots.HttpsGitlabComTcqaTestTriangleCheckerRefsHeadsMaster)
    }

    params {
        param("parameter", "parameter")
    }

    triggers {
        vcs {
            branchFilter = """
                +:*
                +pr:*
            """.trimIndent()
        }
        schedule {
            branchFilter = ""
            triggerBuild = always()
            withPendingChangesOnly = false
            param("hour", "15")
            param("timezone", "Europe/Amsterdam")
            param("daysOfWeek", "Tuesday,Thursday")
            param("minute", "00")
            param("schedulingPolicy", "weekly-with-several-days")
        }
    }

    job(TriangleCheckerPipeline_Job1)
})

object TriangleCheckerPipeline_Job1 : Job({
    id("Job1")
    name = "Job Checked"
    allowReuse = false

    steps {
        maven {
            name = "clean test"
            goals = "clean test"
        }
    }
})
