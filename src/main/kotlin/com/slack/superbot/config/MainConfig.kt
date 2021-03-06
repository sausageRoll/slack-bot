package com.slack.superbot.config

import com.ullink.slack.simpleslackapi.SlackSession
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MainConfig {

    @Bean(initMethod = "connect", destroyMethod = "disconnect")
    fun session(@Value("\${slack.token}") token: String) : SlackSession =  SlackSessionFactory.createWebSocketSlackSession(token)!!

    @Bean
    fun httpClient() : HttpClient = HttpClientBuilder.create().build()
}