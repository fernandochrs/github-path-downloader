/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.fc.githubdownloader

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import org.fc.githubdownloader.service.GithubRepoTokenEnvAccessor

object App {
    const val NAME = "Github Downloader"
    const val VERSION = "1.0.0"
}

fun main(args: Array<String>) {
    println("${App.NAME}:: ${App.VERSION}")

    val parser = ArgParser("${App.NAME}:: ${App.VERSION}")
    val version by parser.option(ArgType.Boolean, shortName = "v", description = "Version").default(false)

    parser.subcommands(DownloadCommand(GithubRepoTokenEnvAccessor()))
    parser.parse(args)

    if(version) println(App.VERSION)
}