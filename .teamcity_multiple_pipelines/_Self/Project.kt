package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import _Self.pipelines.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({

    vcsRoot(HttpsGithubComDariaKrupMatrixFB8refsHeadsMain)
    vcsRoot(Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster)
    vcsRoot(HttpsGitlabComTcqaTestTriangleCheckerRefsHeadsMaster)
    vcsRoot(HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster)

    buildType(BuildTriangle)

    params {
        param("teamcity.internal.pipelines.creation.enabled", "true")
    }

    pipeline(CommandLineRunnerPipeline)
    pipeline(JavaMavenJunitPipeline)
    pipeline(MatrixFB8pipelines)
    pipeline(TriangleCheckerPipeline)
    pipeline(ProjectWithPipelinesXML_UiLabPipeline)
})
