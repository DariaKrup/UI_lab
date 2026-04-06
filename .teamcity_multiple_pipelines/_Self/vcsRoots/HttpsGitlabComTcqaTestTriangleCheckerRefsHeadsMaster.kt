package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGitlabComTcqaTestTriangleCheckerRefsHeadsMaster : GitVcsRoot({
    name = "https://gitlab.com/tcqa-test/triangle-checker#refs/heads/master"
    url = "https://gitlab.com/tcqa-test/triangle-checker"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_7e81d6fa8dde83e40639722fbfc63709:1:a02c0b51-bd3d-43ae-84d8-068552520f9d"
    }
    param("pipelines.connectionId", "PROJECT_EXT_886")
    param("tokenType", "refreshable")
})
