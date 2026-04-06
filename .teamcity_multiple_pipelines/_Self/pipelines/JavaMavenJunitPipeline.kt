package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object JavaMavenJunitPipeline : Pipeline({
    name = "Java Maven Junit: pipeline"

    repositories {
        repository(_Self.vcsRoots.Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster)
    }

    triggers {
        vcs {
            branchFilter = """
                +:*
                +pr:*
            """.trimIndent()
        }
    }

    job(JavaMavenJunitPipeline_Job1)
})

object JavaMavenJunitPipeline_Job1 : Job({
    id("Job1")
    name = "Maven job"
    allowReuse = false

    steps {
        maven {
            name = "clean test"
            goals = "clean test"
        }
    }
})
