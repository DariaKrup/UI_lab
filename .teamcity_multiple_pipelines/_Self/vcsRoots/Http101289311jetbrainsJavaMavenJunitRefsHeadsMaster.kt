package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster : GitVcsRoot({
    name = "http://10.128.93.11/jetbrains/java-maven-junit#refs/heads/master"
    url = "http://10.128.93.11/jetbrains/java-maven-junit"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_7075199182e3b1a61fd3483ceb273d98:1:621d3883-9fd6-40c3-989f-25f6565cfc28"
    }
    param("pipelines.connectionId", "PROJECT_EXT_579")
    param("tokenType", "refreshable")
})
