import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

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

version = "2018.2"

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
    }

    vcs {
        root(HttpsGithubComJetTestSurefireGitRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            mavenVersion = bundled_3_5()
            localRepoScope = MavenBuildStep.RepositoryScope.BuildConfiguration
            jdkHome = "%env.JDK_18%"
        }
        maven {
            goals = "clean test"
            mavenVersion = bundled_3_5()
            localRepoScope = MavenBuildStep.RepositoryScope.Default
            jdkHome = "%env.JDK_18%"
        }
        maven {
            goals = "clean test"
            mavenVersion = bundled_3_5()
            localRepoScope = MavenBuildStep.RepositoryScope.Agent
            jdkHome = "%env.JDK_18%"
        }        maven {
            goals = "clean test"
            mavenVersion = bundled_3_5()
            jdkHome = "%env.JDK_18%"
        }
    }
})

object HttpsGithubComJetTestSurefireGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/jet-test/surefire.git#refs/heads/master"
    url = "https://github.com/jet-test/surefire.git"
})
