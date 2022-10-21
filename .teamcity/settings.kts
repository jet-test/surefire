import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.mavenArtifact
import jetbrains.buildServer.configs.kotlin.triggers.mavenSnapshot
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

project {
    vcsRoot(MavenTriggerVcs)
    buildType(Deploy)
    buildType(Trigger)
}

object Deploy : BuildType({
    name = "Deploy"

    vcs {
        root(MavenTriggerVcs)
    }

    params {
        text("system.spaceUrl", "", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("system.spaceUsername", "", display = ParameterDisplay.PROMPT, allowEmpty = true)
        text("system.spacePassword", "", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    steps {
        gradle {
            name = "publish"
            tasks = "clean build publish"
            workingDir = "internal-artifacts"
        }
    }
})

object Trigger : BuildType({
    name = "Test"

    vcs {
        root(MavenTriggerVcs)
    }

    params {
        text("spaceUrl", "", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    steps {
        maven {
            name = "test"
            goals = "clean test"
            runnerArgs = "-Dspace.url=%spaceUrl%"
        }
    }

    triggers {
        mavenArtifact {
            groupId = "one.trifle"
            artifactId = "trigger-utils"
            version = "[0.1,1)"
            repoUrl = "%space.nightly.url%"
        }
        mavenSnapshot {
            skipIfRunning = true
        }
    }
})

object MavenTriggerVcs : GitVcsRoot({
    name = "maven trigger vcs"
    url = "https://github.com/jet-test/surefire.git"
    branch = "refs/heads/maven-trigger"
})
