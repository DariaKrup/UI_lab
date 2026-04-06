package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComDariaKrupMatrixFB8refsHeadsMain : GitVcsRoot({
    name = "https://github.com/DariaKrup/MatrixFB8#refs/heads/main"
    url = "https://github.com/DariaKrup/MatrixFB8"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_4b4df26346ed38498f51c0d6bee05baa:-1:cc977511-2e41-48c4-925b-fc8176819c57"
    }
    param("pipelines.connectionId", "PROJECT_EXT_130")
    param("tokenType", "refreshable")
})
