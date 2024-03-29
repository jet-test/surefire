import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.04"

project {
    vcsRoot(HttpsGithubComJetTestSurefireGitRefsHeadsMaster)
    buildType(Test)
}

object Test : BuildType({
    name = "Test"

    artifactRules = """
        testng/target/surefire-testng-*.jar
        mixed/target/surefire-mixed-*.jar
        junit5/target/surefire-junit5-*.jar
        junit/target/surefire-junit-*.jar
    """.trimIndent()

    params {
        param("teamcity.maven.dontReadPomBeforeBuild", "false")
        param("branch_name", "change_config")
    }

    vcs {
        root(HttpsGithubComJetTestSurefireGitRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean package"
            mavenVersion = bundled_3_5()
        }
    }

    features {
        parallelTests {
            numberOfBatches = 2
        }
    }
})

object HttpsGithubComJetTestSurefireGitRefsHeadsMaster : GitVcsRoot({
    name = "surefire.git"
    url = "https://github.com/jet-test/surefire.git"
    param("useAlternates", "true")
    branchSpec = "+:refs/heads/*"
    branch = "refs/heads/master"
})
