package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object MatrixFB8pipelines : Pipeline({
    name = "MatrixFB8: pipelines"

    repositories {
        repository(_Self.vcsRoots.HttpsGithubComDariaKrupMatrixFB8refsHeadsMain)
    }

    triggers {
        vcs {
            branchFilter = """
                +:*
                +pr:*
            """.trimIndent()
        }
    }

    job(MatrixFB8pipelines_Job1)
})

object MatrixFB8pipelines_Job1 : Job({
    id("Job1")
    name = "Job 1"

    steps {
        script {
            name = "CMD"
            scriptContent = "echo 'MSpec is outdated'"
        }
    }
})
