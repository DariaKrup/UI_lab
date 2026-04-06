package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven

object BuildTriangle : BuildType({
    name = "Build: triangle"

    params {
        param("level", "build")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGitlabComTcqaTestTriangleCheckerRefsHeadsMaster)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }
})
